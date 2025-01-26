package com.blipay.credit_engine.usecase.creditAnalysis;

import com.blipay.credit_engine.domain.CreditAnalysisDomain;
import com.blipay.credit_engine.service.creditAnalysis.CreditAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCreditAnalysisUseCase {

    private final CreditAnalysisService service;

    @Autowired
    public GetCreditAnalysisUseCase(CreditAnalysisService service) {
        this.service = service;
    }

    public List<CreditAnalysisDomain> execute(String documentNumber) {
        return service.getCreditAnalysisByDocumentNumber(documentNumber);
    }
}
