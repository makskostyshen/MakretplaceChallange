package commands.displayAll;

import commands.Command;
import system.MarketplaceSystem;

import java.util.Collection;

public class DisplayUsers implements Command {

    @Override
    public void execute(MarketplaceSystem system) {
        Collection collection = system.getUserMap().values();

        for(Object o: collection){
            System.out.println(o);
        }
    }
}
