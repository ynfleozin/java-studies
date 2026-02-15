package dev.leonardoalvarenga.rpg_battle;

import dev.leonardoalvarenga.rpg_battle.models.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG BATTLE SIMULATOR ===");

        Warrior conan = new Warrior("Conan", 100, 100, 20, 10);
        Mage gandalf = new Mage("Gandalf", 60, 60, 50, 40);
        Paladin uther = new Paladin("Uther", 120, 120, 15);

        System.out.println("\n--- GERENCIANDO GRUPO (SET) ---");
        Party party = new Party();
        party.addMember(conan);
        party.addMember(gandalf);
        party.addMember(uther);

        Warrior cloneConan = new Warrior("Conan", 100, 100, 20, 10);
        boolean adicionou = party.addMember(cloneConan);
        System.out.println("Tentou clonar Conan? " + (adicionou ? "Sim (ERRO)" : "Não (SUCESSO)"));

        System.out.println("Tamanho do grupo: " + party.size());

        System.out.println("\n--- ORDENAÇÃO POR HP (COMPARATOR) ---");
        List<Character> ordenados = party.getMembersSortedByHp();
        // Usando forEach com lambda para ficar elegante
        ordenados.forEach(c -> System.out.println(c.getName() + " - HP: " + c.getHp()));

        System.out.println("\n--- INVENTÁRIO (MAP) ---");
        Inventory mochila = new Inventory();
        mochila.addItem("Poção de Cura");
        mochila.addItem("Poção de Cura");
        mochila.addItem("Espada Enferrujada");

        System.out.println("Poções na mochila: " + mochila.getQuantity("Poção de Cura"));

        mochila.removeItem("Poção de Cura");
        System.out.println("Poções após usar uma: " + mochila.getQuantity("Poção de Cura"));

        System.out.println("\n--- FIM DA SIMULAÇÃO ---");
    }
}