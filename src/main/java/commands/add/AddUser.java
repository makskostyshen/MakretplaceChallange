package commands.add;

import commands.Command;
import system.MarketplaceSystem;
import system.Product;
import system.User;

public class AddUser implements Command{

    private static int indexesUsed = 0;

    private String firstName;
    private String lastName;
    private double balance;

    @Override
    public void execute(MarketplaceSystem system) {
        int index = ++indexesUsed;
        system.getUserMap().put(index, new User(index, firstName, lastName, balance));
    }

    public AddUser(Object... parameters){
        ParametersChecker checker = new ParametersChecker();

        checker.makeSureParametersAreNotNull(parameters);
        checker.makeSureLengthIsCorrect(3, parameters);

        firstName = checker.getStringParameter(parameters[0]);
        lastName = checker.getStringParameter(parameters[1]);
        balance = checker.getNumericParameter(parameters[2]);
    }
}
