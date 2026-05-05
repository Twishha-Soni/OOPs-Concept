package com.example.taxcalculator.model;

public class TaxResult {

    private final String taxPayerType;
    private final double income;
    private final double taxAmount;
    private final double effectiveRatePercent;

    public TaxResult(String taxPayerType, double income, double taxAmount) {
        this.taxPayerType = taxPayerType;
        this.income = income;
        this.taxAmount = taxAmount;
        this.effectiveRatePercent = (taxAmount / income) * 100;
    }

    @Override
    public String toString() {
        return String.format(
                "%-20s | Income: %10.2f | Tax: %10.2f | Effective Rate: %10.2f",
                taxPayerType, income, taxAmount, effectiveRatePercent
        );
    }
}
