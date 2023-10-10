package com.example.open_api_test.email.dto.response;

public record EmailVerifyResponse (
        int statusCode,
        String message
){
    public static EmailVerifyResponse of(int statusCode, String message) {
        return new EmailVerifyResponse(statusCode, message);
    }
}
