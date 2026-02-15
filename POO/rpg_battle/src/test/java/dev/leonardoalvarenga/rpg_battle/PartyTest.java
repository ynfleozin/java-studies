package dev.leonardoalvarenga.rpg_battle;

import dev.leonardoalvarenga.rpg_battle.models.Mage;
import dev.leonardoalvarenga.rpg_battle.models.Party;
import dev.leonardoalvarenga.rpg_battle.models.Warrior;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PartyTest {
    @Test
    void deveAdicionarMembro(){
        Party party = new Party();
        Character c1 = new Warrior("Theros", 50, 50, 20, 30);

        boolean added =  party.addMember(c1);

        assertTrue(added);
        assertEquals(1, party.size());
        assertTrue(party.contains(c1));
    }

    @Test
    void nãoDeveAdicionarDuasVezes(){
        Party party = new Party();
        Character c1 = new Warrior("Theros", 50, 50, 20, 30);

        party.addMember(c1);
        boolean addedAgain = party.addMember(c1);

        assertFalse(addedAgain);
        assertEquals(1, party.size());
    }

    @Test
    void naoDeveAdicionarPersonagemComMesmoNome(){
        Party party = new Party();
        Character c1 = new Warrior("Theros", 50, 50, 20, 30);
        Character c2 = new Warrior("Theros", 50, 50, 50, 50);

        party.addMember(c1);
        boolean addedSecond = party.addMember(c2);

        assertFalse(addedSecond);
        assertEquals(1, party.size());
    }

    @Test
    void deveRetornarMembrosOrdenadosPorHp(){
        Party party = new Party();

        Character c1 = new Warrior("Ares", 30, 30, 10, 5);
        Character c2 = new Warrior("Baldur", 80, 80, 10, 5);
        Character c3 = new Warrior("Cronos", 50, 50, 10, 5);

        party.addMember(c1);
        party.addMember(c2);
        party.addMember(c3);

        List<Character> sorted = party.getMembersSortedByHp();

        assertEquals(3, sorted.size());

        assertEquals("Ares", sorted.get(0).getName());
        assertEquals("Cronos", sorted.get(1).getName());
        assertEquals("Baldur", sorted.get(2).getName());
    }

    @Test
    void naoDeveAlterarColecaoOriginal() {
        Party party = new Party();

        Character c1 = new Warrior("Ares", 30, 30, 10, 5);
        Character c2 = new Warrior("Baldur", 80, 80, 10, 5);

        party.addMember(c1);
        party.addMember(c2);

        List<Character> sorted = party.getMembersSortedByHp();

        sorted.remove(0);

        assertEquals(2, party.size());
    }

    @Test
    void deveFuncionarComUmUnicoMembro() {
        Party party = new Party();

        Character c1 = new Warrior("Solo", 100, 40, 10, 5);
        party.addMember(c1);

        List<Character> sorted = party.getMembersSortedByHp();

        assertEquals(1, sorted.size());
        assertEquals("Solo", sorted.get(0).getName());
    }
}
