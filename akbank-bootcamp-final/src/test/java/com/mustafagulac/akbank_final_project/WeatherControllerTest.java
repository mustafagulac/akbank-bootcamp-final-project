package com.mustafagulac.akbank_final_project;

import com.mustafagulac.akbank_final_project.weatherapi.controller.WeatherController;
import com.mustafagulac.akbank_final_project.weatherapi.model.WeatherResponse;
import com.mustafagulac.akbank_final_project.weatherapi.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WeatherControllerTest {
    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherController weatherController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void testGetWeatherForecast_ReturnsWeatherResponse_WhenValidCity() {
        // Arrange
        String validCity = "Bursa";
        WeatherResponse weatherResponse = new WeatherResponse();
        when(weatherService.getWeatherForecast(validCity)).thenReturn(weatherResponse);

        // Act
        ResponseEntity<WeatherResponse> responseEntity = weatherController.getWeatherForecast(validCity);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(weatherResponse, responseEntity.getBody());
        verify(weatherService, times(1)).getWeatherForecast(validCity);
    }
}
