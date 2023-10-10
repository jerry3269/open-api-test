package com.example.open_api_test.email.controller;

import com.example.open_api_test.email.dto.response.EmailSendResponse;
import com.example.open_api_test.email.dto.response.EmailVerifyResponse;
import com.example.open_api_test.email.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/email")
@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/send-email")
    public EmailSendResponse sendMessage(@RequestParam("email") String email) throws Exception {
        memberService.sendCodeToEmail(email);

        return EmailSendResponse.of(200, "이메일 인증코드를 전송했습니다.");
    }

    @GetMapping("/verification-code")
    public EmailVerifyResponse verifyAuthCode(@RequestParam("email") String email,
                                              @RequestParam("code") String authCode) throws Exception {
        Boolean result = memberService.verifyCode(email, authCode);

        if (result) return EmailVerifyResponse.of(200, "이메일 인증에 성공하였습니다.");
        else return EmailVerifyResponse.of(300, "이메일 인증에 실패했습니다.");
    }
}
