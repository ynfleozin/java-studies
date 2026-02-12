package dev.leonardoalvarenga.rpg_battle.models;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> items = new HashMap<>();

    public void addItem(String itemName){
        int count = items.getOrDefault( itemName, 0 );
        items.put(itemName, count + 1);
    }

    public int getQuantity(String item){
        return items.getOrDefault(item, 0);
    }
}
