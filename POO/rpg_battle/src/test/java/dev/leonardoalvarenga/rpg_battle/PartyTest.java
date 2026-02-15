package dev.leonardoalvarenga.rpg_battle;

import dev.leonardoalvarenga.rpg_battle.models.Mage;
import dev.leonardoalvarenga.rpg_battle.models.Party;
import dev.leonardoalvarenga.rpg_battle.models.Warrior;
import org.junit.jupiter.api.Test;

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
}
