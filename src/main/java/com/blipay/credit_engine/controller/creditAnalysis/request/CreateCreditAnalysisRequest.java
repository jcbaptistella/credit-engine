package com.blipay.credit_engine.controller.creditAnalysis.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CreateCreditAnalysisRequest {

    @NotBlank(message = "Name cannot be null or blank")
    private String name;

    @NotBlank(message = "Document number cannot be null or blank")
    private String documentNumber;

    @NotNull(message = "Age cannot be null")
    private Integer age;

    @NotNull(message = "Income cannot be null")
    private BigDecimal income;

    @NotBlank(message = "City cannot be null or blank")
    private String city;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
