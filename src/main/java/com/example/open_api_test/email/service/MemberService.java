package com.example.open_api_test.email.service;

import com.example.open_api_test.email.domain.AuthCode;
import com.example.open_api_test.email.domain.Member;
import com.example.open_api_test.email.repository.AuthCodeRepository;
import com.example.open_api_test.email.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.InstanceAlreadyExistsException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;


@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {

    private final MailService mailService;
    private final MemberRepository memberRepository;
    private final AuthCodeRepository authCodeRepository;

    @Transactional
    public void sendCodeToEmail(String email) throws Exception {
        this.checkDupEmail(email);
        String verificationCode = this.createCode();
        mailService.sendEmail(email, verificationCode);
        authCodeRepository.save(AuthCode.of(verificationCode, email));
    }

    private void checkDupEmail(String email) throws InstanceAlreadyExistsException {
        Optional<Member> member = memberRepository.findByEmail(email);
        if (member.isPresent()) {
            log.info("");
            throw new InstanceAlreadyExistsException("");
        }
    }

    private String createCode() throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        int authCode = random.nextInt(900000) + 100000;
        return String.valueOf(authCode);
    }

    @Transactional
    public Boolean verifyCode(String email, String verificationCode) throws InstanceAlreadyExistsException {
        this.checkDupEmail(email);
        AuthCode authCode = authCodeRepository.findById(verificationCode).orElseThrow(() -> new NoSuchElementException(""));
        if (authCode.getEmail().equals(email)) {
            if(LocalDateTime.now().isBefore(authCode.getExpiryTime())){
                authCodeRepository.delete(authCode);
                return true;
            }
        }
        authCodeRepository.delete(authCode);
        log.info("");
        throw new NoSuchElementException("");
    }
}
