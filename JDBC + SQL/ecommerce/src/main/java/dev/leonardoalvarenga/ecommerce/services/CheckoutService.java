package dev.leonardoalvarenga.ecommerce.services;

import dev.leonardoalvarenga.ecommerce.config.ConnectionFactory;
import dev.leonardoalvarenga.ecommerce.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CheckoutService {
    private ConnectionFactory factory;

    public CheckoutService(){
        this.factory = new ConnectionFactory();
    }

    public void buyProducts(List<Product> cart){
        String sql = "UPDATE products SET stock = stock - 1 WHERE id = ?";

        try(Connection conn = factory.getConnection()){
            conn.setAutoCommit(false);

            try(PreparedStatement pstmt = conn.prepareStatement(sql)){

                for(Product p : cart){
                    if(p.getName().equals("Placa de Vídeo")){
                        throw new SQLException("Estoque insuficiente de Placa de Vídeo!");
                    }

                    pstmt.setLong(1, p.getId());
                    pstmt.executeUpdate();
                }

                conn.commit();
                System.out.println("Compra finalizada com SUCESSO! Estoque atualizado.");

            }catch(SQLException e){
                conn.rollback();
                throw new RuntimeException("ERRO na compra. Fazendo ROLLBACK! Motivo: " + e.getMessage());
            }

        }catch(SQLException e){
            throw new RuntimeException("ERRO ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
