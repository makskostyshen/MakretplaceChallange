package system;

public class Product {

    private final int id;
    private final String name;
    private final double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode(){
        return id;
    }

    @Override
    public String toString() {
        return "id: " + id + ", " +
                "name: " + name + ", " +
                "price: " + price;
    }
}
