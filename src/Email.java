public class Email {
    private String origin;
    private String destination;
    private String subject;

    public Email(String origin, String destination, String subject) {
        this.origin = origin;
        this.destination = destination;
        this.subject = subject;
    }

    public Email() {
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
