package com.example.open_api_test.controller;

import com.example.open_api_test.dto.response.TMapApiClientResponse;
import com.example.open_api_test.service.TMapApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/tmap")
@RestController
public class TMapApiController {

    private final TMapApiService tMapApiService;

    @GetMapping("/{searchKeyword}")
    public TMapApiClientResponse getApi(@PathVariable String searchKeyword) throws Exception {
        return tMapApiService.getApi(searchKeyword);

    }
}
