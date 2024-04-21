package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.Rating;
import com.example.demo.repositry.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        if (!productRepository.existsById(id)) {
            return null;
        }
        product.setId(id);
        return productRepository.save(product);
    }

    public boolean deleteProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productRepository.deleteById(id);
            return true; // Deletion successful
        } else {
            return false; // Product not found, deletion failed
        }
    }
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }


    public Page<Product> getAllProductsPaged(int page, int size, String sortField, String sortOrder) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortField));
        return productRepository.findAll(pageable);
    }

    public Product rateProduct(Long productId, Rating rating) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
        	   rating.setProduct(product);
            List<Rating> ratings = product.getRatings();
            ratings.add(rating);
            product.setRatings(ratings);
            return productRepository.save(product);
        }
        return null;
    }
     public List<Product> searchProducts(String name, String category, String attribute) {
        // Check if any filter is provided
        if (name != null || category != null || attribute != null) {
            // Perform the search based on the provided filters
            return productRepository.findByFilters(name, category, attribute);
        } else {
            // If no filters are provided, return all products
            return productRepository.findAll();
        }
    }
}
