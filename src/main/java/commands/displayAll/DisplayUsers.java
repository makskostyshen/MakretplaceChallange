package commands.displayAll;

import commands.Command;
import system.MarketplaceSystem;
import system.User;

import java.util.Collection;

public class DisplayUsers implements Command {

    @Override
    public void execute(MarketplaceSystem system) {
        Collection<User> collection = system.getUserMap().values();

        for(User user: collection){
            System.out.println(user);
        }
    }
}
