package dev.leonardoalvarenga.ecommerce;

import dev.leonardoalvarenga.ecommerce.DAO.ProductDAO;
import dev.leonardoalvarenga.ecommerce.models.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    public void shouldFindAllProducts(){
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product("Mouse Gamer", 200, 10);

        productDAO.save(product);
        List<Product> products = productDAO.findAll();

        assertFalse(products.isEmpty());
    }

    @Test
    public void shouldUpdateProductSuccessfully(){
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product("Mouse Gamer", 200, 10);

        productDAO.save(product);
        List<Product> products = productDAO.findAll();
        Product productDb = products.get(products.size() - 1);

        productDb.setStock(30);

        assertDoesNotThrow(() -> {
            productDAO.update(productDb);
        });
    }

    @Test
    public void shouldDeleteProductSuccessfully(){
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product("Mouse Gamer", 200, 10);

        productDAO.save(product);
        List<Product> products = productDAO.findAll();

        Long id = products.get(products.size() - 1).getId();

        assertDoesNotThrow(() -> {
            productDAO.delete(id);
        });
    }
}
