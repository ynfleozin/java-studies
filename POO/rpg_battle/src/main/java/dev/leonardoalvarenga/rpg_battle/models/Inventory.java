package dev.leonardoalvarenga.rpg_battle.models;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> items = new HashMap<>();

    public void addItem( String item ){
        int count = items.getOrDefault( item, 0 );
        items.put( item, count + 1 );
    }

    public void removeItem(String item){
        int count = items.getOrDefault( item, 0 );

        if( count > 1 ){
            items.put(item, count - 1);
        }else if(count == 1){
            items.remove(item);
        }
    }

    public int getQuantity( String item ){
        return items.getOrDefault( item, 0 );
    }
}
