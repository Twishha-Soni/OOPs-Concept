package com.example.taxcalculator;

import com.example.taxcalculator.calculator.CorporateTaxCalculator;
import com.example.taxcalculator.calculator.EmployeeTaxCalculator;
import com.example.taxcalculator.calculator.FreelancerTaxCalculator;
import com.example.taxcalculator.calculator.NonProfitTaxCalculator;
import com.example.taxcalculator.processor.TaxProcessor;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Each calculator encapsulates its own rules.
        // TaxProcessor never knows which type it's calling.
        TaxProcessor processor = new TaxProcessor(List.of(
                new EmployeeTaxCalculator(),
                new FreelancerTaxCalculator(),
                new CorporateTaxCalculator(),
                new NonProfitTaxCalculator()
        ));

        processor.processAll(60000.0);
        processor.processAll(30000.0);
    }
}
