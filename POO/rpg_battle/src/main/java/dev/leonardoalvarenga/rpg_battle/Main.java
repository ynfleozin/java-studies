package dev.leonardoalvarenga.rpg_battle;

import dev.leonardoalvarenga.rpg_battle.models.Mage;
import dev.leonardoalvarenga.rpg_battle.models.Warrior;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Conan", 100, 100, 20, 40);
        Mage mage = new Mage("Gandalf", 80, 80, 30, 35);

        while( warrior.isAlive() && mage.isAlive() ){
            warrior.attack( mage );
            System.out.println("Gandalf HP: " + mage.hp);

            if ( mage.isAlive() ){
                mage.attack( warrior );
                System.out.println("Conan HP:" + warrior.hp);
            }
        }
    }
}