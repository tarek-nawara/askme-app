package edu.askme.services.services;

import edu.askme.controllers.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;

    private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);


    @Override
    @Async
    public void sendEmail(UserDTO user) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("noreply.active@gmail.com");
            helper.setTo(user.getEmail());
            helper.setSubject("Welcome to Active " +
                    user.getUsername());
            helper.setText("<html><body><img src='cid:activeLogo'>" +
                    "<h4>" + "Hello, " + user.getUsername() + "</h4>" +
                    "<i>" + " Your registration is successful" + "</i>" +
                    "</body></html>", true);
            ClassPathResource image = new ClassPathResource("static/active.png");
            helper.addInline("activeLogo", image);
        } catch (MessagingException e) {
            log.error("failed to send email to user " + user);
            e.printStackTrace();
        }
        mailSender.send(message);
    }
}
