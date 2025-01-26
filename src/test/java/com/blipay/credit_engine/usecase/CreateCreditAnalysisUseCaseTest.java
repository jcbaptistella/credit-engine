package com.blipay.credit_engine.usecase;

import com.blipay.credit_engine.client.weather.response.WeatherFeignResponse;
import com.blipay.credit_engine.domain.CreditAnalysisDomain;
import com.blipay.credit_engine.service.creditAnalysis.CreditAnalysisService;
import com.blipay.credit_engine.service.creditAnalysis.dto.CreateCreditAnalysisDto;
import com.blipay.credit_engine.service.weatherService.WeatherService;
import com.blipay.credit_engine.usecase.creditAnalysis.CreateCreditAnalysisUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.blipay.credit_engine.helper.CreditAnalysisTestHelper.*;
import static com.blipay.credit_engine.helper.WeatherTestHelper.mockWeatherFeignResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CreateCreditAnalysisUseCaseTest {

    @InjectMocks
    private CreateCreditAnalysisUseCase createCreditAnalysisUseCase;

    @Mock
    private CreditAnalysisService creditAnalysisService;

    @Mock
    private WeatherService weatherService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should create a credit analysis when receive a request")
    public void execute() {
        CreateCreditAnalysisDto createCreditAnalysisDto = mockCreateCreditAnalysisDto();
        WeatherFeignResponse weatherFeignResponse = mockWeatherFeignResponse();
        CreditAnalysisDomain creditAnalysisDomain = mockCreditAnalysisDomain();

        when(weatherService.getWeatherByCity(createCreditAnalysisDto.getCity())).thenReturn(weatherFeignResponse);
        when(creditAnalysisService.createCreditAnalysis(any())).thenReturn(creditAnalysisDomain);

        createCreditAnalysisUseCase.execute(createCreditAnalysisDto);

        verify(weatherService, times(1)).getWeatherByCity(createCreditAnalysisDto.getCity());
        verify(creditAnalysisService, times(1)).createCreditAnalysis(any());
    }
}
