package dev.leonardoalvarenga.smartwallet.services;

import java.io.FileWriter;
import java.io.IOException;

public class FileStorageService {
    public void testWritingToDisk(String text) {
        try (FileWriter writer = new FileWriter("teste_banco.txt")) {
            writer.write(text);
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo no disco: " + e.getMessage());
        }
    }
}