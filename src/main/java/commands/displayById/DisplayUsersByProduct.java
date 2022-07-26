package commands.displayById;

import commands.Command;
import commands.Display;
import system.MarketplaceSystem;
import system.Product;
import system.User;

import java.util.ArrayList;
import java.util.Collection;

public class DisplayUsersByProduct implements Command {

    private int productId;

    public DisplayUsersByProduct(int productId) {
        this.productId = productId;
    }

    @Override
    public void execute(MarketplaceSystem system) {

        Collection<User> usersBoughtProducts = new ArrayList<>();
        Collection<User> usersAll = system.getUserMap().values();

        for (User user: usersAll){
            if(hasBoughtProduct(user, productId)){
                usersBoughtProducts.add(user);
            }
        }
        new Display().display(usersBoughtProducts);
    }


    private boolean hasBoughtProduct(User user, int productId){
        return user.getBoughtProducts().containsKey(new Product(productId, "", 1));
    }
}
