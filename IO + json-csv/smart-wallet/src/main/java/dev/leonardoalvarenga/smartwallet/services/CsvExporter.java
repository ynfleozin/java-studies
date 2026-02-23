package dev.leonardoalvarenga.smartwallet.services;

import dev.leonardoalvarenga.smartwallet.interfaces.DataExporter;
import dev.leonardoalvarenga.smartwallet.models.Transaction;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvExporter implements DataExporter {

    @Override
    public void export(List<Transaction> transactions, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Descrição; Valor; Tipo\n");

            for (Transaction t : transactions) {
                String line = t.getDescription() + ";" + t.getAmount() + ";" + t.getType() + "\n";
                writer.write(line);
            }

            System.out.println("Relatório CSV gerado com sucesso em: " + filePath);
        } catch (IOException e) {
            System.out.println("ERRO ao gerar arquivo CSV: " + e.getMessage());
        }
    }
}
