package commands.displayById;

import commands.Command;
import system.MarketplaceSystem;
import system.instances.Product;
import system.instances.User;

import java.util.List;

public class DisplayProductsByUser implements Command {

    private int userId;

    public DisplayProductsByUser(int userId) {
        this.userId = userId;
    }

    @Override
    public void execute(MarketplaceSystem system) {

        List<Product> products = system.getHistory().getProductsByUser(userId);
        System.out.println(products);
    }
}
