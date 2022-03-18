package pl.jakub.adminpanel;

import pl.jakub.adminpanel.obj.CreateProductOption;
import pl.jakub.adminpanel.service.DatabaseService;
import pl.jakub.adminpanel.service.DatabaseServiceOld;
import pl.jakub.adminpanel.service.OptionService;
import pl.jakub.adminpanel.service.ProductService;

public class Main {

    private static OptionService optionService;
    private static DatabaseService databaseService;

    public static void configure() {
        databaseService = DatabaseService.getInstance();

        ProductService productService = new ProductService(databaseService);

        optionService = new OptionService();
        optionService.registerOption(new CreateProductOption(productService));
    }

    public static void main(String[] args) {
        configure();

    }

}
