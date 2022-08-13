## Small project to exercise Spring Data JDBC

The goal of this project is to test basic functionalities of Spring Data JDBC utilities.

Current exercises in scope:
- use basic CRUD repository functionalities
- explore usage of foreign keys
- start with database down

### Run locally with embedded database:
```./mvnw spring-boot:run -Pdev```

### Building image to run in docker-compose:
```./mvnw spring-boot:build-image -Ptest```

### Run in docker-compose with MySQL database:
```docker-compose up```
