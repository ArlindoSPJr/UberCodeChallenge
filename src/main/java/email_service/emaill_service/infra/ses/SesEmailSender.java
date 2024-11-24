package email_service.emaill_service.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import email_service.emaill_service.adapters.EmailSenderGateway;
import email_service.emaill_service.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService sesClient;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService sesClient) {
        this.sesClient = sesClient;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("arlindosergio317@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body)))
                        );
        try {
            this.sesClient.sendEmail(request);
        }catch (AmazonServiceException exception){
            throw new EmailServiceException("Failure while sending email", exception);
        }
    }
}
