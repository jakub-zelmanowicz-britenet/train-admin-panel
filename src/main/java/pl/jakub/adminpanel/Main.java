package pl.jakub.adminpanel;

import pl.jakub.adminpanel.obj.CreateProductOption;
import pl.jakub.adminpanel.obj.Option;
import pl.jakub.adminpanel.service.OptionService;
import pl.jakub.adminpanel.service.ProductService;

public class Main {

    private static OptionService optionService;

    public static void configure() {
        ProductService productService = new ProductService();

        optionService = new OptionService();
        optionService.registerOption(new CreateProductOption(productService));
    }

    public static void main(String[] args) {
        configure();

        optionService.findOption("create-product")
                .ifPresent(Option::execute);
    }

}
