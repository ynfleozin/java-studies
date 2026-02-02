package dev.leonardoalvarenga.ecommerce;

import dev.leonardoalvarenga.ecommerce.models.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
    @Test
    void verificandoGets(){
        Book book = new Book("Pequeno Príncipe", 20, "Antoine");
        String author = book.getAuthor();
        String name = book.getName();

        assertEquals("Antoine", author);
        assertEquals("Pequeno Príncipe", name);
    }
}
