package dev.leonardoalvarenga.rpg_battle;

public abstract class Character {
    protected String name;
    protected int hp;
    protected int maxHp;

    void receiveDamage(int damage){
       if( hp < 0 ){
           hp = 0;
       }
       hp -= damage;
    }

    boolean isAlive(){
        return hp > 0;
    }

    abstract void attack(Character target);
}
