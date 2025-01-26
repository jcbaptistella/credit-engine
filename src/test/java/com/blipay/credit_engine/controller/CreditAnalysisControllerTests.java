package com.blipay.credit_engine.controller;

import com.blipay.credit_engine.controller.creditAnalysis.CreditAnalysisController;
import com.blipay.credit_engine.controller.creditAnalysis.mapper.CreditAnalysisControllerMapper;
import com.blipay.credit_engine.controller.creditAnalysis.request.CreateCreditAnalysisRequest;
import com.blipay.credit_engine.controller.creditAnalysis.response.CreditAnalysisResponse;
import com.blipay.credit_engine.domain.CreditAnalysisDomain;
import com.blipay.credit_engine.usecase.creditAnalysis.CreateCreditAnalysisUseCase;
import com.blipay.credit_engine.usecase.creditAnalysis.GetCreditAnalysisUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.List;

import static com.blipay.credit_engine.helper.CreditAnalysisTestHelper.mockCreditAnalysisDomain;
import static com.blipay.credit_engine.helper.CreditAnalysisTestHelper.mockCreditAnalysisResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CreditAnalysisControllerTests {

    @InjectMocks
    private CreditAnalysisController controller;

    @Mock
    private CreateCreditAnalysisUseCase createCreditAnalysisUseCase;

    @Mock
    private GetCreditAnalysisUseCase getCreditAnalysisUseCase;

    @Spy
    private CreditAnalysisControllerMapper mapper = Mappers.getMapper(CreditAnalysisControllerMapper.class);

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    public void givenCreateCreditAnalysis_shouldCreateSuccesfully() throws Exception {
        CreateCreditAnalysisRequest request = new CreateCreditAnalysisRequest();
        request.setName("User");
        request.setDocumentNumber("45081437100");
        request.setAge(20);
        request.setCity("Campinas");
        request.setIncome(BigDecimal.valueOf(2000.00));

        CreditAnalysisDomain creditAnalysisDomain = mockCreditAnalysisDomain();
        when(createCreditAnalysisUseCase.execute(any())).thenReturn(creditAnalysisDomain);

        CreditAnalysisResponse creditAnalysisResponse = mockCreditAnalysisResponse();
        when(mapper.mappingCreditAnalysisResponseBy(creditAnalysisDomain)).thenReturn(creditAnalysisResponse);

        this.mockMvc.perform(
                        post("/credit-analysis")
                                .accept(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().json(objectMapper.writeValueAsString(creditAnalysisResponse)))
                .andExpect(status().isCreated());
    }

    @Test
    public void givenDocumentNumber_shouldFindAllCreditAnalysis() throws Exception {
        String documentNumber = "45081431800";

        CreditAnalysisDomain creditAnalysisDomain = mockCreditAnalysisDomain();
        when(getCreditAnalysisUseCase.execute(any())).thenReturn(List.of(creditAnalysisDomain));

        CreditAnalysisResponse creditAnalysisResponse = mockCreditAnalysisResponse();
        when(mapper.mappingCreditAnalysisResponseBy(creditAnalysisDomain)).thenReturn(creditAnalysisResponse);

        this.mockMvc.perform(
                        get("/credit-analysis/{documentNumber}", documentNumber)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(creditAnalysisResponse))))
                .andExpect(status().isOk());
    }
}
