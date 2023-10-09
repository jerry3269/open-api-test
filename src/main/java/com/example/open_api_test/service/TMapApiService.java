package com.example.open_api_test.service;

import com.example.open_api_test.dto.response.TMapApiClientResponse;
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

    @Value("${tmap.app.key}") private String TMAPKEY;

    public TMapApiClientResponse getApi(String searchKeyword) throws Exception {

        URI uri = UriComponentsBuilder.fromHttpUrl("https://apis.openapi.sk.com/tmap/pois?version=1&&searchType=all&searchtypCd=A&reqCoordType=WGS84GEO&resCoordType=WGS84GEO&page=1&count=20&multiPoint=N&poiGroupYn=N")
                .queryParam("searchKeyword", searchKeyword)
                .queryParam("appKey", TMAPKEY)
                .encode()
                .build()
                .toUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<TMapApiClientResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, TMapApiClientResponse.class);
        return responseEntity.getBody();
    }
}
