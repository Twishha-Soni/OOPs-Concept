package com.example.rpgcharacterengine.character;

public class Mage extends RPGCharacter {

    private final String spellSchool;
    private int mana;

    public Mage(String name, int health, int level, String spellSchool, int mana) {
        super(name, health, level);
        this.spellSchool = spellSchool;
        this.mana = mana;
    }

    @Override
    public String attack() {
        if(mana >= 10) {
            mana -= 10;
            return getName() + " casts a " + spellSchool + " bolt for 25 damage! (Mana left: " + mana + ")";
        }
        return getName() + " is out of mana and throws a stick for 2 damage.";
    }

    @Override
    public String getSpecialAbility() {
        mana += 30;
        return getName() + " meditates and restores 30 mana. (Mana now: " + mana + ")";
    }
}
