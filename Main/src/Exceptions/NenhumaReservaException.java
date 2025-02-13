package Exceptions;


public class NenhumaReservaException extends Exception {
    public NenhumaReservaException() {
        super("Nennhuma reserva encontrada para o cliente com esse ID");
    }
}
