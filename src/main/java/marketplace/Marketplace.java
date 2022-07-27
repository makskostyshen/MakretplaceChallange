package marketplace;

import commands.add.AddProduct;
import commands.add.AddUser;
import commands.buy.Buy;
import commands.Command;
import commands.delete.DeleteProduct;
import commands.delete.DeleteUser;
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
            /*Marketplace marketplace = new Marketplace();

            marketplace.executeCommand(new DisplayUsers());
            marketplace.executeCommand(new DisplayProducts());

            marketplace.executeCommand(new Buy(1, 1));
            marketplace.executeCommand(new Buy(1, 2));
            marketplace.executeCommand(new Buy(3, 2));
            marketplace.executeCommand(new DisplayProductsByUser(1));

            marketplace.executeCommand(new DisplayUsers());
            marketplace.executeCommand(new DisplayUsersByProduct(2));

            int a = 5;
            Object[] par = new Object[]{4, 2};
            System.out.println(par[0].getClass().equals(Number.class));
            System.out.println(par[0].getClass());
            System.out.println(Double.parseDouble(par[0].toString()));;*/

            Marketplace marketplace = new Marketplace();

            marketplace.executeCommand(new AddUser("Maks", "Kostyshen", "100"));
            marketplace.executeCommand(new AddUser("Vasyl", "Choliy", 140));
            marketplace.executeCommand(new AddUser("Vika", "Tootisk", 69));
            marketplace.executeCommand(new DisplayUsers());

            marketplace.executeCommand(new AddProduct("shampoo", 1));
            marketplace.executeCommand(new AddProduct("boiler", "2"));
            marketplace.executeCommand(new DisplayProducts());

            marketplace.executeCommand(new Buy(1, 1));
            marketplace.executeCommand(new Buy(1, 1));
            marketplace.executeCommand(new Buy(1, 2));
            marketplace.executeCommand(new Buy(2, 2));
            marketplace.executeCommand(new Buy(3, 1));

            marketplace.executeCommand(new DisplayProductsByUser(1));
            marketplace.executeCommand(new DisplayProductsByUser(2));
            marketplace.executeCommand(new DisplayProductsByUser(3));

            marketplace.executeCommand(new DeleteProduct(2));

            marketplace.executeCommand(new DisplayProductsByUser(1));
            marketplace.executeCommand(new DisplayProductsByUser(2));
            marketplace.executeCommand(new DisplayProductsByUser(3));

            marketplace.executeCommand(new DeleteUser(2));

            marketplace.executeCommand(new AddProduct("soup", 3));
            marketplace.executeCommand(new DisplayProducts());

            marketplace.executeCommand(new AddUser("Halyna", "Kravets", 3000));
            marketplace.executeCommand(new DisplayUsers());

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}



