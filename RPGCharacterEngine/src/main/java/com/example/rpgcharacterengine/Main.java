package com.example.rpgcharacterengine;

import com.example.rpgcharacterengine.character.RPGCharacter;
import com.example.rpgcharacterengine.character.*;
import com.example.rpgcharacterengine.engine.Battle;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        RPGCharacter warrior = new Warrior("Thorin", 120, 5, 15, "battleaxe");
        RPGCharacter mage = new Mage("Elara", 80, 5, "Frost", 50);
        RPGCharacter archer = new Archer("Sylara", 90, 5, 20, 40);

        Battle battle = new Battle(List.of(warrior, mage, archer));
        battle.start();
    }
}
