package com.example.coffeemachine.model;

public class Coffee {

    private final String name;
    private final String preparationNotes;

    public Coffee(String name, String preparationNotes) {
        this.name = name;
        this.preparationNotes = preparationNotes;
    }

    public String getName() {
        return name;
    }

    public String getPreparationNotes() {
        return preparationNotes;
    }

    @Override
    public String toString() {
        return name + " (" + preparationNotes + ")";
    }
}
