package com.blipay.credit_engine.repository.creditAnalysis;

import com.blipay.credit_engine.entity.creditAnalysis.CreditAnalysisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreditAnalysisRepository extends JpaRepository<CreditAnalysisEntity, Long> {
    List<CreditAnalysisEntity> findByDocumentNumber(String documentNumber);
}
