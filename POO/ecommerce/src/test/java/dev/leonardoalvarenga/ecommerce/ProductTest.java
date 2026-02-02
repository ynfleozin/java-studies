package dev.leonardoalvarenga.ecommerce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {
    @Test
    public void erroValorNegativo(){
        assertThrows(IllegalArgumentException.class, () -> {
           Product product = new Product("Desorante", -1);
        });
    }

    @Test
    public void comparaProdutos(){
        Product p1 = new Product("Desodorante", 1);
        Product p2 = new Product("Desodorante", 1);

        assertEquals(p1, p2);
    }
}
