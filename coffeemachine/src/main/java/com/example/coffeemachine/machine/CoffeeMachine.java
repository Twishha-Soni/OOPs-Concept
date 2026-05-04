package com.example.coffeemachine.machine;

// CoffeeMachine knows only the CoffeeBrewer contract.
// It has no idea whether it holds an EspressoMachine, FrenchPress,
// or anything else. It just delegates.

import com.example.coffeemachine.brewer.CoffeeBrewer;
import com.example.coffeemachine.model.Coffee;

public class CoffeeMachine {

    private CoffeeBrewer brewer;

    public CoffeeMachine(CoffeeBrewer brewer) {
        this.brewer = brewer;
    }

    // Swap the brewer at runtime - CoffeeMachine itself never changes.
    public void setBrewer(CoffeeBrewer brewer) {
        this.brewer = brewer;
    }

    public void makeCoffee() {
        System.out.println("Using : " + brewer.getBrewerName());
        Coffee coffee = brewer.brew();
        System.out.println("Served: " + coffee);
        System.out.println();
    }
}
