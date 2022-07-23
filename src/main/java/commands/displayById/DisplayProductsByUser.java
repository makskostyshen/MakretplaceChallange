package commands.displayById;

import commands.Command;
import system.MarketplaceSystem;
import system.Components.Product;

import java.util.Map;

public class DisplayProductsByUser implements Command {

    private int userId;

    public DisplayProductsByUser(int userId) {
        this.userId = userId;
    }

    @Override
    public void execute(MarketplaceSystem system) {
        Map<Product, Integer> boughtProducts = system.getUserById(userId).getBoughtProducts();
        System.out.println(boughtProducts);
    }
}
