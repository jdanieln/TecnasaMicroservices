
# Microservices Project with Spring Boot, Eureka, and API Gateway

## Overview

This project demonstrates the implementation of a microservices architecture using **Spring Boot**, **Eureka Server** for service discovery, and **Spring Cloud Gateway** as the API Gateway. We have two microservices: **Product Service** and **Inventory Service**, both registered with Eureka and accessible via the API Gateway.

## Project Structure

The project consists of the following services:

- **Eureka Server**: Manages the discovery and registration of microservices.
- **API Gateway**: Acts as a gateway, routing requests to the appropriate microservice.
- **Product Service**: Manages product-related data.
- **Inventory Service**: Handles inventory-related data.

### Directory Layout

```
/eureka-server       # Eureka service discovery
/api-gateway         # API Gateway service
/product-service     # Product microservice
/inventory-service   # Inventory microservice
```

## Requirements

Before running the project, ensure you have the following installed:

- **Java 17** or higher
- **Maven** (version 3.6.0 or higher)
- **PostgreSQL** (used by Product and Inventory services)

## Setup Instructions

### Step 1: Clone the repository

```bash
git clone <repository-url>
cd microservices-parent
```

### Step 2: Database Setup

1. Make sure PostgreSQL is running.
2. Create two databases for the microservices:
   ```sql
   CREATE DATABASE products_db;
   CREATE DATABASE inventory_db;
   ```

### Step 3: Configure Databases

For both **Product Service** and **Inventory Service**, update the PostgreSQL credentials in the `application.properties` or `application.yml` files.

For example, in `product-service/src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/products_db
    username: postgres
    password: <your-password>
```

### Step 4: Build the Project

Navigate to the root directory and build the entire project using Maven:

```bash
mvn clean install
```

### Step 5: Running the Services

Start the services in this order:

1. **Eureka Server**: Run the `EurekaServerApplication` class or use the following Maven command:

   ```bash
   cd eureka-server
   mvn spring-boot:run
   ```

   You can check Eureka at: `http://localhost:8761`

2. **Product Service**:

   ```bash
   cd ../product-service
   mvn spring-boot:run
   ```

3. **Inventory Service**:

   ```bash
   cd ../inventory-service
   mvn spring-boot:run
   ```

4. **API Gateway**:

   ```bash
   cd ../api-gateway
   mvn spring-boot:run
   ```

### Step 6: Accessing the Services

Now, you can access the microservices through the API Gateway:

- **Product Service**: `http://localhost:8080/products`
- **Inventory Service**: `http://localhost:8080/inventory`

### Eureka Dashboard

Visit `http://localhost:8761` to see the services registered in Eureka.

## API Endpoints

### Product Service

- **GET /products**: Fetches a list of all products.

### Inventory Service

- **GET /inventory**: Retrieves inventory information.

## Notes

- The API Gateway routes the requests to the respective services using Eureka for service discovery.
- Ensure all services are running before making API requests through the gateway.

## Troubleshooting

- If you receive a **503 Service Unavailable** error, check if the services are properly registered in **Eureka Server**.
- Ensure that **PostgreSQL** is running and the correct credentials are set in the configuration files.

## License

This project is for educational purposes.
