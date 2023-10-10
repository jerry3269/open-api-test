package com.example.open_api_test.email.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class AuthCode {

    @Id
    private String authCode;
    private String email;
    private LocalDateTime expiryTime;

    private AuthCode(String authCode, String email) {
        this.authCode = authCode;
        this.email = email;
        this.expiryTime = LocalDateTime.now().plusMinutes(10);
    }

    public static AuthCode of(String authCode, String email) {
        return new AuthCode(authCode, email);
    }
}
