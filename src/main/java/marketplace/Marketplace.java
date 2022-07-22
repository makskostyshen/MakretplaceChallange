package marketplace;

import commands.Command;
import commands.DisplayUsers;
import system.MarketplaceSystem;

public class Marketplace {

    private MarketplaceSystem system;

    public void executeCommand(Command command){
        command.execute(system);
    }

    public Marketplace(){
        system = new MarketplaceSystem();
    }


    public static void main(String[] args) {
        Marketplace marketplace = new Marketplace();
        marketplace.executeCommand(new DisplayUsers());
    }
}



