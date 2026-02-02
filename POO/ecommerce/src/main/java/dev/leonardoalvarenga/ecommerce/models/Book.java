package dev.leonardoalvarenga.ecommerce.models;

import dev.leonardoalvarenga.ecommerce.Product;

public class Book extends Product {
    private String author;

    public Book(String name, double price, String author){
        super(name, price);
        this.author = author;
    }

    public String getAuthor(){
        return author;
    }
}
