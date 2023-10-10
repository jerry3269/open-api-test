package com.example.open_api_test.tmap.service;

import com.example.open_api_test.tmap.dto.response.TMapApiClientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class TMapApiService {

    private final RestTemplate restTemplate;
    private final UriBuilderService uriBuilderService;

    public TMapApiClientResponse getApi(String searchKeyword) throws Exception {
        URI uri = uriBuilderService.build(searchKeyword);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<TMapApiClientResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, TMapApiClientResponse.class);
        return responseEntity.getBody();
    }
}
