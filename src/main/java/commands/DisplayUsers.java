package commands;

import system.MarketplaceSystem;
import system.User;

import java.util.Collection;

public class DisplayUsers implements Command{

    @Override
    public void execute(MarketplaceSystem system) {
        Collection collection = system.getUserMap().values();

        for(Object o: collection){
            System.out.println(o);
        }

    }
}
