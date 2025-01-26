package com.blipay.credit_engine.helper;

import com.blipay.credit_engine.client.weather.response.WeatherFeignResponse;
import com.blipay.credit_engine.controller.creditAnalysis.response.CreditAnalysisResponse;
import com.blipay.credit_engine.domain.CreditAnalysisDomain;
import com.blipay.credit_engine.entity.creditAnalysis.CreditAnalysisEntity;
import com.blipay.credit_engine.service.creditAnalysis.dto.CreateCreditAnalysisDto;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class CreditAnalysisTestHelper {

    public static CreditAnalysisDomain mockCreditAnalysisDomain() {
        EasyRandomParameters parameters = new EasyRandomParameters();
        return new EasyRandom(parameters).nextObject(CreditAnalysisDomain.class);
    }

    public static CreditAnalysisResponse mockCreditAnalysisResponse() {
        EasyRandomParameters parameters = new EasyRandomParameters();
        return new EasyRandom(parameters).nextObject(CreditAnalysisResponse.class);
    }

    public static CreateCreditAnalysisDto mockCreateCreditAnalysisDto() {
        EasyRandomParameters parameters = new EasyRandomParameters();
        return new EasyRandom(parameters).nextObject(CreateCreditAnalysisDto.class);
    }

    public static CreditAnalysisEntity mockCreditAnalysisEntity() {
        EasyRandomParameters parameters = new EasyRandomParameters();
        return new EasyRandom(parameters).nextObject(CreditAnalysisEntity.class);
    }

}
