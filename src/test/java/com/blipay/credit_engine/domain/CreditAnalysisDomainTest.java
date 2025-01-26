package com.blipay.credit_engine.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CreditAnalysisDomainTest {

    @Test
    public void request() {
        String documentNumber = "408736123600";
        String name = "User";
        Integer age = 30;
        BigDecimal income = BigDecimal.valueOf(2000.00);
        Double temp = 30.0;

        CreditAnalysisDomain creditAnalysisDomain = CreditAnalysisDomain.request(documentNumber, name, age, income, temp);

        assertThat(creditAnalysisDomain.getDocumentNumber()).isEqualTo(documentNumber);
        assertThat(creditAnalysisDomain.getName()).isEqualTo(name);
        assertThat(creditAnalysisDomain.getApproved()).isEqualTo(true);
        assertThat(creditAnalysisDomain.getScore()).isEqualTo(205);
    }
}
