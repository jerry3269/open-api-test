package com.example.open_api_test.email.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MailService {

    private final JavaMailSender mailSender;
    private static final String TITLE = "이메일 인증 서비스 인증코드";

    public void sendEmail(String email, String verificationCode) {
        SimpleMailMessage mailForm = createMailForm(email, verificationCode);
        mailSender.send(mailForm);
    }

    private SimpleMailMessage createMailForm(String email, String verificationCode) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject(TITLE);
        simpleMailMessage.setText(verificationCode);
        return simpleMailMessage;
    }
}
