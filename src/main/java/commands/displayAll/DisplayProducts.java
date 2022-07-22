package commands.displayAll;

import commands.Command;
import system.MarketplaceSystem;

import java.util.Collection;

public class DisplayProducts implements Command {

    @Override
    public void execute(MarketplaceSystem system) {
        Collection collection = system.getProductMap().values();

        for(Object o: collection){
            System.out.println(o);
        }
    }
}
