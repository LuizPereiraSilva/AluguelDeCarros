package Negocio;

import Dados.ReservaRepositorio;
import Dados.CarroRepositorio;
import Dados.ContasRepositorio;

import Exceptions.NenhumaReservaException;
import Negocio.Basico.Reserva;
import Negocio.Basico.Carro;
import Negocio.Basico.Conta;

import Exceptions.DataInvalidaException;
import Exceptions.Contas.ContaNaoExisteException;

import java.time.LocalDate;
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

    public void cadastrarReserva(Carro carro, Conta cliente, LocalDate datainicio, LocalDate datafinal,
                                 String formaDePagamento) throws DataInvalidaException {

        Carro auxCarro = this.carroRepositorio.buscarCarroPorId(carro.getIdCarro());

        if(auxCarro != null && datafinal.isAfter(datainicio)){
            Reserva reserva = new Reserva(carro, cliente, datainicio, datafinal, formaDePagamento);
            reserva.setNumero(ultimoIdReserva + 1);
            ultimoIdReserva++;
            reservaRepositorio.adicionarReserva(reserva);
        }
        else {
            throw new DataInvalidaException();
        }
    }

    public void removerReserva(int idReserva){
        this.reservaRepositorio.removerReserva(idReserva);
    }

    public Reserva buscarReserva(int idReserva){
        return this.reservaRepositorio.buscarReserva(idReserva);
    }

    public Reserva[] buscarReservasCarro(int IdCarro) {
        return this.reservaRepositorio.buscarReservasPorCarro(IdCarro);
    }

    public void atualizarReserva(int idReserva, Carro carro, Conta cliente, LocalDate dataInicio,
                                 LocalDate dataFinal, String formaDePagamento){

        Carro auxCarro = this.carroRepositorio.buscarCarroPorId(carro.getIdCarro());
        Reserva auxReserva = this.reservaRepositorio.buscarReserva(idReserva);

        if(auxCarro != null && auxReserva != null){
            Reserva reserva = new Reserva(carro, cliente, dataInicio, dataFinal, formaDePagamento);
            reserva.setNumero(idReserva);
            reservaRepositorio.atualizarReserva(reserva);
        }
    }

    public Reserva[] buscarReservasCliente(int idCliente) throws NenhumaReservaException {
        return this.reservaRepositorio.buscarReservasPorCliente(idCliente);
    }

    public String listarReservas(){
        return reservaRepositorio.toString();
    }

    public String gerarRelatorioCompleto(int IdCliente) throws NenhumaReservaException {

        return reservaRepositorio.gerarRelatorioPorCliente(IdCliente);
    }

}
