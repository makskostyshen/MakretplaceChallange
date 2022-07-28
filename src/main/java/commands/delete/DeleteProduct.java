package commands.delete;

import commands.Command;
import system.MarketplaceSystem;
import system.Product;
import system.User;

import java.util.Collection;

public class DeleteProduct implements Command {

    private final int productId;

    public DeleteProduct(int productId){
        this.productId = productId;
    }

    @Override
    public void execute(MarketplaceSystem system) {
        Product product = system.getProductMap().remove(productId);
        removeProductFromUsers(system, product);
    }

    private void removeProductFromUsers(MarketplaceSystem system, Product product){
        Collection<User> users = system.getUserMap().values();

        for (User user: users){
            removeProductFromUser(user, product);
        }
    }

    private void removeProductFromUser(User user, Product product){

        user.getBoughtProducts().remove(product);
    }
}
