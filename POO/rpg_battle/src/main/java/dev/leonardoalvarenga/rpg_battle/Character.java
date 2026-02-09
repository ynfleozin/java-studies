package dev.leonardoalvarenga.rpg_battle;

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
}
