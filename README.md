
# UserEntity API - Spring Boot Application

## Project Overview

This is a Spring Boot application that manages `UserEntity` records. It includes CRUD operations for users and integrates an external weather API to retrieve live weather data based on location coordinates. The application connects to a MySQL database and includes a Postman collection to facilitate testing.

## Prerequisites

- **Java 17** or higher
- **MySQL** database
- **Postman** (optional, for testing the API)
- **Git** (optional, to clone the repository)

## Setup Instructions

### 1. Database Configuration

1. **Create a MySQL Database**:
    - Open MySQL and create a database named `testdb`:
      ```sql
      CREATE DATABASE testdb;
      ```

2. **Configure Database Credentials**:
    - In the `application.properties` file, update the MySQL username and password if they differ from `root` and `password`:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/testdb
      spring.datasource.username=root
      spring.datasource.password=password
      ```

### 2. Build and Run the Application

1. **Clone the Repository**:
   ```bash
   git clone <your-repository-url>
   cd <your-project-folder>
   ```

2. **Build the Project**:
    - Using Gradle (in the project directory):
      ```bash
      ./gradlew build
      ```

3. **Run the Application**:
    - Start the application:
      ```bash
      ./gradlew bootRun
      ```
    - The server will start at `http://localhost:8080`.

### 3. Test the API with Postman

1. **Import Postman Collection**:
    - Open Postman, go to **File > Import**.
    - Select the `Maybank API Collections.postman_collection.json` file from this repository.

2. **Use Endpoints**:
    - After importing, you will see the collection with the following endpoints ready for testing:

   | Endpoint                        | HTTP Method | Description                                   |
      |---------------------------------|-------------|-----------------------------------------------|
   | `/api/v1/users`                 | `POST`      | Create a new user                             |
   | `/api/v1/users?page=0&size=10`  | `GET`       | Retrieve a paginated list of users            |
   | `/api/v1/users/{id}`            | `GET`       | Get details of a specific user by ID          |
   | `/api/v1/users/{id}`            | `PUT`       | Update a specific user by ID                  |
   | `/api/v1/weather`               | `GET`       | Retrieve live weather data by coordinates     |

### API Endpoints Guide

#### 1. Create a User
- **Endpoint**: `POST /api/v1/users`
- **Body** (JSON):
  ```json
  {
      "name": "John Doe",
      "email": "johndoe@example.com",
      "age": 30
  }
  ```

#### 2. Retrieve Users with Pagination
- **Endpoint**: `GET /api/v1/users?page=0&size=10`
- Retrieves a list of users, 10 users per page.

#### 3. Get User by ID
- **Endpoint**: `GET /api/v1/users/{id}`
- Replace `{id}` with the user’s ID to fetch their information.

#### 4. Update User
- **Endpoint**: `PUT /api/v1/users/{id}`
- **Body** (JSON):
  ```json
  {
      "name": "Jane Doe",
      "email": "janedoe@example.com",
      "age": 28
  }
  ```
- Replace `{id}` with the user’s ID to update their information.

#### 5. Get Weather Data
- **Endpoint**: `GET /api/v1/weather?latitude={latitude}&longitude={longitude}`
- Replace `{latitude}` and `{longitude}` with desired coordinates (e.g., for Kuala Lumpur: `latitude=3.1390&longitude=101.6869`).

### Project Structure

```plaintext
src
├── main
│   ├── java
│   │   └── com.example.yourproject
│   │       ├── controller       # API controllers
│   │       ├── service          # Business logic
│   │       ├── repository       # Database access
│   │       ├── entity           # Entity classes for database tables
│   │       ├── util             # Utilities (like logging setup)
│   └── resources
│       ├── application.properties
├── test
│   └── java                     # Unit and integration tests
```

### Technologies Used

- **Java** (v17)
- **Spring Boot** (v3.3.5)
- **Spring Data JPA** (for data persistence)
- **MySQL** (Database)
- **Open-Meteo API** (for live weather data)
- **Postman** (for API testing)

### Notes

- The application automatically logs request and response data for easy tracking.
- Transactions are managed with `@Transactional` in service methods for database consistency.
- Weather data is fetched from the Open-Meteo API and may vary based on location input.

### Troubleshooting

- **Database Connection Errors**:
    - Ensure that MySQL is running and `testdb` database exists.
    - Verify credentials in `application.properties`.

- **API Not Responding**:
    - Check if the server is running on `http://localhost:8080`.
    - Ensure the correct endpoint is used in Postman.

---
