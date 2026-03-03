package dev.leonardoalvarenga.ecommerce.DAO;

import dev.leonardoalvarenga.ecommerce.config.ConnectionFactory;
import dev.leonardoalvarenga.ecommerce.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private ConnectionFactory factory;

    public ProductDAO() {
        this.factory = new ConnectionFactory();
    }

    public void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS products (" + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "name TEXT NOT NULL, " + "price REAL NOT NULL, " + "stock INTEGER NOT NULL" + ");";

        try (Connection conn = factory.getConnection(); Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Tabela 'products' verificada com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("ERRO ao criar tabela: " + e.getMessage());
        }
    }

    public void save(Product product) {
        String sql = "INSERT INTO products (name, price, stock) VALUES (?, ?, ?)";

        try (Connection conn = factory.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setInt(3, product.getStock());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("ERRO ao salvar produto: " + e.getMessage());
        }
    }

    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        List<Product> products = new ArrayList<>();

        try (Connection conn = factory.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Product product = new Product();

                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setStock(rs.getInt("stock"));

                products.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produtos: " + e.getMessage());
        }

        return products;
    }

    public void update(Product product) {
        String sql = "UPDATE products SET name = ?, price = ?, stock = ? WHERE id = ?";
        try (Connection conn = factory.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setInt(3, product.getStock());
            pstmt.setLong(4, product.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("ERRO ao atualizar produto: " + e.getMessage());
        }
    }
}
