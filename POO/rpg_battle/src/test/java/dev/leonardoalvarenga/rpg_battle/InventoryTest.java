package dev.leonardoalvarenga.rpg_battle;

import dev.leonardoalvarenga.rpg_battle.models.Inventory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryTest {

    @Test
    void adicionarItem(){
        Inventory inventory = new Inventory();

        inventory.addItem("potion");

        assertEquals(1, inventory.getQuantity("potion"));
    }

    @Test
    void adicionarItemExistente(){
        Inventory inventory = new Inventory();

        inventory.addItem("potion");
        inventory.addItem("potion");

        assertEquals(2, inventory.getQuantity("potion"));
    }

    @Test
    void diminuirQuantidadeItem(){
        Inventory inventory = new Inventory();

        inventory.addItem("potion");
        inventory.addItem("potion");
        inventory.removeItem("potion");

        assertEquals(1, inventory.getQuantity("potion"));
    }

    @Test

    void removerItemDaLista(){
        Inventory inventory = new Inventory();

        inventory.addItem("potion");
        inventory.removeItem("potion");

        assertEquals(0, inventory.getQuantity("potion"));
    }

    @Test
    void retornaZeroQuandoNaoHouverItem(){
        Inventory inventory = new Inventory();

        assertEquals(0, inventory.getQuantity("bowl"));
    }
}
