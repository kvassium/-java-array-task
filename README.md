# Array Task - Java Core Kick

Educational project for Java Core Kick course - Part I (Light).

## Description

This application demonstrates working with arrays in Java, implementing various array operations following best practices and design patterns.

## Features

- **Entity Class**: `NumberArray` - wrapper class for integer arrays
- **Search Service**: Find minimum and maximum values using Optional
- **Calculation Service**: Calculate sum and average using Optional
- **Sort Service**: Two sorting algorithms (Bubble Sort and Quick Sort)
- **File Reading**: Read array data from text files using Java 7+ NIO
- **Validation**: Custom validation for array data
- **Factory Pattern**: `NumberArrayFactory` for creating arrays
- **Builder Pattern**: `NumberArrayBuilder` for constructing arrays
- **Custom Exception**: `ArrayValidationException` for error handling
- **Logging**: Log4J2 for logging to console and file
- **Unit Tests**: JUnit 5 tests with high coverage

## Project Structure

```
array-task/
├── data/
│   └── array_data.txt          # Sample data file
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/epam/array/
│   │   │       ├── entity/     # Entity classes
│   │   │       ├── service/    # Service interfaces
│   │   │       │   └── impl/   # Service implementations
│   │   │       ├── factory/    # Factory and Builder
│   │   │       ├── validation/ # Validation classes
│   │   │       ├── reader/     # File reader
│   │   │       ├── exception/  # Custom exceptions
│   │   │       └── Main.java   # Main class
│   │   └── resources/
│   │       └── log4j2.xml      # Log4J2 configuration
│   └── test/
│       └── java/com/epam/array/ # Unit tests
├── pom.xml                      # Maven configuration
└── README.md
```

## Requirements

- Java 17 or higher
- Maven 3.6+

## Build and Run

```bash
# Build the project
mvn clean compile

# Run tests
mvn test

# Run the application
mvn exec:java -Dexec.mainClass="com.epam.array.Main"
```

Or manually:

```bash
# Compile
mvn clean package

# Run
java -jar target/array-task-1.0-SNAPSHOT.jar
```

## Data File Format

The data file (`data/array_data.txt`) can contain:
- Numbers separated by semicolons: `1; 2; 3`
- Numbers separated by commas: `1, 2, 3`
- Numbers separated by spaces: `1 2 3`
- Numbers separated by dashes: `1- 2 - 3`
- Empty lines (will be skipped)
- Invalid lines (will be skipped)

Example:
```
1; 2; 3
1, 2, x3, 6..5, 77

11- 2 - 42-
5, 10, 15, 20
```

## Technologies Used

- Java 17
- Maven
- Log4J2
- JUnit 5

## Code Conventions

The project follows:
- Java Code Convention
- Google Java Style Guide

## Author

Java Core Kick Course
