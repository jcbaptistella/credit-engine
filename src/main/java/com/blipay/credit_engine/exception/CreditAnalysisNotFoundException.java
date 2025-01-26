package com.blipay.credit_engine.exception;

public class CreditAnalysisNotFoundException extends Exception {

    public CreditAnalysisNotFoundException(String documentNumber) {
        super(String.format("Already exists credit analysis with document number: %s", documentNumber));
    }

}
