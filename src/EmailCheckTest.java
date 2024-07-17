import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailCheckTest {

    private CheckEmail emailCheck;
    private final String EXPECTED_RESPONSE_MANAGEMENT = "El mail se envía a: gerencia@colmena.com (Gerencial)";
    private final String EXPECTED_RESPONSE_COMERCIAL = "El mail se envía a: comercial@colmena.com (Comercial)";
    private final String EXPECTED_RESPONSE_TECHNICAL = "El mail se envía a: tecnica@colmena.com (Técnico)";
    private final String EXPECTED_RESPONSE_SPAM = "El mail se marca como SPAM.";

    @BeforeEach
    void setUp() {
        emailCheck = new CheckEmail();

    }

    @Test
    @DisplayName("Should send email to Technical Department")
    public void mail2TechnicalEmail() {
        //arrange
        Email email = new Email("alejo@gmail.com", "tecnica@colmena.com", "Revisar PC");

        //act
        String emailProcessed = emailCheck.checkEmail(email);

        //assert
        assertEquals(EXPECTED_RESPONSE_TECHNICAL, emailProcessed);
    }

    @Test
    @DisplayName("Should send email to Commercial Department")
    public void mail2ComercialEmail() {
        //arrange
        Email email = new Email("alejo@gmail.com", "comerciall@colmena.com", "comercial");

        //act
        String emailProcessed = emailCheck.checkEmail(email);

        //assert
        assertEquals(EXPECTED_RESPONSE_COMERCIAL, emailProcessed);
    }

    @Test
    @DisplayName("Should send email to Management Department")
    public void mail2GerenciaEmail() {
        //arrange
        Email email = new Email("alejo@gmail.com", "gerencia@colmena.com", "gerencia");

        //act
        String emailProcessed = emailCheck.checkEmail(email);

        //assert
        assertEquals(EXPECTED_RESPONSE_MANAGEMENT, emailProcessed);
    }

    @Test
    @DisplayName("Should not throw exception for email to Management Department")
    public void mail2GerenciaEmailNotThrow() {
        //arrange
        Email email = new Email("origen@gmail.com", "destino@colmena.com", "Gerencia");

        //act and assert
        assertDoesNotThrow(() -> emailCheck.checkEmail(email));
    }

    @Test
    @DisplayName("Should correctly process email with 'Gerencia' subject")
    public void mail2GerenciaSubject() {
        //arrange
        Email email = new Email("origen@gmail.com", "destino@colmena.com", "Gerencia");

        //act
        String emailProcessed = emailCheck.checkEmail(email);

        //assert
        assertEquals(EXPECTED_RESPONSE_MANAGEMENT, emailProcessed);
    }

    @Test
    @DisplayName("Should correctly process email with 'comercial' subject")
    public void mail2ComercialSubject() {
        //arrange
        Email email = new Email("origen@gmail.com", "destino@colmena.com", "comercial");

        //act
        String emailProcessed = emailCheck.checkEmail(email);

        //assert
        assertEquals(EXPECTED_RESPONSE_COMERCIAL, emailProcessed);
    }

    @Test
    @DisplayName("Should correctly process email with 'técnico' subject")
    public void mail2TechnicalSubject() {
        //arrange
        Email email = new Email("origen@gmail.com", "destino@colmena.com", "técnico");

        //act
        String emailProcessed = emailCheck.checkEmail(email);

        //assert
        assertEquals(EXPECTED_RESPONSE_TECHNICAL, emailProcessed);
    }

    @Test
    @DisplayName("Email without specific destination")
    public void mail2Company() {
        //arrange
        Email email = new Email("origen@gmail.com", "destino@colmena.com", "Some subject");

        //act
        String emailProcessed = emailCheck.checkEmail(email);

        //assert
        assertEquals(EXPECTED_RESPONSE_SPAM, emailProcessed);
    }
}
