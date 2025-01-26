package com.blipay.credit_engine.service.creditAnalysis.mapper;

import com.blipay.credit_engine.domain.CreditAnalysisDomain;
import com.blipay.credit_engine.entity.creditAnalysis.CreditAnalysisEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditAnalysisMapper {
    CreditAnalysisEntity mappingCreditAnalysisEntityBy(CreditAnalysisDomain creditAnalysisDomain);

    CreditAnalysisDomain mappingCreditAnalysisDomainBy(CreditAnalysisEntity creditAnalysisEntity);
}
