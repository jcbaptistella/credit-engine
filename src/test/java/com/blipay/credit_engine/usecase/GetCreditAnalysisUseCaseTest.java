package com.blipay.credit_engine.usecase;

import com.blipay.credit_engine.domain.CreditAnalysisDomain;
import com.blipay.credit_engine.service.creditAnalysis.CreditAnalysisService;
import com.blipay.credit_engine.usecase.creditAnalysis.GetCreditAnalysisUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.blipay.credit_engine.helper.CreditAnalysisTestHelper.mockCreditAnalysisDomain;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class GetCreditAnalysisUseCaseTest {

    @InjectMocks
    private GetCreditAnalysisUseCase getCreditAnalysisUseCase;

    @Mock
    private CreditAnalysisService creditAnalysisService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should find credit analysis when receive a document number")
    public void execute() {
        String documentNumber = "40183712633";
        CreditAnalysisDomain creditAnalysisDomain = mockCreditAnalysisDomain();
        creditAnalysisDomain.setDocumentNumber(documentNumber);

        when(creditAnalysisService.getCreditAnalysisByDocumentNumber(documentNumber)).thenReturn(List.of(creditAnalysisDomain));

        List<CreditAnalysisDomain> creditAnalysisDomainList = getCreditAnalysisUseCase.execute(documentNumber);

        verify(creditAnalysisService, times(1)).getCreditAnalysisByDocumentNumber(documentNumber);

        assertThat(creditAnalysisDomainList.getFirst().getDocumentNumber()).isEqualTo(documentNumber);
    }
}
