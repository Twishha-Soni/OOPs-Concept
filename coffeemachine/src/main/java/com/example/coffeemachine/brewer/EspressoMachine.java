package com.example.coffeemachine.brewer;

import com.example.coffeemachine.model.Coffee;

public class EspressoMachine implements CoffeeBrewer {

    // How an espresso machine works - the caller never sees any of this.

    private static final int PRESSURE_BAR = 9;
    private static final int BREW_TEMP_CELSIUS = 93;
    private static final int EXTRACTION_SECONDS = 25;

    @Override
    public Coffee brew() {
        String notes = String.format(
                "Extracted at %d bar pressure, %d°C, for %d seconds",
                PRESSURE_BAR, BREW_TEMP_CELSIUS, EXTRACTION_SECONDS
        );
        return new Coffee("Espresso", notes);
    }

    @Override
    public String getBrewerName() {
        return "Espresso Machine";
    }
}
