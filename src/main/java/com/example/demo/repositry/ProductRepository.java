package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);
    @Query("SELECT p FROM Product p WHERE " +
            "(:name IS NULL OR p.name = :name) AND " +
            "(:category IS NULL OR :category MEMBER OF p.categories) AND " +
            "(:attribute IS NULL OR :attribute MEMBER OF p.attributes)")
    List<Product> findByFilters(@Param("name") String name,
                                @Param("category") String category,
                                @Param("attribute") String attribute);
}

