package dev.leonardoalvarenga.rpg_battle;

import java.util.Objects;

public abstract class Character {
    protected String name;
    protected int hp;
    protected int maxHp;

    public Character(String name, int hp,int maxHp){
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
    }

    public void receiveDamage(int damage){
       hp -= damage;
        if( hp < 0 ){
            hp = 0;
        }
    }

    public boolean isAlive(){
        return hp > 0;
    }

    public abstract void attack(Character target);

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(name, character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return this.name + " (" + this.getClass().getSimpleName() + ") - HP: " + this.hp + "/" + this.maxHp;
    }

    public int getHp() {
        return hp;
    }

    public String getName(){
        return name;
    }
}
