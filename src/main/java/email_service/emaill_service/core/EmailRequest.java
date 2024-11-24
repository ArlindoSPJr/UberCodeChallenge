package email_service.emaill_service.core;

public record EmailRequest(String to, String subject, String body) {
}
