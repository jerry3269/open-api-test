package com.example.open_api_test.util.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String rootPage() {
        return "루트 페이지 입니다.";
    }
}
