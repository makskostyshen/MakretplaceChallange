package commands.buy;

import commands.Command;
import commands.Display;
import system.MarketplaceSystem;
import system.Product;
import system.User;

import java.util.Map;

public class Buy implements Command {

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

        double price = product.getPrice();
        double newBalance = user.getBalance() - price;

        makeSureBalanceIsOkay(newBalance);

        user.setBalance(newBalance);
        updateBoughtProducts(user, product);
    }


    private void updateBoughtProducts(User user, Product product) {

        Map<Product, Integer> boughtProducts = user.getBoughtProducts();
        int value;

        if(boughtProducts.containsKey(product)) {
            value = boughtProducts.get(product) + 1;
        }
        else{
            value = 1;
        }
        boughtProducts.put(product, value);
    }

    private void makeSureBalanceIsOkay(double balance){
        if(balance < 0){
            throw new NotEnoughBalanceException();
        }
        else{
            new Display().display("purchase is successful");
        }
    }
}
