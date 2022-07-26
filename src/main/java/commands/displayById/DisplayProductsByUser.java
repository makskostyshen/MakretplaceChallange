package commands.displayById;

import commands.Command;
import commands.Display;
import system.MarketplaceSystem;
import system.Product;

import java.util.Collection;
import java.util.Map;

public class DisplayProductsByUser implements Command {

    private int userId;

    public DisplayProductsByUser(int userId) {
        this.userId = userId;
    }

    @Override
    public void execute(MarketplaceSystem system) {
        Map<Product, Integer> boughtProductsMap = system.getUserById(userId).getBoughtProducts();
        Collection<Product> boughtProducts = boughtProductsMap.keySet();

        new Display().display(boughtProducts);
    }
}
