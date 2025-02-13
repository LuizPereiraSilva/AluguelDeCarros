package Exceptions;


public class NenhumaReservaException extends Exception {
    public NenhumaReservaException() {
        super("Nenhuma reserva encontrada para o cliente com esse Id");
    }
}
