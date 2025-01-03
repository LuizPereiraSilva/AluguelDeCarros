package Negocio;

import Dados.ReservaRepositorio;
import Dados.CarroRepositorio;
import Dados.ContasRepositorio;

import Negocio.Basico.Reserva;
import Negocio.Basico.Cliente;
import Negocio.Basico.Carro;
import Negocio.Basico.Conta;

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

    public static CadastroReserva getInstance(){
        if(instance == null){
            instance = new CadastroReserva();
        }

        return instance;
    }

    public void adicionarReserva(Carro carro, Conta cliente, Date dataInicio,
                                 Date dataFinal, String formaDePagamento){
        Carro auxCarro = this.carroRepositorio.buscarCarroPorId(carro.getIdCarro());
        Conta auxCliente = this.contasRepositorio.buscarConta(cliente.getIdConta());

        if(auxCliente != null && !auxCliente.getAdministrador() && auxCarro != null){
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

    public void atualizarReserva(int idReserva, Carro carro, Conta cliente, Date dataInicio,
                                 Date dataFinal, String formaDePagamento){
        Carro auxCarro = this.carroRepositorio.buscarCarroPorId(carro.getIdCarro());
        Conta auxCliente = this.contasRepositorio.buscarConta(cliente.getIdConta());
        Reserva auxReserva = this.reservaRepositorio.buscarReserva(idReserva);

        if(auxCliente != null && !auxCliente.getAdministrador() && auxCarro != null
                && auxReserva != null){
            Reserva reserva = new Reserva(carro, cliente, dataInicio, dataFinal, formaDePagamento);
            reserva.setNumero(idReserva);
            reservaRepositorio.atualizarReserva(reserva);
        }
    }

    public String listarReservas(){
        return reservaRepositorio.toString();
    }
}
