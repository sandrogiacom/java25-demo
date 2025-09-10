# Java 25 demo

This project is a demonstration of the new features in Java 25, using Kotlin, Gradle, and Spring Boot 4.

## Technologies Used

- Java 25
- Kotlin
- Spring Boot 4
- Gradle (Kotlin DSL)
- Docker Compose (optional)

## Project Structure

- `src/main/kotlin`: Main source code
- `src/test/kotlin`: Automated tests
- `build.gradle.kts`: Build configuration
- `compose.yaml`: Container orchestration (optional)

## How to Run Locally

1. Make sure you have Java 25 installed.
2. Run the following command to start the application:
    ```bash
    ./gradlew bootRun
    ```
3. Access `http://localhost:8080` to use the API.

## How to Run Tests

```bash
./gradlew test
```

## Using Docker Compose

If you want to run the project with dependencies via Docker Compose:

```bash
docker compose up
```

