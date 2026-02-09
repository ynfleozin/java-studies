package dev.leonardoalvarenga.rpg_battle.models;

import dev.leonardoalvarenga.rpg_battle.Character;

public class Mage extends Character {
    private int mana;
    private int intelligence;

    public Mage(String name, int hp, int maxHp, int mana, int intelligence){
        super(name, hp,maxHp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    @Override
    public void attack(Character target){
        int damage;

        if(mana >= 10){
            damage = intelligence;
            mana -= 10;
        } else{
            damage = 2;
        }

        target.receiveDamage(damage);
    }

    public int getMana() {
        return mana;
    }
}
