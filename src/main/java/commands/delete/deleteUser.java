package commands.delete;

import commands.Command;
import system.MarketplaceSystem;

public class deleteUser implements Command {

    private final int userId;

    public deleteUser(int userId) {
        this.userId = userId;
    }

    @Override
    public void execute(MarketplaceSystem system) {
        system.getUserMap().remove(userId);
    }
}
