package Negocio;

import Exceptions.DataInvalidaException;
import Exceptions.NenhumaReservaException;
import Negocio.Basico.Cliente;
import Negocio.Basico.Carro;
import Negocio.Basico.Reserva;

import Exceptions.LoginJaExisteException;
import Exceptions.Contas.ContaNaoExisteException;

import java.time.LocalDate;
import java.util.Date;

public class NavegarCliente {

    private Cliente login;
    private CadastroReserva reservas;
    private static NavegarCliente instance;

    private NavegarCliente(Cliente login) throws ContaNaoExisteException{
        CadastroConta contas = CadastroConta.getInstance();
        contas.buscarConta(login.getIdConta());

        this.login = login;
        this.reservas = CadastroReserva.getInstance();
    }

    public static NavegarCliente getInstance(Cliente login) throws LoginJaExisteException,
            ContaNaoExisteException{
        if(!NavegarAdministrador.existeInstancia()) {
            if (instance == null) {
                instance = new NavegarCliente(login);
            }

            return instance;
        } else{
            throw new LoginJaExisteException();
        }
    }

    public static boolean existeInstancia(){
        if(instance == null){
            return false;
        } else{
            return true;
        }
    }

    public static void removerInstance(){
        instance = null;
    }

    public void realizarReserva(Carro carro, LocalDate datainicio, LocalDate datafinal, String metodoDePagamento) throws DataInvalidaException {
        reservas.cadastrarReserva(carro, this.login, datainicio, datafinal, metodoDePagamento);
    }

    public void removerReserva(int id){
        reservas.removerReserva(id);
    }

    public void atualizarReserva(int id, Carro carro, LocalDate dataInicio, LocalDate dataFinal,
                                 String metodoDePagamento){

        reservas.atualizarReserva(id, carro, this.login, dataInicio, dataFinal, metodoDePagamento);
    }

    public Reserva[] getReservas() throws NenhumaReservaException {
        return reservas.buscarReservasCliente(this.login.getIdConta());
    }
}