package com.crud.tasks.services;

import com.crud.tasks.domain.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.Optional;
@Service
public class SimpleEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleEmailService.class);

    @Autowired
    JavaMailSender javaMailSender;

    public void send(final Mail mail) {
        try {
            SimpleMailMessage mailMessage = createMailMessage(mail);
            javaMailSender.send(mailMessage);
            LOGGER.info("Email has been sent.");
        } catch (MailException e) {
            LOGGER.error("Failed to procces e-mail sending: ", e.getMessage());
        }
    }

    private SimpleMailMessage createMailMessage(Mail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        if(mail.getToCc() == null){
            LOGGER.info("There are no additional recipients");
        }else{
            mailMessage.setCc(mail.getToCc());
        }
        return mailMessage;
    }
}
