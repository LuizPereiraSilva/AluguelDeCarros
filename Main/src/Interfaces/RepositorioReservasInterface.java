package Interfaces;

import Negocio.Basico.Reserva;

public interface RepositorioReservasInterface {

    public void adicionarReserva(Reserva reserva);

    public void removerReserva(int idReserva);

    public Reserva buscarReserva(int numero);

    public void atualizarReserva(Reserva reservaAtualizada);

    public Reserva[] buscarReservasPorCliente(int idCliente);
}
