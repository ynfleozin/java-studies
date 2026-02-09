package dev.leonardoalvarenga.rpg_battle.models;

import dev.leonardoalvarenga.rpg_battle.Character;
import dev.leonardoalvarenga.rpg_battle.interfaces.Healable;

public class Paladin extends Character implements Healable {
    private int damage;

    public Paladin(String name, int hp, int maxHp, int damage){
        super(name, hp, maxHp);
        this.damage = damage;
    }

    @Override
    public void attack(Character target){
        target.receiveDamage(damage);
    }

    public void heal(){
        hp += 15;
    }
}
