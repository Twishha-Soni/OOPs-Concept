package com.example.rpgcharacterengine.engine;

import com.example.rpgcharacterengine.character.RPGCharacter;

import java.util.List;

// Battle operates entirely  on RPGCharacter references.
// It has no knowledge of Warrior , Mage, or Archer.
// Shared structure (takeDamage, isAlive , getStatus) is used directly.
// Specific behavior (attack, getSpecialAbility) is called polymorphically.
public class Battle {

    private final List<RPGCharacter> participants;

    public Battle(List<RPGCharacter> participants) {
        this.participants = participants;
    }

    public void start() {
        System.out.println("=== BATTLE START ===\n");

        // Each character use their special ability first
        for(RPGCharacter character : participants) {
            System.out.println(character.getSpecialAbility());
        }

        System.out.println();

        // Each character attacks - Battle never knows who is who
        for(int i=0; i<participants.size(); i++) {
            RPGCharacter attacker = participants.get(i);
            RPGCharacter target = participants.get((i+1) % participants.size());

            if(attacker.isAlive()) {
                System.out.println(attacker.attack());
                target.takeDamage(20);
            }
        }

        System.out.println("\n=== BATTLE RESULTS ===\n");
        for(RPGCharacter character : participants) {
            System.out.println(character.getStatus());
        }
    }
}
