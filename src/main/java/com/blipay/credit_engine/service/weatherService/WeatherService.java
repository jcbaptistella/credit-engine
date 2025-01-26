package com.blipay.credit_engine.service.weatherService;

import com.blipay.credit_engine.client.weather.WeatherClient;
import com.blipay.credit_engine.client.weather.response.WeatherFeignResponse;
import com.blipay.credit_engine.properties.WeatherProperty;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    public static final String UNITS = "metric";

    public WeatherService(WeatherClient weatherClient, WeatherProperty weatherProperty) {
        this.weatherClient = weatherClient;
        this.weatherProperty = weatherProperty;
    }

    private final WeatherClient weatherClient;

    private final WeatherProperty weatherProperty;

    public WeatherFeignResponse getWeatherByCity(String city) {
        return weatherClient.getWeatherBy(city, UNITS, weatherProperty.getAppId());
    }
}
