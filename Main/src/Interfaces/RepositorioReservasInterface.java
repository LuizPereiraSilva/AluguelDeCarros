package Interfaces;

import Exceptions.DataInvalidaException;
import Exceptions.Reservas.NenhumaReservaException;
import Negocio.Basico.Reserva;

import java.time.LocalDate;

public interface RepositorioReservasInterface {

    public void adicionarReserva(Reserva reserva);

    public void removerReserva(int idReserva);

    public Reserva buscarReserva(int numero);

    public void atualizarReserva(Reserva reservaAtualizada);

    public Reserva[] buscarReservasPorCliente(int idCliente) throws NenhumaReservaException;

    public Reserva[] buscarReservasPorCarro(int idCarro) throws NenhumaReservaException;

    public Reserva[] buscarReservasPorPeriodo(LocalDate datainicio, LocalDate datafinal) throws NenhumaReservaException;

    public String gerarRelatorioPorCliente (int idCliente) throws NenhumaReservaException;

    public float gerarFaturamentoPorPeriodo (LocalDate datainicio, LocalDate datafinal) throws NenhumaReservaException, DataInvalidaException;

}

