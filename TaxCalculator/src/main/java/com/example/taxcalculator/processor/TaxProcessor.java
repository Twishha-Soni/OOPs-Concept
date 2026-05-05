package com.example.taxcalculator.processor;

import com.example.taxcalculator.calculator.TaxCalculator;
import com.example.taxcalculator.model.TaxResult;

import java.util.List;

// TaxProcessor knows only TaxCalculator — the interface.
// No instanceof. No conditionals. No knowledge of any concrete type.
// Adding a new taxpayer type requires zero changes here.
public class TaxProcessor {

    private final List<TaxCalculator> calculators;

    public TaxProcessor(List<TaxCalculator> calculators) {
        this.calculators = calculators;
    }

    public void processAll(double income) {
        System.out.println("=== TAX REPORT | Income: " + income + " ===\n");

        for (TaxCalculator calculator : calculators) {
            TaxResult result = calculator.calculate(income);
            System.out.println(result);
        }

        System.out.println();
    }
}
