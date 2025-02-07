package Negocio;

import Exceptions.DataInvalidaException;
import Exceptions.Contas.ContaJaExisteException;
import Exceptions.Contas.ContaNaoExisteException;
import Exceptions.RepositorioCheioException;
import Negocio.Basico.Carro;
import Negocio.Basico.Conta;
import Negocio.Basico.Reserva;
import Negocio.CadastroConta;
import Negocio.CadastroCarro;
import Negocio.CadastroReserva;

import java.util.Date;

public class Fachada {

    private CadastroConta contas;
    private CadastroCarro carros;
    private CadastroReserva reservas;
    private static Fachada instance;

    private Fachada(){
        this.contas = CadastroConta.getInstance();
        this.carros = CadastroCarro.getInstance();
        this.reservas = CadastroReserva.getInstance();
    }

    public static Fachada getInstance(){
        if(instance == null){
            instance = new Fachada();
        }
        return instance;
    }

    //Métodos de Conta

    public void cadastrarCliente(String nome, String cpf, String telefone) throws
            ContaJaExisteException, RepositorioCheioException{
        contas.cadastrarCliente(nome, cpf, telefone);
    }

    public void cadastrarAdministrador(String nome, String cpf, String telefone) throws
            ContaJaExisteException, RepositorioCheioException{
        contas.cadastrarAdministrador(nome, cpf, telefone);
    }

    public void removerConta(int contaId) throws ContaNaoExisteException{
        contas.removerConta(contaId);
    }

    public Conta buscarConta(int contaId) throws ContaNaoExisteException{
        return contas.buscarConta(contaId);
    }

    public void atualizarConta(String nome, int id, String cpf, String telefone) throws
            ContaNaoExisteException{
        contas.atualizarConta(nome, id, cpf, telefone);
    }

    public String listarContas(){
        return contas.listarContas();
    }

    //Métodos de Carro

    public void cadastrarCarro(int modelo, float preco, String caracteristicas){
        carros.cadastrarCarro(modelo, preco, caracteristicas);
    }

    public void removerCarro(int id){
        carros.removerCarro(id);
    }

    public Carro buscarCarro(int id){
        return carros.buscarCarro(id);
    }

    public void atualizarPreco(int id, float novoPreco){
        carros.atualizarPreco(id, novoPreco);
    }

    public String listarCarros(){
        return carros.listarCarros();
    }

    //Métodos de Reserva

    public void cadastrarReserva(Carro carro, Conta cliente, Date dataInicio, Date dataFinal,
                                 String formaDePagamento) throws DataInvalidaException{
        reservas.cadastrarReserva(carro, cliente, dataInicio, dataFinal, formaDePagamento);
    }

    public void removerReserva(int idReserva){
        reservas.removerReserva(idReserva);
    }

    public Reserva buscarReserva(int idReserva){
        return reservas.buscarReserva(idReserva);
    }

    public void atualizarReserva(int idReserva, Carro carro, Conta cliente, Date dataInicio,
                                 Date dataFinal, String formaDePagamento){
        reservas.atualizarReserva(idReserva, carro, cliente, dataInicio, dataFinal, formaDePagamento);
    }

    public Reserva[] buscarReservasCliente(int idCliente){
        return reservas.buscarReservasCliente(idCliente);
    }

    public String listarReservas(){
        return reservas.listarReservas();
    }
}
