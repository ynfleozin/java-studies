package dev.leonardoalvarenga.smartwallet;

import dev.leonardoalvarenga.smartwallet.models.Transaction;
import dev.leonardoalvarenga.smartwallet.services.FileStorageService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Transaction> extract = new ArrayList<>();
        extract.add(new Transaction("Salário", 5000, "INCOME"));
        extract.add(new Transaction("Pizza", 65.50, "EXPENSE"));
        extract.add(new Transaction("Conta de Luz", 120, "EXPENSE"));

        FileStorageService storage = new FileStorageService();
        storage.exportTransactionsToJson(extract, "extract.json");
    }
}