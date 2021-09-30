package com.hackathon.amazoneclone.notification;

import com.hackathon.amazoneclone.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
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

    private  final JavaMailSender javaMailSender;

    public Optional<String> sendMailToUser(@NotNull User user){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(user.getEmail());

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);
        return Optional.empty();
    }

}
