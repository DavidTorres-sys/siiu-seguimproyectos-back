**SIIU Seguimiento Proyectos Backend**

**Overview**

The backend of the SIIU project is a robust and scalable RESTful API built with Java 8 and Spring Boot. It provides essential services for data management within the administrative module of the system.

**Features**

- *RESTful API*: Scalable endpoints for frontend-backend communication.

- *Database Management*: Oracle integration with JPA/Hibernate ORM.

- *Containerization*: Docker support for deployment.

**Technologies Used**

- *Language*: Java 8

- *Framework*: Spring Boot

- *Database*: Oracle

- *Build Tool*: Maven

- *Containerization*: Docker, Docker Compose

**Architecture**

The backend architecture follows a layered approach:

- *Controller Layer*: Manages HTTP requests and responses.

- *Service Layer*: Contains business logic and service operations.

- *Repository Layer*: Interfaces with the Oracle database using JPA and Hibernate.

- *Entity Layer*: Defines the database models and relationships.

- *DTO & Mappers*: Uses Data Transfer Objects (DTOs) and Mappers to optimize data handling and transformation.

- *Configuration Layer*: Handles environment-specific configurations such as database connections, security settings, and API properties.

**System Components**

- *Spring Boot Application*: The core of the backend, managing request processing and business logic.

- *Oracle Database:* Stores application data with entity relationships mapped via Hibernate.

- *Docker*: Facilitates deployment using containerization for easy scaling and management.

- *REST API Endpoints*: Expose functionalities to the frontend and external systems.

- *Mappers & DTOs*: Improve efficiency by converting entities to lightweight DTOs before sending data to the frontend.

**Installation & Setup**

**Option 1: Manual Setup**

**Prerequisites**

Ensure you have the following installed:

- Java 8

- Maven

- Oracle Database (configured with necessary schemas)

**Setup Steps**

1. **Clone the repository**
    
    ```
    git clone https://github.com/DavidTorres-sys/siiu-seguimproyectos-back.git
   ```
2. **Navigate to the project directory**
    
    ```
    cd siiu-seguimproyectos-back
   ```
   
3. **Setup the environment variables**

    Create a `.env` file in the root directory and add the following environment variables:
    
    ```
    DB_URL=jdbc:oracle:thin:@localhost:1521:xe
    DB_USERNAME=your_username
    DB_PASSWORD=your_password
    ```
    
    the before `.env` was a example put the actual values of your database.

4. **Build the project**
    
    ```
    mvn clean install
   ```
5. **Run the project**
    
    ```
    mvn spring-boot:run
   ```
   

**Option 2: Docker-Based Setup**

**Prerequisites**

Ensure you have the following installed:

- Docker

- Oracle Database (configured with necessary schemas)

**Setup Steps**

1. **Clone the repository**

    ```
    git clone https://github.com/DavidTorres-sys/siiu-seguimproyectos-back.git
   ```
2. **Navigate to the project directory**

    ```
    cd siiu-seguimproyectos-back
   ```

3. **Setup the environment variables**

   Create a `.env` file in the root directory and add the following environment variables:

    ```
    DB_URL=jdbc:oracle:thin:@localhost:1521:xe
    DB_USERNAME=your_username
    DB_PASSWORD=your_password
    ```

   the before `.env` was a example put the actual values of your database.

4. **Build the project**

    ```
    docker-compose -f docker/compose.yaml build
   ```
5. **Run the project**

    ```
    docker-compose -f docker/compose.yaml up
   ```
