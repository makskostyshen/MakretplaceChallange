package commands.add;

public class IllegalParameterException extends IllegalArgumentException{
    public IllegalParameterException(String errorMessage) {
        super(errorMessage);
    }

    public IllegalParameterException(){
        super();
    }
}
