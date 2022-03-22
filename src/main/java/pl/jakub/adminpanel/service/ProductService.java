package pl.jakub.adminpanel.service;

import pl.jakub.adminpanel.builder.ProductBuilder;
import pl.jakub.adminpanel.obj.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProductService {

    private final DatabaseService databaseService;
    private final Map<Integer, Product> products;

    public ProductService(DatabaseService databaseService) {
        this.databaseService = databaseService;
        this.products = new HashMap<>();
    }

    public void createProduct(Product product) {
        this.databaseService.performDML(
                "INSERT INTO product (name, categoryId) VALUES ('" + product.getName() + "', '" + product.getCategoryId() + "')"
        );
    }

    public void updateProduct(Product product) {
        if (this.products.containsKey(product.getId())) {
            this.products.replace(product.getId(), product);
        }
        else {
            throw new IllegalStateException("No product under given ID");
        }
    }

    public Optional<Product> findProduct(int id) {
        String query = String.format("SELECT * FROM product WHERE id=%d", id);
        Product product = this.databaseService.performQuery(query, resultSet -> {

            if (resultSet.next()) {

                String name = resultSet.getString("name");
                int categoryId = resultSet.getInt("categoryId");

                return new ProductBuilder(id)
                        .setName(name)
                        .setCategoryId(categoryId)
                        .getProduct();
            }

            return null;

        });

        return Optional.ofNullable(product);
    }

//    public Optional<Product> findProduct(int id) {
//        try (Connection connection = this.databaseService.getConnection() ;
//             PreparedStatement statement = connection.prepareStatement(
//                     "SELECT * FROM product WHERE id=" + id)) {
//
//            ResultSet results = statement.executeQuery();
//            if (results.next()) {
//
//                String name = results.getString("name");
//                int categoryId = results.getInt("categoryId");
//
//                Product product = new ProductBuilder(id)
//                        .setName(name)
//                        .setCategoryId(categoryId)
//                        .getProduct();
//
//                return Optional.of(product);
//            }
//
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return Optional.empty();
//    }

    public void removeProduct(int id) {
        this.products.remove(id);
    }
}
