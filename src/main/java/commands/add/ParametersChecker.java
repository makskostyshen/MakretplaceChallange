package commands.add;

public class ParametersChecker {

    public void makeSureParametersAreNotNull(Object... parameters){
        for (Object parameter: parameters){
            if(parameter == null){
                throw new IllegalParameterException("One of parameters is null");
            }
        }
    }

    public double getNumericParameter(Object parameter){
        double numeric;
        try{
            numeric = Double.parseDouble(parameter.toString());
        }
        catch (Exception e){
            throw new IllegalParameterException("One of parameters isn't numeric");
        }
        return numeric;
    }

    public String getStringParameter(Object parameter){
        return parameter.toString();
    }

    public void makeSureLengthIsCorrect(int length, Object... parameters){
        if(parameters.length != length){
            throw new IllegalParameterException();
        }
    }
}
