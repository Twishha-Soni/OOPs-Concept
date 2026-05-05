package com.example.rpgcharacterengine.character;

public class Archer extends RPGCharacter {

    private int arrows;
    private final int range;

    public Archer(String name, int health, int level, int arrows, int range) {
        super(name, health, level);
        this.range = range;
        this.arrows = arrows;
    }

    @Override
    public String attack() {
        if(arrows > 0) {
            arrows--;
            return getName() + " fires an arrow from " + range + "m for 15 damage! (Arrows left: " + arrows +")";
        }
        return getName() + " has no arrows and resorts to a desperate kick for 3 damage!";
    }

    @Override
    public String getSpecialAbility() {
        arrows += 10;
        return getName() + " crafts 10 arrows from nearby materials. (Arrows now: " + arrows + ")";
    }
}
