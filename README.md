# Music Catalog API

A RESTful API for managing a music catalog with albums and songs, built with Spring Boot and MongoDB.

## Features

- User authentication with JWT
- Role-based access control (USER/ADMIN)
- Album and Song management
- MongoDB database
- Docker containerization
- CI/CD with Jenkins
- API documentation with Swagger

## Technical Stack

- Java 17
- Spring Boot 3.2.3
- Spring Security with JWT
- MongoDB
- Docker & Docker Compose
- Jenkins
- Maven
- Swagger/OpenAPI

## Prerequisites

- Java 17
- Docker & Docker Compose
- MongoDB
- Maven

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/musiccatalog/
│   │       ├── config/         # Configuration classes
│   │       ├── controller/     # REST controllers
│   │       ├── dto/           # Data Transfer Objects
│   │       ├── exception/     # Custom exceptions
│   │       ├── mapper/        # DTO-Entity mappers
│   │       ├── model/         # Domain entities
│   │       ├── repository/    # MongoDB repositories
│   │       ├── security/      # Security configuration
│   │       ├── service/       # Business logic
│   │       └── util/          # Utility classes
│   └── resources/
│       ├── application.yml
│       ├── application-dev.yml
│       └── application-prod.yml
└── test/
    └── java/
        └── com/musiccatalog/
            └── ...            # Test classes
```

## Running the Application

### Local Development

```bash
# Run MongoDB
docker-compose up mongodb

# Run the application
./mvnw spring-boot:run -Dspring.profiles.active=prod
```

### Docker Deployment

```bash
# Build and run all services
docker-compose up --build
```

## API Documentation

Once the application is running, access the Swagger UI at:
http://localhost:8080/swagger-ui.html

## Security

The API uses JWT for authentication. To access protected endpoints:

1. Register a new user: POST /api/auth/register
2. Login to get JWT: POST /api/auth/login
3. Use the JWT in the Authorization header: `Bearer <token>`

## Available Profiles

- dev: Development profile with debug logging
- prod: Production profile with optimized settings

## Testing

```bash
# Run tests
./mvnw test
```

## CI/CD

The project includes a Jenkinsfile for automated:
- Building
- Testing
- Docker image creation
- Deployment

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit changes
4. Push to the branch
5. Create a Pull Request

