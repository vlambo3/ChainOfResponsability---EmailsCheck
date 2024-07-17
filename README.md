# Chain of Responsibility Pattern Example

## Overview

This repository contains an example of how to apply the Chain of Responsibility pattern in Java. The `main` branch contains the development without applying the pattern, while the `chain-of-responsibility` branch contains the same development with the pattern applied.

## Branches

- **`main`**: Development without the Chain of Responsibility pattern.
- **`chain-of-responsibility`**: Development applying the Chain of Responsibility pattern.

## Objective

To design a UML diagram and implement the Chain of Responsibility pattern in Java based on the following scenario.

## Scenario

At the company called Colmena, there are three departments: Management, Sales, and Technical. When they receive an email (in their colmena.com domain), they want it to be controlled according to the company's AI rules and sent to the appropriate department.

We will simulate this control with the following assumptions:

### Email Routing Rules

| Subject    | Destination Email           | Department   |
|------------|-----------------------------|--------------|
| Management | gerencia@colmena.com        | Management   |
| Sales      | comercial@colmena.com       | Sales        |
| Technical  | tecnica@colmena.com         | Technical    |
| Any other  | Any other                   | Marked as SPAM |

The program will display where the email is received in each case. The email belongs to a class called `Email`, which has three string attributes: origin, destination, and subject.

## Implementation

A class named `EmailCheck` is created to build a chain of responsibilities. This class checks each element (part of the chain). If the email is for Management, it informs accordingly. If not, it continues to the next check, which tests if it is for Technical, and so on until it determines the appropriate department or marks the email as spam.

### Tests

JUnit 5 tests are used to ensure the quality of the `setEmail()` method in the `CheckEmail` class. These tests validate that emails are correctly routed to the appropriate departments or marked as spam when necessary.

## How to Run

1. **Clone the repository**:
    ```sh
    git clone https://github.com/vlambo3/ChainOfResponsability---EmailsCheck
    ```

2. **Checkout the desired branch**:
    - For development without the pattern:
        ```sh
        git checkout main
        ```
    - For development with the Chain of Responsibility pattern:
        ```sh
        git checkout chain-of-responsibility
        ```

3. **Build and run the project**:
    - Ensure you have Java and Maven installed.
    - Navigate to the project directory and execute:
        ```sh
        mvn clean install
        mvn exec:java -Dexec.mainClass="com.colmena.Main"
        ```

4. **Run tests**:
    ```sh
    mvn test
    ```

## Conclusion

This example demonstrates the application of the Chain of Responsibility pattern in a real-world scenario. The use of JUnit 5 tests ensures that the email processing logic is robust and reliable. By comparing the two branches, developers can understand the benefits and implementation details of the Chain of Responsibility pattern.

## Contact

If you have any questions or need assistance with the project, feel free to contact me:

- **LinkedIn:** [Vanina Godoy](https://www.linkedin.com/in/vanina-a-godoy/?locale=en_US)
