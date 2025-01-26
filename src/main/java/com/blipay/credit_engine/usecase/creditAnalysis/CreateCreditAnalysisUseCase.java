package com.blipay.credit_engine.usecase.creditAnalysis;

import com.blipay.credit_engine.client.weather.response.WeatherFeignResponse;
import com.blipay.credit_engine.domain.CreditAnalysisDomain;
import com.blipay.credit_engine.service.creditAnalysis.CreditAnalysisService;
import com.blipay.credit_engine.service.creditAnalysis.dto.CreateCreditAnalysisDto;
import com.blipay.credit_engine.service.weatherService.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCreditAnalysisUseCase {

    private final CreditAnalysisService service;
    private final WeatherService weatherService;

    @Autowired
    public CreateCreditAnalysisUseCase(CreditAnalysisService service, WeatherService weatherService) {
        this.service = service;
        this.weatherService = weatherService;
    }

    public CreditAnalysisDomain execute(CreateCreditAnalysisDto creditAnalysisDto) {
        WeatherFeignResponse weatherFeignResponse = weatherService.getWeatherByCity(creditAnalysisDto.getCity());

        final CreditAnalysisDomain creditAnalysisDomain = CreditAnalysisDomain.request(
                creditAnalysisDto.getDocumentNumber(),
                creditAnalysisDto.getName(),
                creditAnalysisDto.getAge(),
                creditAnalysisDto.getIncome(),
                weatherFeignResponse.getMain().getTemp()
        );

        return service.createCreditAnalysis(creditAnalysisDomain);
    }
}
