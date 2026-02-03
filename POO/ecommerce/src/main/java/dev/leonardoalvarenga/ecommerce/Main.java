package dev.leonardoalvarenga.ecommerce;

import dev.leonardoalvarenga.ecommerce.enums.PaymentMethod;
import dev.leonardoalvarenga.ecommerce.interfaces.Taxable;
import dev.leonardoalvarenga.ecommerce.models.Book;
import dev.leonardoalvarenga.ecommerce.models.Electronics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Order pedido = new Order();

        pedido.addProduct(new Book("Pequeno Príncipe", 20, "Antoine"));
        pedido.addProduct(new Electronics("TV", 2000, 365));

        double subtotal = pedido.calculateTotalPrice();

        PaymentMethod method = PaymentMethod.PIX;
        double valorFinal = method.calculateFinalPrice(subtotal);

        System.out.println("Total: R$" + valorFinal);
    }
}