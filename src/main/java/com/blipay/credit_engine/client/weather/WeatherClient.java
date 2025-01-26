package com.blipay.credit_engine.client.weather;


import com.blipay.credit_engine.client.weather.response.WeatherFeignResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weather-client", url = "${open-weather.url}")
@Headers("Content-Type: application/json")
public interface WeatherClient {

    @GetMapping("/weather")
    WeatherFeignResponse getWeatherBy(@RequestParam("q") String city, @RequestParam("units") String units, @RequestParam("appid") String apiKey);
}
