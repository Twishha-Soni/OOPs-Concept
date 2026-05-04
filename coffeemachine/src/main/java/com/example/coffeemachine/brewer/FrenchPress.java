package com.example.coffeemachine.brewer;

import com.example.coffeemachine.model.Coffee;

public class FrenchPress implements CoffeeBrewer {

    private static final int STEEP_MINUTES = 4;
    private static final String GRIND = "coarse";

    @Override
    public Coffee brew() {
        String notes = String.format(
                "Steeped with %s grounds for %d minutes, then pressed",
                GRIND, STEEP_MINUTES
        );
        return new Coffee("French Press Coffee", notes);
    }

    @Override
    public String getBrewerName() {
        return "French Press";
    }
}
