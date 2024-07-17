public class EmailCheck {

    public String setEmail(Email email) {
        if (email.getSubject().equalsIgnoreCase("gerencia") ||
                email.getDestination().equalsIgnoreCase("gerencia@colmena.com")) {
            return "El mail se envía a: gerencia@colmena.com (Gerencial)";
        } else if (email.getSubject().equalsIgnoreCase("comercial") ||
                email.getDestination().equalsIgnoreCase("comercial@colmena.com")) {
            return "El mail se envía a: comercial@colmena.com (Comercial)";
        } else if (email.getSubject().equalsIgnoreCase("técnico") ||
                email.getDestination().equalsIgnoreCase("tecnica@colmena.com")) {
            return "El mail se envía a: tecnica@colmena.com (Técnico)";
        } else {
            return "El mail se marca como SPAM.";
        }
    }
}
