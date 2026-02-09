package dev.leonardoalvarenga.rpg_battle;

import dev.leonardoalvarenga.rpg_battle.models.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class WarriorTest {

    static class DummyCharacter extends Character{
        public DummyCharacter(String name, int hp, int maxHp){
            super(name, hp, maxHp);
        }

        @Override
        public void attack(Character target){}
    }

    @Test
    void deveCausarDanoQuandoTemStamina(){
        Warrior warrior = new Warrior("Thor", 100, 100, 10, 20);
        Character enemy = new DummyCharacter("Goblin", 50, 50);

        warrior.attack(enemy);

        assertEquals(40, enemy.hp);
    }

    @Test
    void deveReduzirStaminaAoAtacar(){
        Warrior warrior = new Warrior("Thor", 100, 100, 10, 20);
        Character enemy = new DummyCharacter("Goblin", 50, 50);

        warrior.attack(enemy);

        assertEquals(15, warrior.getStamina());
    }

    @Test
    void naoDeveAtacarQuandoStaminaZera(){
        Warrior warrior = new Warrior("Thor", 100, 100, 10, 0);
        Character enemy = new DummyCharacter("Goblin", 50, 50);

        warrior.attack(enemy);

        assertEquals(50, enemy.hp);
    }

    @Test
    void personagemMorreQuandoHpZera(){
        Character enemy = new DummyCharacter("Goblin", 5, 50);

        enemy.receiveDamage(10);

        assertFalse(enemy.isAlive());
        assertEquals(0, enemy.hp);
    }
}
