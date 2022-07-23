package commands.displayAll;

import commands.Command;
import system.MarketplaceSystem;
import system.Product;

import java.util.Collection;

public class DisplayProducts implements Command {

    @Override
    public void execute(MarketplaceSystem system) {
        Collection<Product> collection = system.getProductMap().values();

        for(Product product: collection){
            System.out.println(product);
        }
    }
}
