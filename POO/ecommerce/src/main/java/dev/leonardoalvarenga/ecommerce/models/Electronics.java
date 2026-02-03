package dev.leonardoalvarenga.ecommerce.models;

import dev.leonardoalvarenga.ecommerce.Product;
import dev.leonardoalvarenga.ecommerce.interfaces.Taxable;

public class Electronics extends Product implements Taxable {
    private int warrantyDays;

    public Electronics(String name, double price, int warrantyDays){
        super(name, price);
        this.warrantyDays = warrantyDays;
    }

    public int getWarrantyDays() {
        return warrantyDays;
    }

    @Override
    public double calculateTax(){
        return getPrice() * 0.10;
    }
}
