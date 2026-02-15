package dev.leonardoalvarenga.rpg_battle.models;

import dev.leonardoalvarenga.rpg_battle.Character;

import java.util.HashSet;
import java.util.Set;

public class Party {
    Set<Character> members = new HashSet<>();

    public boolean addMember(Character character){
        return members.add(character);
    }

    public void showMembers(){
        System.out.println("--- PARTY ---");
        members.forEach(System.out::println);
    }

    public int size(){
        return members.size();
    }

    public boolean contains(Character character){
        return members.contains(character);
    }
}
