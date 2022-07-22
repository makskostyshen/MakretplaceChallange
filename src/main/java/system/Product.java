package system;

public class Product {

    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "id: " + id + ", " +
                "name: " + name + ", " +
                "price: " + price;
    }
}
