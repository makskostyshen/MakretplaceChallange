package system;

import system.instances.Product;
import system.instances.User;

public class Recording {
    private User user;
    private Product product;

    public Recording(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return user.getId() + " " + product.getId();
    }
}
