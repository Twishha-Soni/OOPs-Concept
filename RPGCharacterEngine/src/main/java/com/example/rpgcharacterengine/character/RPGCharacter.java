package com.example.rpgcharacterengine.character;

public abstract class RPGCharacter {

    //Shared structure - every character has these, no exceptions.
    private final String name;
    private int health;
    private final int level;

    public RPGCharacter(String name, int health, int level) {
        this.name = name;
        this.level = level;
        this.health = health;
    }

    // Shared behavior - identical logic for every subclass.
    // No subclass should ever need to override this.
    public void takeDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public String getStatus() {
        return String.format("[%s | Level %d | HP: %d | Alive: %s]",
                name, level, health, isAlive());
    }

    // Abstract behavior - every character attacks and has a special ability,
    // but the parent has no business deciding how.
    // Subclasses MUST provide their own version.
    public abstract String attack();
    public abstract String getSpecialAbility();

    //Getters - subclasses may need these
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }
}
