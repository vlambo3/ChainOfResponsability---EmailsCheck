public class ComercialHandler extends Handler {
    @Override
    public String handleRequest(Email email) {
        if (email.getSubject().equalsIgnoreCase("Comercial")||
                email.getDestination().equals("comerciala@colmena.com")) {
            return "El mail se envía a: comercial@colmena.com (Comercial)";
        } else {
            return nextHandler.handleRequest(email);
        }
    }
}
