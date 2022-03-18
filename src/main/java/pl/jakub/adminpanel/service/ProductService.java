package pl.jakub.adminpanel.service;

import pl.jakub.adminpanel.obj.Product;

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
        return Optional.of(this.products.get(id));
    }

    public void removeProduct(int id) {
        this.products.remove(id);
    }
}
