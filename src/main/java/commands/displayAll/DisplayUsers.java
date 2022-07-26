package commands.displayAll;

import commands.Command;
import commands.Display;
import system.MarketplaceSystem;
import system.User;

import java.util.Collection;

public class DisplayUsers implements Command {

    @Override
    public void execute(MarketplaceSystem system) {
        Collection<User> users = system.getUserMap().values();

        new Display().display(users);
    }
}
