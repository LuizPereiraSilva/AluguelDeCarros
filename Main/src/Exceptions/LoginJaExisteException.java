package Exceptions;

public class LoginJaExisteException extends Exception{
    public LoginJaExisteException(){
        super("Login já existe");
    }
}
