package dev.leonardoalvarenga.rpg_battle;

import dev.leonardoalvarenga.rpg_battle.models.Paladin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaladinTest {
    static class DummyCharacter extends Character{
        public DummyCharacter(String name, int hp, int maxHp){
            super(name, hp, maxHp);
        }

        @Override
        public void attack(Character target){}
    }

    @Test
    void deveCausarDano(){
        Paladin paladin = new Paladin("Paladino", 100, 100, 20);
        Character enemy = new DummyCharacter("Goblin", 50, 50);

        paladin.attack(enemy);

        assertEquals(30, enemy.hp);
    }

    @Test
    void deveRecuperarHp(){
        Paladin paladin = new Paladin("Paladino", 30, 100, 20);

        paladin.heal();

        assertEquals(45, paladin.hp);
    }

}
