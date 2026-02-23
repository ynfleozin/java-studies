package dev.leonardoalvarenga.smartwallet;

import dev.leonardoalvarenga.smartwallet.services.FileStorageService;

public class Main {
    public static void main(String[] args) {
        FileStorageService fileStorageService = new FileStorageService();

        fileStorageService.testWritingToDisk("Texto para teste");
    }
}