package com.blipay.credit_engine.service;

import com.blipay.credit_engine.client.weather.WeatherClient;
import com.blipay.credit_engine.client.weather.response.WeatherFeignResponse;
import com.blipay.credit_engine.properties.WeatherProperty;
import com.blipay.credit_engine.service.weatherService.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.blipay.credit_engine.helper.WeatherTestHelper.mockWeatherFeignResponse;
import static org.mockito.Mockito.*;

public class WeatherServiceTest {

    @InjectMocks
    private WeatherService service;

    @Mock
    private WeatherClient weatherClient;

    @Mock
    private WeatherProperty weatherProperty;

    public static final String UNITS = "metric";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should get weather by city")
    public void getWeatherByCity() {
        String city = "campinas";
        String appId = "appId";
        WeatherFeignResponse weatherFeignResponse = mockWeatherFeignResponse();

        when(weatherProperty.getAppId()).thenReturn(appId);
        when(weatherClient.getWeatherBy(city, UNITS, appId)).thenReturn(weatherFeignResponse);

        service.getWeatherByCity(city);

        verify(weatherClient, times(1)).getWeatherBy(city, UNITS, appId);
    }
}
