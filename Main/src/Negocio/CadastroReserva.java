package Negocio;

import Dados.ReservaRepositorio;
import Dados.CarroRepositorio;
import Dados.ContasRepositorio;

import Negocio.Basico.Reserva;
import Negocio.Basico.Carro;
import Negocio.Basico.Conta;

import Exceptions.Contas.ContaNaoExisteException;

import java.util.Date;

public class CadastroReserva {

    private int ultimoIdReserva;
    private ReservaRepositorio reservaRepositorio;
    private ContasRepositorio contasRepositorio;
    private CarroRepositorio carroRepositorio;
    private static CadastroReserva instance;

    private CadastroReserva(){
        this.ultimoIdReserva = 0;
        this.reservaRepositorio = ReservaRepositorio.getInstance();
        this.contasRepositorio = ContasRepositorio.getInstance();
        this.carroRepositorio = CarroRepositorio.getInstance();
    }

    protected static CadastroReserva getInstance(){
        if(instance == null){
            instance = new CadastroReserva();
        }

        return instance;
    }

    public void adicionarReserva(Carro carro, Conta cliente, Date dataInicio, Date dataFinal,
                                 String formaDePagamento){

        Carro auxCarro = this.carroRepositorio.buscarCarroPorId(carro.getIdCarro());

        if(auxCarro != null){
            Reserva reserva = new Reserva(carro, cliente, dataInicio, dataFinal, formaDePagamento);
            reserva.setNumero(ultimoIdReserva + 1);
            ultimoIdReserva++;
            reservaRepositorio.adicionarReserva(reserva);
        }
    }

    public void removerReserva(int idReserva){
        this.reservaRepositorio.removerReserva(idReserva);
    }

    public Reserva buscarReserva(int idReserva){
        return this.reservaRepositorio.buscarReserva(idReserva);
    }

    public Resreva [] buscarReservaPorCarro(int carroID ) {
        return this.reservaRepositório.buscarReservas.RbuscraResesrvasporCarro(carroId);
    }

    public void atualizarReserva(int idReserva, Carro carro, Conta cliente, Date dataInicio,
                                 Date dataFinal, String formaDePagamento){

        Carro auxCarro = this.carroRepositorio.buscarCarroPorId(carro.getIdCarro());
        Reserva auxReserva = this.reservaRepositorio.buscarReserva(idReserva);

        if(auxCarro != null && auxReserva != null){
            Reserva reserva = new Reserva(carro, cliente, dataInicio, dataFinal, formaDePagamento);
            reserva.setNumero(idReserva);
            reservaRepositorio.atualizarReserva(reserva);
        }
    }

    public Reserva[] buscarReservasCliente(int idCliente){
        return this.reservaRepositorio.buscarReservasPorCliente(idCliente);
    }

    public String listarReservas(){
        return reservaRepositorio.toString();
    }
}
