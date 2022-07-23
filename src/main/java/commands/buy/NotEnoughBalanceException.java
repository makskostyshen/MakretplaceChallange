package commands.buy;

public class NotEnoughBalanceException extends IllegalArgumentException{

    public NotEnoughBalanceException(String errorMessage) {
        super(errorMessage);
    }

    public NotEnoughBalanceException(){
        super();
    }
}
