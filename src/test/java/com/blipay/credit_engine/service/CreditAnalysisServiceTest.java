package com.blipay.credit_engine.service;

import com.blipay.credit_engine.domain.CreditAnalysisDomain;
import com.blipay.credit_engine.entity.creditAnalysis.CreditAnalysisEntity;
import com.blipay.credit_engine.repository.creditAnalysis.CreditAnalysisRepository;
import com.blipay.credit_engine.service.creditAnalysis.CreditAnalysisService;
import com.blipay.credit_engine.service.creditAnalysis.mapper.CreditAnalysisMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static com.blipay.credit_engine.helper.CreditAnalysisTestHelper.mockCreditAnalysisDomain;
import static com.blipay.credit_engine.helper.CreditAnalysisTestHelper.mockCreditAnalysisEntity;
import static org.mockito.Mockito.*;

public class CreditAnalysisServiceTest {

    @InjectMocks
    private CreditAnalysisService service;

    @Mock
    private CreditAnalysisRepository repository;

    @Spy
    private CreditAnalysisMapper mapper = Mappers.getMapper(CreditAnalysisMapper.class);

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should create a credit analysis")
    public void createCreditAnalysis() {
        CreditAnalysisDomain creditAnalysisDomain = mockCreditAnalysisDomain();
        CreditAnalysisEntity creditAnalysisEntity = mockCreditAnalysisEntity();

        when(mapper.mappingCreditAnalysisEntityBy(creditAnalysisDomain)).thenReturn(creditAnalysisEntity);
        when(repository.save(creditAnalysisEntity)).thenReturn(creditAnalysisEntity);
        when(mapper.mappingCreditAnalysisDomainBy(creditAnalysisEntity)).thenReturn(creditAnalysisDomain);

        service.createCreditAnalysis(creditAnalysisDomain);

        verify(mapper, times(1)).mappingCreditAnalysisEntityBy(creditAnalysisDomain);
        verify(mapper, times(1)).mappingCreditAnalysisDomainBy(creditAnalysisEntity);
        verify(repository, times(1)).save(creditAnalysisEntity);
    }

    @Test
    @DisplayName("Should get a credit analysis by documentNumber")
    public void getCreditAnalysisByDocumentNumber() {
        CreditAnalysisDomain creditAnalysisDomain = mockCreditAnalysisDomain();
        CreditAnalysisEntity creditAnalysisEntity = mockCreditAnalysisEntity();
        String documentNumber = "40981736155";

        when(repository.findByDocumentNumber(documentNumber)).thenReturn(List.of(creditAnalysisEntity));
        when(mapper.mappingCreditAnalysisDomainBy(creditAnalysisEntity)).thenReturn(creditAnalysisDomain);

        service.getCreditAnalysisByDocumentNumber(documentNumber);

        verify(mapper, times(1)).mappingCreditAnalysisDomainBy(creditAnalysisEntity);
        verify(repository, times(1)).findByDocumentNumber(documentNumber);
    }
}
