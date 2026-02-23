package dev.leonardoalvarenga.smartwallet.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.leonardoalvarenga.smartwallet.models.Transaction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileStorageService {
    public void exportTransactionsToJson(List<Transaction> transactions, String filepath){
        ObjectMapper mapper = new ObjectMapper();

        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filepath), transactions);

            System.out.println("Extrato exportado para JSON com SUCESSO em: " + filepath);
        }catch (IOException e){
            System.out.println("ERRO ao exportar JSON: " + e.getMessage());
        }
    }
}