# ChallengeQE

## Coding Challenge

This project is a web automation solution designed to automate user interactions with the provided web page.
It was developed from scratch as part of a coding challenge for a QA Automation.

## Description

The project makes use of Java and Selenium. Selenium provides a simple API to write functional/acceptance tests using Selenium WebDriver, enabling direct calls to the browser using each browser’s native support for automation.

## Use Cases

### 1. User can open orders page and search for their order.
#### Acceptance Criteria
- A user can search by string
- A user can clear the search

### 2. User can open orders and filter for their order by Status.
#### Acceptance Criteria
- A user can filter orders by status 

### 3. User can open their Order Details.
#### Acceptance Criteria
- A user can view their Order Details, including a price breakdown

## Project Structure
![image](https://github.com/kevin-pacheco/ChallengeQE/assets/59073068/78997f2a-f1c8-48cb-8846-f7bf2072c31d)
- `src/test/java/features/`: Contains Gherkin feature files that define test scenarios.
- `src/test/java/pom/`: Contains page object models.
- `src/test/java/runner/`: Contains test runner and driver manager classes.
  - `src/test/java/runner/driverManager/`: Contains the driver management
  - `Testrunner.java`: Orchestrates the execution of Cucumber scenarios, allowing to define which feature files to run and configure test suite options.
- `src/test/java/seleniumgluecode/`: Contains the actual test code (glue code) and hooks.
  - `Background.java`: Contains shared step definitions and setup code that are common to multiple Cucumber scenarios.
  - `Hooks.java`: Contains setup and teardown code (e.g., Before and After hooks).
  - `OrdersPageSteps.java`: Contains the step definitions of Cucumber scenarios.
  - `TestBase.java`: Provides a base class for Page Factory init.
    
## Running tests
Follow these steps to run the automated tests:

1. **Prerequisites**:
   - Ensure you have the necessary prerequisites installed, including Java and Maven.
   - Make sure you have the WebDriver for your preferred browser (e.g., Chrome, Firefox) installed and configured.
2. **Clone the Repository**:
`git clone https://github.com/kevin-pacheco/ChallengeQE.git`
`cd ChallengeQE`

4. **Run Tests**:
- To run all tests, use the following command:
  ```
  mvn test
  ```

- To run specific Cucumber features, use tags or naming conventions. For example, to run tests tagged as `@FilterOrders`, use:
  ```
  mvn test -Dcucumber.filter.tags="@FilterOrders"
  ```
