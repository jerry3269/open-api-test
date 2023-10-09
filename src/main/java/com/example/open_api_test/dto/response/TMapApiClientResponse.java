package com.example.open_api_test.dto.response;

import com.example.open_api_test.dto.TMapApiDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record TMapApiClientResponse(@JsonProperty("searchPoiInfo") SearchInfo searchInfo) {

    public List<TMapApiDto> getTMapApiDto() {
        return this.searchInfo().pois().tMapApiDto();
    }

    private record SearchInfo(@JsonProperty("pois") Pois pois) {
        private record Pois(@JsonProperty("poi") List<TMapApiDto> tMapApiDto) { }
    }
}
