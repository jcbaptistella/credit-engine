package com.blipay.credit_engine.controller.creditAnalysis.mapper;

import com.blipay.credit_engine.controller.creditAnalysis.request.CreateCreditAnalysisRequest;
import com.blipay.credit_engine.controller.creditAnalysis.response.CreditAnalysisResponse;
import com.blipay.credit_engine.domain.CreditAnalysisDomain;
import com.blipay.credit_engine.service.creditAnalysis.dto.CreateCreditAnalysisDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditAnalysisControllerMapper {
    CreateCreditAnalysisDto mappingCreditAnalysisDtoBy(CreateCreditAnalysisRequest request);

    CreditAnalysisResponse mappingCreditAnalysisResponseBy(CreditAnalysisDomain creditAnalysisDomain);
}
