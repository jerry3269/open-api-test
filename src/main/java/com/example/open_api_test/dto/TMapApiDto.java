package com.example.open_api_test.dto;

public record TMapApiDto(
        String name,
        double frontLat,
        double frontLon,
        double noorLat,
        double noorLon,
        int zipCode
) {
    public static TMapApiDto of(String name, double frontLat, double frontLon, double noorLat, double noorLon, int zipCode) {
        return new TMapApiDto(name, frontLat, frontLon, noorLat, noorLon, zipCode);
    }
}
