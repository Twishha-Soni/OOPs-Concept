package com.example.taxcalculator.calculator;

import com.example.taxcalculator.model.TaxResult;

// Salaried employee — progressive brackets, standard deduction applied first.
public class EmployeeTaxCalculator implements TaxCalculator {

    private static final double STANDARD_DEDUCTION = 12000.0;

    @Override
    public TaxResult calculate(double income) {
        double taxableIncome = Math.max(0, income - STANDARD_DEDUCTION);
        double tax = 0;

        if(taxableIncome <= 10000) {
            tax = taxableIncome * 0.10;
        } else if( taxableIncome <= 40000) {
            tax = 1000 + (taxableIncome - 10000) * 0.20;
        } else {
            tax = 7000 + (taxableIncome - 40000) * 0.30;
        }

        return new TaxResult(getTaxPayerType(), income, tax);
    }

    @Override
    public String getTaxPayerType() {
        return "Employee";
    }
}
