package dev.leonardoalvarenga.smartwallet.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.leonardoalvarenga.smartwallet.models.Transaction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileStorageService {
    public void exportTransactionsToJson(List<Transaction> transactions, String filepath) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filepath), transactions);

            System.out.println("Extrato exportado para JSON com SUCESSO em: " + filepath);
        } catch (IOException e) {
            System.out.println("ERRO ao exportar JSON: " + e.getMessage());
        }
    }

    public List<Transaction> importTransactionsFromJson(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Arquivo não encontrado.");
            return new ArrayList<>();
        }

        try {
            List<Transaction> transactions = mapper.readValue(file, new TypeReference<List<Transaction>>() {
            });
            System.out.println("Dados importados com SUCESSO! ( " + transactions.size() + " transações encontradas.)");
            return transactions;
        } catch (IOException e) {
            System.out.println("ERRO ao ler arquivo JSON.");
            return new ArrayList<>();
        }
    }
}