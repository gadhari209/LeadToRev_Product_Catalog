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


