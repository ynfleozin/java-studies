package dev.leonardoalvarenga.ecommerce;

import dev.leonardoalvarenga.ecommerce.models.Book;
import dev.leonardoalvarenga.ecommerce.models.Electronics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> carrinho = new ArrayList<>();

        carrinho.add(new Book("Pequeno Príncipe", 20, "Antoine"));
        carrinho.add(new Electronics("TV", 2000, 365));

        for(Product item : carrinho){
            System.out.println("Item: " + item.getName());
            System.out.println("Preço: " + item.getPrice());

            if(item instanceof Book){
                Book book = (Book) item;
                System.out.println("Autor: " + book.getAuthor());
            }

            if(item instanceof Electronics){
                Electronics electronics = (Electronics) item;
                System.out.println("Garantia: " + electronics.getWarrantyDays() + " dias");
            }

            System.out.println("-----------------------");
        }
    }
}