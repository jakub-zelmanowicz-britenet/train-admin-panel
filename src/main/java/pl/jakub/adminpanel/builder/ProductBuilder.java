package pl.jakub.adminpanel.builder;

import pl.jakub.adminpanel.obj.Product;

public class ProductBuilder {

    private final Product product;

    public ProductBuilder() {
        this.product = new Product();
    }

    public ProductBuilder setName(String name) {
        this.product.setName(name);
        return this;
    }

    public Product getProduct() {
        return this.product;
    }
}
