package dev.leonardoalvarenga.ecommerce.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        try {
            String url = "jdbc:sqlite:ecommerce.db";
            return DriverManager.getConnection(url);
        } catch(SQLException e){
            throw new RuntimeException("ERRO: Não foi possível se conectar ao banco de dados." + e.getMessage());
        }
    }
}
