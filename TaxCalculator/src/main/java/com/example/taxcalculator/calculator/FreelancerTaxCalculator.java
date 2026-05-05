package com.example.taxcalculator.calculator;

import com.example.taxcalculator.model.TaxResult;

// Freelancer — flat rate plus self-employment surcharge, no standard deduction.
public class FreelancerTaxCalculator implements TaxCalculator {

    private static final double FLAT_RATE = 0.25;
    private static final double SELF_EMPLOYMENT_SURCHARGE = 0.05;

    @Override
    public TaxResult calculate(double income) {
        double tax = income * (FLAT_RATE + SELF_EMPLOYMENT_SURCHARGE);
        return new TaxResult(getTaxPayerType(), income, tax);
    }

    @Override
    public String getTaxPayerType() {
        return "Freelancer";
    }
}
