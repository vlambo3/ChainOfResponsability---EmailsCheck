public class TechnicalHandler extends Handler {
    @Override
    public String handleRequest(Email email) {
        if (email.getSubject().equalsIgnoreCase("Técnico") ||
                email.getDestination().equals("tecnica@colmena.com")) {
            return "El mail se envía a: tecnica@colmena.com (Técnico)";
        } else {
            return nextHandler.handleRequest(email);
        }
    }
}
