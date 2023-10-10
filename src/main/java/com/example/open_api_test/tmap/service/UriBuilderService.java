package com.example.open_api_test.tmap.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class UriBuilderService {

    @Value("${tmap.app.key}") private String TMAPKEY;

    public URI build(String searchKeyword) {
        return UriComponentsBuilder
                .fromHttpUrl("https://apis.openapi.sk.com/tmap/pois?version=1&&searchType=all&searchtypCd=A&reqCoordType=WGS84GEO&resCoordType=WGS84GEO&page=1&count=20&multiPoint=N&poiGroupYn=N")
                .queryParam("searchKeyword", searchKeyword)
                .queryParam("appKey", TMAPKEY)
                .encode()
                .build()
                .toUri();
    }
}
