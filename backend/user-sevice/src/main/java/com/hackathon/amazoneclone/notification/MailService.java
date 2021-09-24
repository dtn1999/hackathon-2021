package com.hackathon.amazoneclone.notification;

import com.hackathon.amazoneclone.user.User;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Optional;

/**
 * @author danyls ngongang
 * @Created 24/09/2021-14:25
 * @Project user-service
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {
    private final SendGrid sendGrid;

    public Optional<String> sendMailToUser(@NotNull User user){
        Email from = new Email("tchekamboudanyls@gmail.com");
        Email to = new Email(user.getEmail());
        Mail mail = new Mail();
        Personalization personalization= new Personalization();
        personalization.addTo( to );
        personalization.addDynamicTemplateData("name", user.getName());
        mail.setFrom( from );
        mail.setSubject( "Verification Account ");
        mail.addPersonalization( personalization );
        mail.setTemplateId("d-318527adc8fe4ce5a22ad29c1c492b6b");

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
            log.info(response.getBody());
            return Optional.of(response.getBody());
        }catch (IOException ioException){
            log.error(ioException.getMessage());
            return  Optional.empty();
        }

    }

}
