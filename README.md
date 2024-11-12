# E-commerce API

This is a simple RESTful API for managing a list of Products using Spring Boot and PostgreSQL.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Building the Project](#building-the-project)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Testing with Postman](#testing-with-postman)

## Prerequisites

Before you begin, ensure you have the following installed on your machine:

- [JDK 21](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Postman](https://www.postman.com/downloads/)

## Getting Started

1. **Configure the PostgreSQL database**

   Create a PostgreSQL database and update the `application.properties` file with your database details.

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/yourdbname
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.hibernate.ddl-auto=update
    ```

## Building the Project

1. **Navigate to the project directory**

    ```bash
    cd ecommerce-api
    ```

2. **Clean and build the project**

    ```bash
    ./mvnw clean install
    ```

## Running the Application

1. **Run the Spring Boot application**

    ```bash
    ./mvnw spring-boot:run
    ```

2. The application will start running at `http://localhost:8080`.

## API Endpoints

The API provides the following endpoints:

1. **Get All Products**
    - **Method**: GET
    - **URL**: `/api/products`
    - **Description**: Fetches all products.

2. **Get Product by ID**
    - **Method**: GET
    - **URL**: `/api/products/{id}`
    - **Description**: Fetches a product by its ID.
    - **Path Variable**: `id` (Type: Number)

3. **Create a New Product**
    - **Method**: POST
    - **URL**: `/api/products`
    - **Description**: Creates a new product.
    - **Body**:
        ```json
        {
          "name": "Tablet",
          "description": "A new tablet",
          "price": 300.00
        }
        ```

4. **Update an Existing Product**
    - **Method**: PUT
    - **URL**: `/api/products/{id}`
    - **Description**: Updates an existing product.
    - **Path Variable**: `id` (Type: Number)
    - **Body**:
        ```json
        {
          "name": "Gaming Laptop",
          "description": "A high performance gaming laptop",
          "price": 1500.00
        }
        ```

5. **Delete a Product by ID**
    - **Method**: DELETE
    - **URL**: `/api/products/{id}`
    - **Description**: Deletes a product by its ID.
    - **Path Variable**: `id` (Type: Number)

## Testing with Postman

To test the API endpoints, use the following Postman collection:

1. **Import the Postman Collection**
    - Open Postman.
    - Click on `Import` in the top left corner.
   