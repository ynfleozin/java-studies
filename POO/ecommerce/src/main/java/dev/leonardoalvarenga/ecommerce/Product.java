package dev.leonardoalvarenga.ecommerce;

import java.util.Objects;
import java.util.UUID;

public class Product {
    private String name;
    private double price;
    private final UUID id;

    public Product(String nome, double preco){
        if(preco < 0){
            throw new IllegalArgumentException("Apenas valores positivos!");
        }
        this.id = UUID.randomUUID();
        this.name = nome;
        this.price = preco;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public UUID getUuid() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
