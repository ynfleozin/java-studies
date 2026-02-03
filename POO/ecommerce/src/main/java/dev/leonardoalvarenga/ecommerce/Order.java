package dev.leonardoalvarenga.ecommerce;

import dev.leonardoalvarenga.ecommerce.interfaces.Taxable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    private List<Product> items;

    public Order(){
        this.id = UUID.randomUUID();
        this.items = new ArrayList<>();
    }

    public void addProduct(Product p){
        items.add(p);
    }

    public double calculateTotalPrice(){
        double total = 0;

        for(Product item : items){
            if(item instanceof Taxable){
                total += ((Taxable) item).calculateTax();
            }

            total += item.getPrice();
        }

        return total;
    }
}
