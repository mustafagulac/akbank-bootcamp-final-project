package com.mustafagulac.akbank_final_project.weatherapi.service;

import com.mustafagulac.akbank_final_project.weatherapi.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${openweathermap.apiKey}")
    private String apiKey;

    private final String API_BASE_URL = "http://api.openweathermap.org/data/2.5/forecast";

    public WeatherResponse getWeatherForecast(String city) {
        String apiUrl = API_BASE_URL + "?q=" + city + "&appid=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse response = restTemplate.getForObject(apiUrl, WeatherResponse.class);

        return response;
    }
}
