public class ManagerHandler extends Handler {

    @Override
    public String handleRequest(Email email) {
        if (email.getSubject().equalsIgnoreCase("Gerencia")||
                email.getDestination().equals("gerencia@colmena.com")) {
            return "El mail se envía a: gerencia@colmena.com (Gerencial)";
        } else if (nextHandler != null) {
            return nextHandler.handleRequest(email);
        }
        return "El mail no pudo ser procesado.";
    }
}
