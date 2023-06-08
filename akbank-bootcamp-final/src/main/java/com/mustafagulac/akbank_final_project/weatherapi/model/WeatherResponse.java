package com.mustafagulac.akbank_final_project.weatherapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    @JsonProperty("list")
    private List<WeatherData> weatherDataList;

    public List<WeatherData> getWeatherDataList() {
        return weatherDataList;
    }

    public void setWeatherDataList(List<WeatherData> weatherDataList) {
        this.weatherDataList = weatherDataList;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class WeatherData {
    @JsonProperty("dt_txt")
    private String dateTime;

    @JsonProperty("main")
    private WeatherMain weatherMain;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public WeatherMain getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(WeatherMain weatherMain) {
        this.weatherMain = weatherMain;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class WeatherMain {
    @JsonProperty("temp")
    private double temperature;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;


    }


}