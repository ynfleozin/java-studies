package dev.leonardoalvarenga.smartwallet;

import dev.leonardoalvarenga.smartwallet.models.Transaction;
import dev.leonardoalvarenga.smartwallet.services.FileStorageService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileStorageService storage = new FileStorageService();
        String path = "extract.json";

        System.out.println("Lendo dados no disco...");
        List<Transaction> extract = storage.importTransactionsFromJson(path);

        for(Transaction t : extract){
            System.out.println("-> " + t.getDescription() + " | R$ " + t.getAmount() + " | " + t.getType());
        }

        extract.add(new Transaction("Café Expresso", 2.50, "EXPENSE"));
        System.out.println("Adicionado: Café Expresso - R$2.50");

        System.out.println("Guardando dados no disco...");
        storage.exportTransactionsToJson(extract, path);
    }
}