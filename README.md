# LeadToRev_Product_Catalog
This project implements a RESTful API for a product catalog system using Spring Boot.
# Prerequisites
Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 17 or higher installed on your machine.
- MySQL database installed and running.
- Your favorite IDE (Eclipse, etc.) or a text editor.

# Getting Started
Follow these steps to set up and run the application locally:

# 1. Clone the Repository
Clone the repository to your local machine:

(https://github.com/gadhari209/LeadToRev_Product_Catalog/)

# 2. Configure the Database
- Create a MySQL database named LeadToRev (or any other desired name).
- Update the database configuration in src/main/resources/application.properties with your database credentials:
<details>
<summary>Click to view database configuration</summary>

- spring.datasource.url=jdbc:mysql://localhost:3306/leadtorev1?sslMode=DISABLED
- spring.datasource.username=root  
- spring.datasource.password=password  
- spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver  
- spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
- spring.jpa.properties.hibernate.dialect.storage_engine=innodb
- spring.jpa.hibernate.ddl-auto=update

</details>

# 3. Run the Application
- Run the Spring Boot application using your eclipse
- Run project as spring Boot App
- The application should start on http://localhost:8080.

# API Documentation

The API endpoints and their expected request and response formats are documented in this section.

[API Documentation](#api-documentation)

# Database Seeding
You can seed the database with initial data using the provided SQL script in the [Instructions for Database Setup and Seeding](#database-seeding) section of the README file.


<a name="api-documentation"></a>
# 1. API Endpoints Documentation:
## a. Get All Products
- Endpoint: GET /products
- Request: None
- Response:
  - Status Code: 200 OK
  - Body: Array of Product objects
## b. Get All Products (Paged and Sorted)
- Endpoint: GET /products/paged
- Request:
  - Query Parameters:
    - page (int, optional): Page number (default: 0)
    - size (int, optional): Page size (default: 10)
    - sortField (string, optional): Field to sort by (default: id)
    - sortOrder (string, optional): Sort order (asc or desc, default: asc)
- Response:
  - Status Code: 200 OK
  - Body: Array of Product objects (paged and sorted)
## c. Get Product by ID
- Endpoint: GET /products/{id}
- Request: Path variable: id (Long)
- Response:
  -  Status Code: 200 OK
  -  Body: Product object
  -  tatus Code: 404 Not Found (if product with the given ID doesn't exist)
## d. Create Product
- Endpoint: POST /products
- Request:
  - Body: Product object (JSON)
- Response:
  - Status Code: 201 Created
  - Body: Created Product object
  - Status Code: 400 Bad Request (if request body is invalid)
## e. Update Product
- Endpoint: PUT /products/{id}
- Request:
  - Path variable: id (Long)
  - Body: Product object (JSON)
- Response:
  - Status Code: 200 OK
  - Body: Updated Product object
  - Status Code: 404 Not Found (if product with the given ID doesn't exist)
## f. Delete Product
- Endpoint: DELETE /products/{id}
- Request: Path variable: id (Long)
- Response:
  - Status Code: 204 No Content
  - Status Code: 404 Not Found (if product with the given ID doesn't exist)
## g. Rate Product
- Endpoint: POST /products/{productId}/ratings
- Request: 
   -  Path variable: productId (Long)
   -  Body: Rating object (JSON)
        - {  "userId": 123, "rating": 4, "comment": "Great product!"}
- Response:
  - Status Code: 200 OK
  -  Body: Updated Product object with the new rating
  - Status Code: 404 Not Found (if product with the given ID doesn't exist)

# 2. Product Entity Data Model Diagram:
### Product Entity

| Field          | Type             | Description                         |
|----------------|------------------|-------------------------------------|
| id             | Long (PK)        | Primary Key                         |
| name           | String           | Product Name                        |
| description    | String           | Product Description                 |
| price          | double           | Product Price                       |
| categories     | List<String>     | List of Categories for the Product  |
| attributes     | List<String>     | List of Attributes for the Product  |
| inStock        | boolean          | Availability Status                 |
| quantity       | int              | Available Quantity                  |
| ratings        | List<Rating>     | List of Ratings (OneToMany)         |

### Rating Entity

| Field          | Type             | Description                         |
|----------------|------------------|-------------------------------------|
| id             | Long (PK)        | Primary Key                         |
| userId         | Long             | User ID                             |
| rating         | int              | Rating (e.g., 1 to 5 stars)         |
| comment        | String           | User Comment                        |
| product        | Product          | Associated Product (ManyToOne)      |

### Availability (Embeddable)

| Field          | Type             | Description                         |
|----------------|------------------|-------------------------------------|
| inStock        | boolean          | Availability Status                 |
| quantity       | int              | Available Quantity                  |

