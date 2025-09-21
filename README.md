# Rest Assured Framework

This project is a Rest Assured framework for testing RESTful APIs. It provides a structured approach to writing and executing API tests using Java and Maven.

## Project Structure

```
rest-assured-framework
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── example
│   │               ├── tests
│   │               │   └── ApiTest.java
│   │               └── utils
│   │                   └── RestUtils.java
│   ├── test
│   │   └── java
│   │       └── com
│   │           └── example
│   │               └── tests
│   │                   └── ApiTestSuite.java
├── pom.xml
└── README.md
```

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <repository-url>
   cd rest-assured-framework
   ```

2. **Build the project:**
   Ensure you have Maven installed. Run the following command to build the project:
   ```
   mvn clean install
   ```

3. **Run the tests:**
   You can run the tests using Maven:
   ```
   mvn test
   ```

## Usage Examples

- **ApiTest.java**: This class contains methods for testing various API endpoints. Each method is annotated with `@Test` and includes the logic for sending requests and validating responses.

- **RestUtils.java**: This utility class provides methods for setting up request specifications, sending requests, and parsing responses. It simplifies the process of making HTTP calls.

- **ApiTestSuite.java**: This test suite groups multiple test classes for execution. It allows you to run a set of tests together, making it easier to manage and execute related tests.

## Dependencies

This project uses the following dependencies:
- Rest Assured for API testing
- JUnit for test execution

Make sure to check the `pom.xml` file for the complete list of dependencies and their versions.

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue for any enhancements or bug fixes.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.