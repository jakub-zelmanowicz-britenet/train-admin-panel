package pl.jakub.adminpanel;

import pl.jakub.adminpanel.service.OptionService;

public class Main {

    private final OptionService optionService;

    public Main() {
        this.optionService = new OptionService();
    }

    public static void main(String[] args) {
        System.out.println("Test");
    }

}
