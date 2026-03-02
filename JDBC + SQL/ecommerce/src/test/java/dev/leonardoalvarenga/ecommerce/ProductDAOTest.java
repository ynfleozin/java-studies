package dev.leonardoalvarenga.ecommerce;

import dev.leonardoalvarenga.ecommerce.DAO.ProductDAO;
import dev.leonardoalvarenga.ecommerce.models.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductDAOTest {
    @Test
    public void shouldCreateDataBaseIfNotExists(){
        ProductDAO productDAO = new ProductDAO();

        assertDoesNotThrow(productDAO::createTableIfNotExists);
    }

    @Test
    public void shouldSaveProductSuccessfully(){
        Product product = new Product("Notebook", 4000, 10);
        ProductDAO productDAO = new ProductDAO();

        assertDoesNotThrow(() -> {
            productDAO.save(product);
        });
    }
}
