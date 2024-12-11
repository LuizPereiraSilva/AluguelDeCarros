package Negocio;
import Dados.ContasRepositorio;
import Negocio.Basico.Conta;
import Negocio.Basico.Cliente;
import Negocio.Basico.Administrador;

public class CadastroConta {

    private ContasRepositorio repositorio;
    private int ultimoId;
    private static CadastroConta instancia;

    private CadastroConta(){
        this.repositorio = ContasRepositorio.getInstance();
        this.ultimoId = 0;
    }

    public static CadastroConta getInstance(){
        if(instancia == null){
            instancia = new CadastroConta();
        }
        return instancia;
    }

    public void cadastrarCliente(String nome, String cpf, String telefone){
        Conta cliente = new Cliente(nome, cpf, telefone);
        cliente.setIdConta(this.ultimoId + 1);
        this.ultimoId++;
        this.repositorio.adicionarConta(cliente);
    }

    public void cadastrarAdministrador(String nome, String cpf, String telefone){

        Conta administrador = new Administrador(nome, cpf, telefone);
        administrador.setIdConta(this.ultimoId + 1);
        this.ultimoId++;
        this.repositorio.adicionarConta(administrador);
    }

    public void removerConta(int contaId){
        repositorio.remover(contaId);
    }

    public Conta buscarConta(int contaId){
        return repositorio.buscarConta(contaId);
    }

    public void atualizarConta(String nome, int id, String cpf, String telefone){
        Conta conta = repositorio.buscarConta(id);
        if(conta != null) {
            if (conta.getAdministrador()) {
                Conta administrador = new Administrador(nome, cpf, telefone);
                administrador.setIdConta(id);
                repositorio.atualizarConta(administrador);
            } else {
                Conta cliente = new Cliente(nome, cpf, telefone);
                cliente.setIdConta(id);
                repositorio.atualizarConta(cliente);
            }
        }
    }

    public void listarContas(){
        System.out.println(repositorio);
    }
}
