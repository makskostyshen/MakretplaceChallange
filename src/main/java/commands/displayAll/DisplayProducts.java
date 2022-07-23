package commands.displayAll;

import commands.Command;
import commands.Display;
import commands.system.MarketplaceSystem;
import commands.system.Product;

import java.util.Collection;

public class DisplayProducts implements Command {

    @Override
    public void execute(MarketplaceSystem system) {
        Collection<Product> products = system.getProductMap().values();

        new Display().display(products);
    }
}
