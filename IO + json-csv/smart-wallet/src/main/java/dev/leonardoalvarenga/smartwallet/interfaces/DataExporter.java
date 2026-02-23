package dev.leonardoalvarenga.smartwallet.interfaces;

import dev.leonardoalvarenga.smartwallet.models.Transaction;

import java.util.List;

public interface DataExporter {
    void export(List<Transaction> transactions, String filePath);
}
