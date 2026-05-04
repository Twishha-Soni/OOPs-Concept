package com.example.coffeemachine.brewer;

import com.example.coffeemachine.model.Coffee;

// This is the contract - the What
// The caller knows only this. Everything else is hidden.

public interface CoffeeBrewer {
    Coffee brew();
    String getBrewerName();
}
