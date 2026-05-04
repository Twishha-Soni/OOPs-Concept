package com.example.coffeemachine;

import com.example.coffeemachine.brewer.EspressoMachine;
import com.example.coffeemachine.brewer.FrenchPress;
import com.example.coffeemachine.brewer.InstantCoffeeMaker;
import com.example.coffeemachine.machine.CoffeeMachine;

public class Main {

    public static void main(String[] args) {

        // CoffeeMachine is handed a brewer - it never constructs one itself.
        // This is the same pattern as Spring injecting a PasswordEncoder into
        // your AuthService.

        CoffeeMachine machine = new CoffeeMachine(new EspressoMachine());
        machine.makeCoffee();

        //Swap to FrenchPress - CoffeeMachine code didn't change at all
        machine.setBrewer(new FrenchPress());
        machine.makeCoffee();

        // Swap again - still no changes to CoffeeMachine
        machine.setBrewer(new InstantCoffeeMaker());
        machine.makeCoffee();
    }
}
