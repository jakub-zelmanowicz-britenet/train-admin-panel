package pl.jakub.adminpanel.builder;

import pl.jakub.adminpanel.obj.Product;

public class ProductBuilder {

    private final Product product;

    public ProductBuilder(int id) {
        this.product = new Product(id);
    }

    public ProductBuilder setName(String name) {
        this.product.setName(name);
        return this;
    }

    public ProductBuilder setCategoryId(int categoryId) {
        this.product.setCategoryId(categoryId);
        return this;
    }

    public Product getProduct() {
        return this.product;
    }
}
