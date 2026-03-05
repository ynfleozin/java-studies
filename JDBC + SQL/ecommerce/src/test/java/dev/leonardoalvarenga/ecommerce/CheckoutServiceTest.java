package dev.leonardoalvarenga.ecommerce;

import dev.leonardoalvarenga.ecommerce.DAO.ProductDAO;
import dev.leonardoalvarenga.ecommerce.models.Product;
import dev.leonardoalvarenga.ecommerce.services.CheckoutService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckoutServiceTest {
    @Test
    public void shouldRollbackTransactionWhenErrorOccurs(){
        ProductDAO dao = new ProductDAO();
        CheckoutService service = new CheckoutService();

        dao.save(new Product("Teclado", 150, 10));
        dao.save(new Product("Monitor", 800, 5));
        dao.save(new Product("Placa de Vídeo", 2000, 2));

        List<Product> currentProducts = dao.findAll();

        List<Product> cart = currentProducts.subList(currentProducts.size() - 3, currentProducts.size());

        int currentKeyboardStock = cart.get(0).getStock();

        assertThrows(RuntimeException.class, () -> {
           service.buyProducts(cart);
        });

        List<Product> productsAfter = dao.findAll();
        int keyboardStockAfter = productsAfter.get(productsAfter.size() - 3).getStock();

        assertEquals(currentKeyboardStock, keyboardStockAfter);
    }
}
