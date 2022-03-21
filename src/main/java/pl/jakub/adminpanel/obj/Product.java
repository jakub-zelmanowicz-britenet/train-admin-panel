package pl.jakub.adminpanel.obj;

public class Product {

    private final int id;
    private String name;
    private int categoryId;

    public Product(){
        this.id = 0;
    }

    public Product(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
