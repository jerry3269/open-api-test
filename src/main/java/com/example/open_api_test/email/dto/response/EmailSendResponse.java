package com.example.open_api_test.email.dto.response;

public record EmailSendResponse(
        int statusCode,
        String message
) {
    public static EmailSendResponse of (int statusCode, String message) {
        return new EmailSendResponse(statusCode, message);
    }
}
