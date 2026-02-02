package dev.leonardoalvarenga.ecommerce.models;

import dev.leonardoalvarenga.ecommerce.Product;

public class Electronics extends Product {
    private int warrantyDays;

    public Electronics(String name, double price, int warrantyDays){
        super(name, price);
        this.warrantyDays = warrantyDays;
    }

    public int getWarrantyDays() {
        return warrantyDays;
    }
}
