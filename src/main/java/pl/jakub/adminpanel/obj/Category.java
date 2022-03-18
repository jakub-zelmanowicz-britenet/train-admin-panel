package pl.jakub.adminpanel.obj;

public class Category {

    private final int id;
    private String name;

    public Category(String name) {
        this.id = 0;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
