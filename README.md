## Branch: `chain-of-responsibility-2`

In the `chain-of-responsibility-2` branch, the constructor of the `CheckEmail` class has been updated to include the handler creation within the constructor itself. This simplifies the initialization process and makes it easier to set up the chain of responsibility when creating an instance of `CheckEmail`.

### Updated Class: CheckEmail

The `CheckEmail` class now initializes the chain of responsibility directly in the constructor.

### Constructor `CheckEmail()`:
- Initializes the chain of responsibility within the constructor.

```java
public class CheckEmail {
    private Handler chain;

    public CheckEmail() {
        Handler managerHandler = new ManagerHandler();
        Handler comercialHandler = new ComercialHandler();
        Handler technicalHandler = new TechnicalHandler();
        Handler spamHandler = new SpamHandler();

        managerHandler.setNextHandler(comercialHandler);
        comercialHandler.setNextHandler(technicalHandler);
        technicalHandler.setNextHandler(spamHandler);

        this.chain = managerHandler;
    }

    public String checkEmail(Email email) {
        return chain.handleRequest(email);
    }
}
```

This change ensures that the chain of responsibility is set up as soon as an instance of `CheckEmail` is created, without needing to call an additional method to create the chain.

### Testing

`JUnit 5` is used to test the implementation of the Chain of Responsibility pattern in the email handling system. The tests ensure that emails are correctly routed to the appropriate handlers based on their subject or destination.

## Contact

If you have any questions or need assistance with the project, feel free to contact me:

- **LinkedIn:** [Vanina Godoy](https://www.linkedin.com/in/vanina-a-godoy/?locale=en_US)
