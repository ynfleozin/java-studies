package dev.leonardoalvarenga.ecommerce;

import dev.leonardoalvarenga.ecommerce.DAO.ProductDAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductDAOTest {
    @Test
    public void shouldCreateDataBaseIfNotExists(){
        ProductDAO productDAO = new ProductDAO();

        assertDoesNotThrow(productDAO::createTableIfNotExists);
    }
}
