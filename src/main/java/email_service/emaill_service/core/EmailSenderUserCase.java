package email_service.emaill_service.core;

public interface EmailSenderUserCase {
    void sendEmail(String to, String subject, String body);
}
