package Exceptions;

public class DataInvalidaException extends Exception{
    public DataInvalida(){
        super("A data final deve ser posterior à data inical");
    }
}
