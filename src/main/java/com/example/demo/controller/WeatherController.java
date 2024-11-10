package com.example.demo.controller;

import com.example.demo.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/api/v1/weather")
    public ResponseEntity<String> getWeather(
            @RequestParam double latitude,
            @RequestParam double longitude
    ) {
        String weatherData = weatherService.getWeatherData(latitude, longitude);
        return ResponseEntity.ok(weatherData);
    }
}
