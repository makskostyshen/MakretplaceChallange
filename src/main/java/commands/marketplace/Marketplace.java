package commands.marketplace;

import commands.buy.Buy;
import commands.Command;
import commands.displayAll.DisplayProducts;
import commands.displayAll.DisplayUsers;
import commands.displayById.DisplayProductsByUser;
import commands.displayById.DisplayUsersByProduct;
import system.MarketplaceSystem;

/**
 * Java practical test challenge: marketplace challenge
 *
 * Basic system requirements are made
 *
 * @author Maksym Kostyshen
 *
 */

public class Marketplace {

    private MarketplaceSystem system;

    public void executeCommand(Command command){
        command.execute(system);
    }

    public Marketplace(){
        system = new MarketplaceSystem();
    }


    public static void main(String[] args) {
        try{
            //example
            Marketplace marketplace = new Marketplace();

            marketplace.executeCommand(new DisplayUsers());
            marketplace.executeCommand(new DisplayProducts());

            marketplace.executeCommand(new Buy(1, 1));
            marketplace.executeCommand(new Buy(1, 2));
            marketplace.executeCommand(new Buy(3, 2));
            marketplace.executeCommand(new DisplayProductsByUser(1));

            marketplace.executeCommand(new DisplayUsers());
            marketplace.executeCommand(new DisplayUsersByProduct(2));
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}



