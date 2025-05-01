# Stripe API Automation

This project implements automated tests for the Stripe Customer API using Java, Maven, TestNG, and RestAssured.

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- IDE (IntelliJ IDEA recommended)
- Allure Command Line Tool (optional, for serving reports)

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── stripe/
│   │           └── config/
│   │               └── Config.java
│   └── resources/
│       └── config.properties
└── test/
    └── java/
        └── com/
            └── stripe/
                ├── base/
                │   └── BaseTest.java
                ├── tests/
                │   ├── CreateCustomerTest.java
                │   ├── RetrieveCustomerTest.java
                │   ├── UpdateCustomerTest.java
                │   ├── ListCustomersTest.java
                │   ├── SchemaValidationTest.java
                │   └── DeleteCustomerTest.java
                ├── suites/
                │   └── CustomerTestSuite.java
                └── utils/
                    └── TestData.java
```

## Setup Instructions

1. Clone the repository
2. Open the project in your IDE
3. Make sure Maven dependencies are downloaded (IDE should do this automatically)
4. Update the API key in `src/main/resources/config.properties` if needed

### Optional: Install Allure Command Line Tool

If you want to serve Allure reports locally, install the Allure command line tool:

```bash
# For macOS (using Homebrew)
brew install allure

# For Windows (using Scoop)
scoop install allure

# For Linux
sudo apt-add-repository ppa:qameta/allure
sudo apt-get update
sudo apt-get install allure
```

## Running Tests

### Using Maven

Make sure you're in the project root directory (where `pom.xml` is located) when running these commands:

```bash
# Navigate to project root if you're not already there
cd /path/to/Stripe-API-Automation

# Run the complete test suite
mvn clean test -Dallure.results.directory=target/allure-results

# Generate Allure report
mvn allure:report
```

### Using IDE

1. Open the project in your IDE
2. Right-click on `testng.xml` in the project root
3. Select "Run 'testng.xml'"

## Test Organization

The project follows a modular test organization:

- **Base Tests**: Common setup and utilities in `BaseTest.java`
- **Individual Tests**: Separate test classes for each operation
- **Test Suites**: Organized test execution in `CustomerTestSuite.java`
- **Test Utilities**: Shared test data in `TestData.java`

## Test Scenarios

The test suite executes the following scenarios in order:

1. Create a Customer
2. Retrieve a Customer
3. Update a Customer
4. List All Customers
5. Schema Validation
6. Delete a Customer

## Test Reports

### Allure Reports

The project uses Allure for detailed test reporting. Each test includes:
- Request details (method, URL, headers, parameters, body)
- Response details (status code, headers, body)
- Test execution time
- Test status
- Test description and severity
- Test steps and execution flow

#### Generating Reports

```bash
# Generate Allure report
mvn allure:report
```

The reports will be generated in the `target/site/allure-maven-plugin` directory.

#### Viewing Reports

You can view the reports in two ways:

1. Open the generated HTML report:
   - Navigate to `target/site/allure-maven-plugin`
   - Open `index.html` in your web browser

2. Serve the report using Allure command line tool:
   ```bash
   allure serve target/allure-results
   ```

### Report Features

- **Test Overview**: Summary of test execution
- **Test Cases**: Detailed view of each test case
- **Graphs**: Visual representation of test results
- **Timeline**: Test execution timeline
- **Categories**: Test categorization
- **Suites**: Test suite organization
- **Attachments**: Request/response details and screenshots

## Dependencies

- RestAssured: For API testing and JSON handling
- TestNG: For test framework
- Allure: For test reporting
  - allure-testng: TestNG integration
  - allure-rest-assured: API request/response logging

## Notes

- The tests are designed to run in sequence (using TestNG priority)
- Each test cleans up after itself
- The schema validation test verifies the structure of the API response
- Allure reports include detailed API request/response information for debugging
