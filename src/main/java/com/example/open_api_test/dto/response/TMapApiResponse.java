package com.example.open_api_test.dto.response;

import com.example.open_api_test.dto.TMapApiDto;

public record TMapApiResponse(
        String name,
        double latitude,
        double longitude,
        int zipCode
) {
    public static TMapApiResponse of(String name, double latitude, double longitude, int zipCode) {
        return new TMapApiResponse(name, latitude, longitude, zipCode);
    }

    public static TMapApiResponse from(TMapApiDto dto) {
        return TMapApiResponse.of(
                dto.name(),
                dto.noorLat(),
                dto.noorLon(),
                dto.zipCode()
        );
    }
}
