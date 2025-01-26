package com.blipay.credit_engine.service.creditAnalysis;

import com.blipay.credit_engine.domain.CreditAnalysisDomain;
import com.blipay.credit_engine.entity.creditAnalysis.CreditAnalysisEntity;
import com.blipay.credit_engine.repository.creditAnalysis.CreditAnalysisRepository;
import com.blipay.credit_engine.service.creditAnalysis.mapper.CreditAnalysisMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditAnalysisService {

    private final CreditAnalysisRepository repository;
    private final CreditAnalysisMapper mapper;

    public CreditAnalysisService(CreditAnalysisRepository repository, CreditAnalysisMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CreditAnalysisDomain createCreditAnalysis(CreditAnalysisDomain creditAnalysisDomain) {
        CreditAnalysisEntity creditAnalysisEntity = mapper.mappingCreditAnalysisEntityBy(creditAnalysisDomain);
        return mapper.mappingCreditAnalysisDomainBy(repository.save(creditAnalysisEntity));
    }

    public List<CreditAnalysisDomain> getCreditAnalysisByDocumentNumber(String documentNumber) {
        List<CreditAnalysisEntity> creditAnalysisEntityList = repository.findByDocumentNumber(documentNumber);
        return creditAnalysisEntityList.stream().map(mapper::mappingCreditAnalysisDomainBy).toList();
    }
}
