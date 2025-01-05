package Exceptions.Contas;

public class ContaNaoExisteException extends Exception{
    public ContaNaoExisteException(){
        super("Conta não existe");
    }
}
