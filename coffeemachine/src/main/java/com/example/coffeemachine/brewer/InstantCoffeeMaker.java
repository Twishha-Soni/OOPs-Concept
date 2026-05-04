package com.example.coffeemachine.brewer;

import com.example.coffeemachine.model.Coffee;

public class InstantCoffeeMaker implements CoffeeBrewer {

    private static final String BRAND = "Nescafe";

    @Override
    public Coffee brew() {
        String notes = String.format(
                "Dissolved %s granules in hot water. No brewing involved",
                BRAND
        );
        return new Coffee("Instant Coffee", notes);
    }

    @Override
    public String getBrewerName() {
        return "Instant Coffee Maker";
    }
}
