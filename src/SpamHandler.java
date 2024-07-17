public class SpamHandler extends Handler {
    @Override
    public String handleRequest(Email email) {
        return "El mail se marca como SPAM.";
    }
}
