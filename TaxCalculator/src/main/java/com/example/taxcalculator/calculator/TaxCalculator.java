package com.example.taxcalculator.calculator;

import com.example.taxcalculator.model.TaxResult;

// The contract - the only thing TaxProcessor ever sees.
public interface TaxCalculator {

    TaxResult calculate(double income);
    String getTaxPayerType();
}
