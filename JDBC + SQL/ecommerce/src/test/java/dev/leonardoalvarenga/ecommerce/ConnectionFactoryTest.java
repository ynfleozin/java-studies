package dev.leonardoalvarenga.ecommerce;

import dev.leonardoalvarenga.ecommerce.config.ConnectionFactory;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class ConnectionFactoryTest {
    @Test
    public void shouldCreateConnectionSuccessfully(){
        ConnectionFactory factory = new ConnectionFactory();

        try (Connection connection = factory.getConnection()){
            assertNotNull(connection);
        }catch (Exception e){
            fail("Não deveria lançar exceção ao conectar: " + e.getMessage());
        }
    }
}
