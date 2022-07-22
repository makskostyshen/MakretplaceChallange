package commands;

import system.MarketplaceSystem;
import system.instances.Product;
import system.instances.User;

public class Buy implements Command{

    private int userId;
    private int productId;

    public Buy(int userId, int productId) {
        this.userId = userId;
        this.productId = productId;
    }

    @Override
    public void execute(MarketplaceSystem system) {
        User user = system.getUserById(userId);

        Product product = system.getProductById(productId);
        int price = product.getPrice();

        user.spendMoney(price);
        system.getHistory().addRecording(user, product);
    }
}
