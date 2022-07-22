package commands.displayById;

import commands.Command;
import system.MarketplaceSystem;
import system.instances.User;

import java.util.List;

public class DisplayUsersByProduct implements Command {

    private int productId;

    public DisplayUsersByProduct(int productId) {
        this.productId = productId;
    }

    @Override
    public void execute(MarketplaceSystem system) {

        List<User> users = system.getHistory().getUsersByProduct(productId);
        System.out.println(users);
    }
}
