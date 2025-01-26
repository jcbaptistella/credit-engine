package com.blipay.credit_engine.client.weather.response;

import java.util.List;

public class WeatherFeignResponse {
    private Coord coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private Integer visibility;

    public Main getMain() {
        return main;
    }

    private Wind wind;
    private Clouds clouds;
    private Long dt;
    private Sys sys;
    private Integer timezone;
    private Long id;
    private String name;
    private Integer cod;

    public static class Coord {
        private Double lon;
        private Double lat;
    }

    public static class Weather {
        private Integer id;
        private String main;
        private String description;
        private String icon;
    }

    public static class Main {
        private Double temp;
        private Double feels_like;
        private Double temp_min;
        private Double temp_max;

        public Double getTemp() {
            return temp;
        }

        private Integer pressure;
        private Integer humidity;
        private Integer sea_level;
        private Integer grnd_level;
    }

    public static class Wind {
        private Double speed;
        private Integer deg;
    }

    public static class Clouds {
        private Integer all;
    }

    public static class Sys {
        private Integer type;
        private Integer id;
        private String country;
        private Long sunrise;
        private Long sunset;
    }
}
