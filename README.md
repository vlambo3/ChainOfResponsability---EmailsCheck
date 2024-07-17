# Email Handling System with Chain of Responsibility Pattern

This branch `chain-of-responsibility` demonstrates the application of the Chain of Responsibility design pattern to process email requests within a company named Colmena. The system routes emails to appropriate departments based on their subject or destination.

## Overview

The Chain of Responsibility pattern is used to process a request by passing it through a series of handler objects. Each handler can independently decide whether to process the request or pass it to the next handler in the chain. This provides a flexible way to process requests without coupling the request sender to the request receivers.

## Abstract Class: `Handler`

The `Handler` class is an abstract class that defines the structure for handling email requests.

### Attributes

- **`protected Handler nextHandler`**:
  - A reference to the next handler in the chain.
  - **Access Modifier**: `protected` to allow subclasses and classes within the same package to access it directly, facilitating the implementation and extension of the pattern.

### Methods

- **`setNextHandler(Handler nextHandler)`**:
  - Sets the next handler in the chain if the current handler cannot process the request.
  - **Parameter**: `nextHandler` - the next handler in the chain.

- **`handleRequest(Email email)`**:
  - An abstract method that must be implemented by subclasses.
  - **Parameter**: `email` - the email being processed.

```java
public abstract class Handler {
    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract String handleRequest(Email email);
}
```

## Class: CheckEmail

The `CheckEmail` class checks the handling of emails based on their destination or subject. It creates a chain of handlers to process email requests.

### Attributes

- **`private Handler chain`**:
  - Represents the first handler in the chain of responsibility.

### Methods

- **`createChain()`**:
  - Creates the chain of responsibility by linking various handlers.
  - **Returns**: the first handler in the chain.

- **Constructor `CheckEmail()`**:
  - Initializes the chain of responsibility.

- **`checkEmail(Email email)`**:
  - Initiates the processing of an email through the chain of responsibility.
  - **Parameter**: `email` - the email being processed.
  - **Returns**: the result of the email handling.

```java
public class CheckEmail {
    private Handler chain;

    private Handler createChain() {
        Handler managerHandler = new ManagerHandler();
        Handler comercialHandler = new ComercialHandler();
        Handler technicalHandler = new TechnicalHandler();
        Handler spamHandler = new SpamHandler();

        managerHandler.setNextHandler(comercialHandler);
        comercialHandler.setNextHandler(technicalHandler);
        technicalHandler.setNextHandler(spamHandler);

        return managerHandler;
    }

    public CheckEmail() {
        this.chain = createChain();
    }

    public String checkEmail(Email email) {
        return chain.handleRequest(email);
    }
}
```

### Testing

`JUnit 5` is used to test the implementation of the Chain of Responsibility pattern in the email handling system. The tests ensure that emails are correctly routed to the appropriate handlers based on their subject or destination.

### Variant for the CheckMail class

Check the branch  `chain-of-responsibility-2` [Branch chain-of-responsability-2](https://github.com/vlambo3/ChainOfResponsability---EmailsCheck/tree/chain-of-responsability-2)

## Contact

If you have any questions or need assistance with the project, feel free to contact me:

- **LinkedIn:** [Vanina Godoy](https://www.linkedin.com/in/vanina-a-godoy/?locale=en_US)
