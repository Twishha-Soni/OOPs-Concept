package com.example.taxcalculator.calculator;

import com.example.taxcalculator.model.TaxResult;
// Corporation — flat corporate rate with a small business relief threshold.
public class CorporateTaxCalculator implements TaxCalculator {

    private static final double SMALL_BUSINESS_RATE = 0.19;
    private static final double STANDARD_RATE = 0.25;
    private static final double SMALL_BUSINESS_THRESHOLD = 50000.0;

    @Override
    public TaxResult calculate(double income) {
        double rate = income <= SMALL_BUSINESS_THRESHOLD
                ? SMALL_BUSINESS_RATE
                : STANDARD_RATE;
        double tax = income * rate;
        return new TaxResult(getTaxPayerType(), income, tax);
    }

    @Override
    public String getTaxPayerType() {
        return "Corporation";
    }
}
