package dev.leonardoalvarenga.ecommerce;

import dev.leonardoalvarenga.ecommerce.config.ConnectionFactory;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConnectionFactoryTest {
    @Test
    public void shouldCreateConnectionSuccessfully(){
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.getConnection();

        assertNotNull(connection);
    }
}
