package dev.leonardoalvarenga.rpg_battle;

import dev.leonardoalvarenga.rpg_battle.models.Mage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MageTest {
    static class DummyCharacter extends Character{
        public DummyCharacter(String name, int hp, int maxHp){
            super(name, hp, maxHp);
        }

        @Override
        public void attack(Character target){}
    }

    @Test
    void deveCausarDanoQuandoTemMana(){
        Mage mage = new Mage("Shazam", 100, 100, 20, 40);
        Character enemy = new MageTest.DummyCharacter("Goblin", 50, 50);

        mage.attack(enemy);

        assertEquals(10, enemy.hp);
    }

    @Test
    void deveReduzirManaAoAtacar(){
        Mage mage = new Mage("Shazam", 100, 20, 20, 40);
        Character enemy = new MageTest.DummyCharacter("Goblin", 50, 50);

        mage.attack(enemy);

        assertEquals(10, mage.getMana());
    }

    @Test
    void deveReduzirDanoComManaBaixa(){
        Mage mage = new Mage("Shazam", 100, 20, 5, 40);
        Character enemy = new MageTest.DummyCharacter("Goblin", 50, 50);

        mage.attack(enemy);

        assertEquals(48, enemy.hp);
    }

}
