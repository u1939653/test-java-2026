# test-java-2026
## Description
Spring Boot REST API for managing brand products.


## Tech Stack
- Java 17
- Spring Boot 3.3.0
- Gradle 8
- H2 - Local Database
- JUnit - Testing


## Structure
### Source Code
The project follows an hexagonal architecture:
```
src/main/java/com/springboot/test/
├── adapter/            # External interfaces
│   ├── in/                 # Inbound adapters
│   │   ├── controller/         # Rest Controllers
│   │   ├── dto/                # Input/Output models (DTOs)
│   │   └── mapper/             # Mappers (domain/model to adapter/dto)
│   └── out/                # Outbound adapters
│       ├── entity/             # Outbound entities (db or otherwise)
│       └── repository/         # Outbound repositories
├── application/        # Application layer (Use cases, Ports)
│   ├── port/               # Port interfaces
│   │   ├── in/                 # Input ports (Use Cases)
│   │   └── out/                # Output ports
│   └── service/            # Use case implementations
└── domain/          # Domain layer (Business logic, Models)
    ├── model/          # Domain entities
    └── service/        # Domain services
```

### Tests
Tests can be located in:
```
src/test/java/com/springboot/test/
```
As of now, only controller tests are implemented.

### Local Database
Local database is implemented using H2.
Database structure definition can be found in:
```
src/main/resources/schema.sql
```

Sample data is located in:
```
src/main/resources/data.sql
```
The database is generated and filled with each application run, no external database setup is required.


## Installation
1. Clone the repository (https://github.com/u1939653/test-java-2026.git)
2. Open the project in your IDE
3. Open terminal inside `cd TestJava2026`
4. Run `./gradlew build` to compile
5. Run `./gradlew bootRun` to start the application
6. Use `./gradlew test` to run tests

## Development Options
### Health Check
The server includes a health check endpoint, accessible performing:
```
curl http://localhost:8080/test-java-2026/api/actuator/health
```

### Logging
By default at INFO level (no logs).
This can be configured in `src/main/resources/application.yml`:
```
logging:
    level:
        root: INFO
        com.springboot.test: INFO
```

### H2 Console
You can activate a console to check h2 database contents, but it is disabled by default. To enable it, set the following field to true in `application.yml`:
```
spring:
  h2:
    console:
      enabled: false
```

This will make the console available at:
```
http://localhost:8080/test-java-2026/api/h2-console/
```
Log in using the username and password defined in `application.yml` (spring datasource section).

## API Endpoints
### Get product's Price by Date (`GET /prices`)
#### Description:
- GETs a unique price for the product of a brand, in a specific date.
- If two or more prices are valid for the selected date, the one with the highest priority will be returned. 
- If no price is valid, an empty response will be returned.

#### Parameters: 
- `brandId`: Integer, required
- `productId`: Integer, required
- `date`: LocalDateTime, required

#### Sample request:
```
http://localhost:8080/test-java-2026/api/prices?brandId=1&productId=35455&date=2020-06-14T18:00:00
```

#### Sample output:
```
{
    "brandId": 1,
    "productId": 35455,
    "startDate": "2020-06-14T15:00:00",
    "endDate": "2020-06-14T18:30:00",
    "price": 25.45
}
```
