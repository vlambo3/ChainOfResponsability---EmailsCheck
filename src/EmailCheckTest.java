import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailCheckTest {

    private EmailCheck emailCheck;

    @BeforeEach
    void setUp() {
        emailCheck = new EmailCheck();
    }

    @Test
    @DisplayName("Should send email to Technical Department")
    public void mail2TecnicaEmail() {
        //arrange
        Email email = new Email("alejo@gmail.com", "tecnica@colmena.com", "Revisar PC");
        EmailCheck emailCheck = new EmailCheck();

        String expectedResponse = "El mail se envía a: tecnica@colmena.com (Técnico)";
        //act
        String emailProcessed = emailCheck.setEmail(email);

        //assert
        assertEquals(expectedResponse, emailProcessed);
    }

    @Test
    @DisplayName("Should send email to Commercial Department")
    public void mail2ComercialEmail() {
        //arrange
        Email email = new Email("alejo@gmail.com", "comerciall@colmena.com", "comercial");

        EmailCheck emailCheck = new EmailCheck();

        String expectedResponse = "El mail se envía a: comercial@colmena.com (Comercial)";
        //act
        String emailProcessed = emailCheck.setEmail(email);

        //assert
        assertEquals(expectedResponse, emailProcessed);
    }

    @Test
    @DisplayName("Should send email to Management Department")
    public void mail2GerenciaEmail() {
        //arrange
        Email email = new Email("alejo@gmail.com", "gerencia@colmena.com", "gerencia");
        EmailCheck emailCheck = new EmailCheck();

        String expectedResponse = "El mail se envía a: gerencia@colmena.com (Gerencial)";
        //act
        String emailProcessed = emailCheck.setEmail(email);

        //assert
        assertEquals(expectedResponse, emailProcessed);
    }

    @Test
    @DisplayName("Should not throw exception for email to Management Department")
    public void mail2GerenciaEmailNotThrow() {
        //arrange
        Email email = new Email("origen@gmail.com", "destino@colmena.com", "Gerencia");

        //act and assert
        assertDoesNotThrow(() -> emailCheck.setEmail(email));
    }

    @Test
    @DisplayName("Should correctly process email with 'Gerencia' subject")
    public void mail2GerenciaSubject() {
        //arrange
        Email email = new Email("origen@gmail.com", "destino@colmena.com", "Gerencia");
        EmailCheck emailCheck = new EmailCheck();

        String expectedResponse = "El mail se envía a: gerencia@colmena.com (Gerencial)";
        //act
        String emailProcessed = emailCheck.setEmail(email);

        //assert
        assertEquals(expectedResponse, emailProcessed);
    }

    @Test
    @DisplayName("Should correctly process email with 'comercial' subject")
    public void mail2ComercialSubject() {
        //arrange
        Email email = new Email("origen@gmail.com", "destino@colmena.com", "comercial");
        EmailCheck emailCheck = new EmailCheck();

        String expectedResponse = "El mail se envía a: comercial@colmena.com (Comercial)";
        //act
        String emailProcessed = emailCheck.setEmail(email);

        //assert
        assertEquals(expectedResponse, emailProcessed);
    }

    @Test
    @DisplayName("Should correctly process email with 'técnico' subject")
    public void mail2TecnicoSubject() {
        //arrange
        Email email = new Email("origen@gmail.com", "destino@colmena.com", "técnico");
        EmailCheck emailCheck = new EmailCheck();

        String expectedResponse = "El mail se envía a: tecnica@colmena.com (Técnico)";
        //act
        String emailProcessed = emailCheck.setEmail(email);

        //assert
        assertEquals(expectedResponse, emailProcessed);
    }

}
