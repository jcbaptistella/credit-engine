package com.blipay.credit_engine.helper;

import com.blipay.credit_engine.client.weather.response.WeatherFeignResponse;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class WeatherTestHelper {

    public static WeatherFeignResponse mockWeatherFeignResponse() {
        EasyRandomParameters parameters = new EasyRandomParameters();
        return new EasyRandom(parameters).nextObject(WeatherFeignResponse.class);
    }
}
