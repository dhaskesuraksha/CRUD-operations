# CRUD-operations
CRUD operations Using SpringBoot, MySQL

# Spring Boot CRUD Application with Pagination and One-to-Many Relationship
This project is a Spring Boot application that implements CRUD operations for managing categories and products. It includes features such as server-side pagination, one-to-many relationship between categories and products, and populating product details with respective category information.

Technologies Used
-Java
-Spring Boot
-Spring Data JPA
-Hibernate
-PostgreSQL (RDBMS)
-Maven

# API Endpoints
# Category Endpoints
1. GET all categories
   GET /api/categories?page={pageNumber}

2. Create a new category
   POST /api/categories

3. Get category by ID
   GET /api/categories/{id}

4. Update category by ID
   PUT /api/categories/{id}

5. Delete category by ID
   DELETE /api/categories/{id}

# Product Endpoints
1. GET all products
   GET /api/products?page={pageNumber}

   
2. Create a new product
   POST /api/products
   
3. Get product by ID
   GET /api/products/{id}

4. Update product by ID  
   PUT /api/products/{id}

5. Delete product by ID
   DELETE /api/products/{id}

  # One-to-Many Relationship
The relationship between categories and products is established as a one-to-many relationship, where one category can have multiple products.

# Server-side Pagination
Server-side pagination is implemented for both categories and products endpoints to efficiently handle large datasets.

# Populating Product Details
When fetching a single product, the response is populated with the respective category details.





  

  

