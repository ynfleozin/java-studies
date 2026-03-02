package dev.leonardoalvarenga.ecommerce.DAO;

import dev.leonardoalvarenga.ecommerce.config.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDAO {
    private ConnectionFactory factory;

    public ProductDAO(){
        this.factory = new ConnectionFactory();
    }

    public void createTableIfNotExists(){
        String sql = "CREATE TABLE IF NOT EXISTS products (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "price REAL NOT NULL, " +
                "stock INTEGER NOT NULL" +
                ");";

        try(Connection conn = factory.getConnection();
            Statement stmt = conn.createStatement()){

            stmt.execute(sql);
            System.out.println("Tabela 'products' verificada com sucesso!");

        }catch(SQLException e){
            throw new RuntimeException("ERRO ao criar tabela: " + e.getMessage());
        }
    }
}
