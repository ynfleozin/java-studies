package dev.leonardoalvarenga.rpg_battle.models;

import dev.leonardoalvarenga.rpg_battle.Character;

public class Warrior extends Character {
    private int strength;
    private int stamina;

    public Warrior(String name, int hp, int maxHp, int strength, int stamina){
        super(name, hp, maxHp);
        this.strength = strength;
        this.stamina = stamina;
    }

    @Override
    public void attack(Character target){
        if (stamina <= 0){
            return;
        } else{
            target.receiveDamage(strength);
            stamina -= 5;
        }
    }

    public int getStamina() {
        return stamina;
    }
}
