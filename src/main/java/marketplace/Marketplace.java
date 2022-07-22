package marketplace;

import commands.Buy;
import commands.Command;
import commands.displayAll.DisplayProducts;
import commands.displayAll.DisplayUsers;
import commands.displayById.DisplayProductsByUser;
import commands.displayById.DisplayUsersByProduct;
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
        marketplace.executeCommand(new DisplayProducts());

        marketplace.executeCommand(new Buy(1, 1));
        marketplace.executeCommand(new Buy(1, 2));
        marketplace.executeCommand(new Buy(3, 1));

        marketplace.executeCommand(new DisplayUsersByProduct(1));
        marketplace.executeCommand(new DisplayProductsByUser(1));


//        MarketplaceSystem system = new MarketplaceSystem();
//        system.getHistory().addRecording(system.getUserById(1), system.getProductById(1));
//        System.out.println(system.getHistory());
    }
}



