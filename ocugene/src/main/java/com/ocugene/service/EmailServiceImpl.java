package com.ocugene.service;

import com.ocugene.entity.nonFormEntities.VerificationCode;
import com.ocugene.exception.EmailFailureException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Service for handling emails being sent.
 */
@Service
public class EmailServiceImpl implements EmailService{

    /** The from address to use on emails. */
    @Value("${email.from}")
    private String fromAddress;

    /** The url of the front end for links. */
    @Value("${app.frontend.url}")
    private String url;

    /** The JavaMailSender instance. */
    private JavaMailSender javaMailSender;

    /**
     * Constructor for spring injection.
     * @param javaMailSender
     */
    public EmailServiceImpl(JavaMailSender javaMailSender) throws EmailFailureException {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendVerificationEmail(VerificationCode verificationCode) {
        try {
            String textBody = "Enter this code to reset your password: " + verificationCode.getCode() + ".Note that this code will expire after 1 day.";

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(verificationCode.getOcugeneUser().getEmail());
            helper.setFrom(fromAddress);
            helper.setSubject("Verification Code for Password Reset");

            helper.setText(textBody, true);

            javaMailSender.send(message);

        } catch (MessagingException ex) {
            throw new EmailFailureException("Failed to send verification email.", ex);
        }
    }
}
