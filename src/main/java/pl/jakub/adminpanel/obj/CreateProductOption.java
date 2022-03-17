package pl.jakub.adminpanel.obj;

import pl.jakub.adminpanel.builder.ProductBuilder;
import pl.jakub.adminpanel.service.ProductService;

public class CreateProductOption extends Option {

    private final ProductService productService;

    public CreateProductOption(ProductService productService) {
        super("create-product");

        this.productService = productService;
    }

    @Override
    public void execute() {
        productService.createProduct(new ProductBuilder()
                .setName("Test")
                .getProduct());

        productService.findProduct(1)
                .ifPresent( product -> {
                    System.out.println("Produkt: " + product.getName());
                } );
    }

}
