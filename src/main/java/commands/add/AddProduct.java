package commands.add;

import commands.Command;
import system.MarketplaceSystem;
import system.Product;

public class AddProduct implements Command{

    private static int indexesUsed = 0;

    private String name;
    private double price;

    @Override
    public void execute(MarketplaceSystem system) {
        int index = ++indexesUsed;
        system.getProductMap().put(index, new Product(index, name, price));
    }

    public AddProduct(Object... parameters){
        ParametersChecker checker = new ParametersChecker();

        checker.makeSureParametersAreNotNull(parameters);
        checker.makeSureLengthIsCorrect(2, parameters);

        name = checker.getStringParameter(parameters[0]);
        price = checker.getNumericParameter(parameters[1]);
    }



}
