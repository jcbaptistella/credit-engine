package com.blipay.credit_engine.controller.creditAnalysis;

import com.blipay.credit_engine.controller.creditAnalysis.mapper.CreditAnalysisControllerMapper;
import com.blipay.credit_engine.controller.creditAnalysis.request.CreateCreditAnalysisRequest;
import com.blipay.credit_engine.controller.creditAnalysis.response.CreditAnalysisResponse;
import com.blipay.credit_engine.domain.CreditAnalysisDomain;
import com.blipay.credit_engine.service.creditAnalysis.dto.CreateCreditAnalysisDto;
import com.blipay.credit_engine.usecase.creditAnalysis.CreateCreditAnalysisUseCase;
import com.blipay.credit_engine.usecase.creditAnalysis.GetCreditAnalysisUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/credit-analysis")
public class CreditAnalysisController {

    private final GetCreditAnalysisUseCase getCreditAnalysisUseCase;
    private final CreateCreditAnalysisUseCase createCreditAnalysisUseCase;
    private final CreditAnalysisControllerMapper mapper;

    @Autowired
    public CreditAnalysisController(GetCreditAnalysisUseCase getCreditAnalysisUseCase, CreateCreditAnalysisUseCase createCreditAnalysisUseCase, CreditAnalysisControllerMapper mapper) {
        this.getCreditAnalysisUseCase = getCreditAnalysisUseCase;
        this.createCreditAnalysisUseCase = createCreditAnalysisUseCase;
        this.mapper = mapper;
    }

    private URI createURI(final Long creditAnalysisId) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(creditAnalysisId)
                .toUri();
    }

    @PostMapping
    public ResponseEntity<CreditAnalysisResponse> requestCreditAnalysis(@Valid @RequestBody CreateCreditAnalysisRequest request) {
        CreateCreditAnalysisDto createCreditAnalysisDto = mapper.mappingCreditAnalysisDtoBy(request);

        CreditAnalysisDomain creditAnalysisDomain = createCreditAnalysisUseCase.execute(createCreditAnalysisDto);

        return ResponseEntity.created(this.createURI(creditAnalysisDomain.getId()))
                .body(mapper.mappingCreditAnalysisResponseBy(creditAnalysisDomain));
    }

    @GetMapping("/{documentNumber}")
    public ResponseEntity<List<CreditAnalysisResponse>> getByDocumentNumber(@PathVariable("documentNumber") String documentNumber) {
        List<CreditAnalysisDomain> creditAnalysisDomainList = getCreditAnalysisUseCase.execute(documentNumber);
        return ResponseEntity.ok(creditAnalysisDomainList.stream().map(mapper::mappingCreditAnalysisResponseBy).toList());
    }
}
