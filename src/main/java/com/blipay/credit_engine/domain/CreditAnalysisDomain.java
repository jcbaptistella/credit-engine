package com.blipay.credit_engine.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditAnalysisDomain {

    private Long id;
    private String documentNumber;
    private String name;
    private Integer score;
    private Boolean approved;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public static CreditAnalysisDomain request(String documentNumber, String name, Integer age, BigDecimal income, Double temp) {

        final BigDecimal componentAge = getComponentAge(age);
        final BigDecimal componentIncome = getComponentIncome(income);
        final BigDecimal componentTemp = getComponentTemp(temp);

        final BigDecimal score = getScore(componentAge, componentIncome, componentTemp);

        final Boolean approved = isApproved(score, age);

        return new CreditAnalysisDomain(documentNumber, name, score.intValue(), approved);
    }

    private static Boolean isApproved(BigDecimal score, Integer age) {
        return score.intValue() >= 200 && age >= 18;
    }

    private static BigDecimal getComponentTemp(Double temp) {
        return BigDecimal.valueOf(temp).multiply(BigDecimal.valueOf(5));
    }

    private static BigDecimal getComponentIncome(BigDecimal income) {
        return income.divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(2));
    }

    private static BigDecimal getComponentAge(Integer age) {
        return BigDecimal.valueOf(age).multiply(BigDecimal.valueOf(0.5));
    }

    private static BigDecimal getScore(BigDecimal componenteIdade, BigDecimal componenteRenda, BigDecimal componenteTemperatura) {
        return componenteIdade.add(componenteRenda).add(componenteTemperatura);
    }

    public CreditAnalysisDomain(String documentNumber, String name, Integer score, Boolean approved) {
        this.documentNumber = documentNumber;
        this.name = name;
        this.score = score;
        this.approved = approved;
    }

    public CreditAnalysisDomain() {
    }
}
