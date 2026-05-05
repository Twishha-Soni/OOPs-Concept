package com.example.taxcalculator.calculator;

import com.example.taxcalculator.model.TaxResult;

// Non-profit — exempt from tax, but result is still recorded for reporting.
public class NonProfitTaxCalculator implements TaxCalculator {

    @Override
    public TaxResult calculate(double income) {
        return new TaxResult(getTaxPayerType(), income, 0.0);
    }

    @Override
    public String getTaxPayerType() {
        return "Non Profit";
    }
}
