public class TechnicalHandler extends Handler {
    @Override
    public String handleRequest(Email email) {
        if (email.getSubject().equalsIgnoreCase("Técnico") ||
                email.getDestination().equals("tecnica@colmena.com")) {
            return "El mail se envía a: tecnica@colmena.com (Técnico)";
        } else if (nextHandler != null) {
            return nextHandler.handleRequest(email);
        }
        return "El mail no pudo ser procesado.";
    }
}
