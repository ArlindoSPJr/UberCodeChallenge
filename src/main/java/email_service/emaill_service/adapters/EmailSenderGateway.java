package email_service.emaill_service.adapters;


public interface EmailSenderGateway {
    void sendEmail(String to, String subject, String body);

}
