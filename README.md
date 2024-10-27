# Microservices Vehicle Management System

This repository contains a microservices-based application for managing vehicles, documents, trips, costs, and maintenance operations. Built with Spring Boot, Django, and Keycloak for security, it leverages a MySQL and H2 database setup, Eureka for service discovery, and an API Gateway for routing requests.

## Table of Contents
- [Architecture](#architecture)
- [Technologies Used](#technologies-used)
- [Microservices](#microservices)
- [Database Configuration](#database-configuration)
- [Security](#security)
- [Getting Started](#getting-started)
- [Endpoints](#endpoints)
- [Contributing](#contributing)
- [License](#license)

## Architecture
The system follows a microservices architecture, with each service handling a specific domain, such as vehicles, trips, costs, maintenance, and documents. The services communicate through REST APIs and are registered with Eureka for discovery.

![Class Diagram](https://github.com/mohamedTaamallah/SW_LockedOut_5SAE2/blob/main/image_2024-10-27_172620407.png) <!-- Update with the actual path to the diagram image in your repo -->

### Main Components:
- **Vehicle Service**: Manages vehicle details.
- **Document Service**: Handles documents related to vehicles.
- **Trip Service**: Manages trips associated with vehicles.
- **Cost Service**: Tracks expenses and costs related to vehicles.
- **Maintenance Service**: Manages maintenance schedules and logs for vehicles.

Each microservice is independently deployable, scalable, and uses Keycloak for authentication and authorization.

## Technologies Used
- **Java** (Spring Boot): Main framework for microservices.
- **Python** (Django): Used for one or more services as needed.
- **Keycloak**: Manages authentication and authorization.
- **MySQL**: Persistent data storage.
- **H2**: In-memory database for testing.
- **Eureka**: Service discovery.
- **Spring Cloud Gateway**: API gateway for request routing.

## Microservices
### 1. **Vehicle Service**
Manages vehicle information and relationships with other entities such as documents, costs, and trips.

### 2. **Document Service**
Handles documents associated with vehicles, including storage and retrieval.

### 3. **Trip Service**
Manages trip records, including start and end locations, fuel consumption, and mileage.

### 4. **Cost Service**
Keeps track of expenses related to each vehicle, including fuel, repairs, and other costs.

### 5. **Maintenance Service**
Logs maintenance records, including maintenance type, status, and associated costs.

## Database Configuration
The application uses MySQL for persistent data storage, with an H2 database available for testing purposes.

### MySQL
Ensure MySQL is installed and running. Configure connection details in each microservice's `application.properties` file.

### H2 Database
H2 is used for local testing and can be configured in the `application-test.properties` file.

## Security
The project uses Keycloak for managing users, roles, and authentication. The API Gateway is secured to ensure only authenticated users can access services.

1. **Keycloak Setup**: 
   - Install and configure Keycloak locally or connect to an existing Keycloak server.
   - Define client and roles for each microservice.

2. **Integration with Spring Boot**:
   - Each service validates JWT tokens issued by Keycloak.
   - Configure Keycloak properties in each service's `application.properties` file.

## Getting Started
### Prerequisites
- Java 17+
- Python 3.8+
- MySQL
- Docker (optional, for containerization)
- Keycloak server

