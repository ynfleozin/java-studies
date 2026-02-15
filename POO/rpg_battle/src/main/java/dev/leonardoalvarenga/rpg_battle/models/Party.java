package dev.leonardoalvarenga.rpg_battle.models;

import dev.leonardoalvarenga.rpg_battle.Character;

import java.util.HashSet;
import java.util.Set;

public class Party {
    Set<Character> members = new HashSet<>();

    void addMember(Character c){
        boolean added = members.add(c);

        if(added){
            System.out.println("Personagem adicionado.");
        }else{
            System.out.println("ERRO: Personagem existente!");
        }
    }
}
