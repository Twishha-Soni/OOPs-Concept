package com.example.rpgcharacterengine.character;

public class Warrior extends RPGCharacter {

    // Warrior-specific fields - not on the parent, not on any other subclass
    private final int armor;
    private final String weaponType;

    public Warrior(String name, int health, int level, int armor, String weaponType) {
        super(name, health, level);
        this.armor = armor;
        this.weaponType = weaponType;
    }

    @Override
    public String attack() {
        return getName() + " swings a " + weaponType + " for " + (10 + armor) + " damage!";
    }

    @Override
    public String getSpecialAbility() {
        return getName() + " activates Shield Wall - damage reduced by " + armor + " for 2 turns.";
    }
}
