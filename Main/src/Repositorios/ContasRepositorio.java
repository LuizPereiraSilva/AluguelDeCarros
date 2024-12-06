package Repositorios;
import Classes.Conta;
import Classes.Cliente;
import Classes.Administrador;

public class ContasRepositorio {

    private Conta[] contas;
    private int contasIndex;
    private int ultimoId;
    private static ContasRepositorio repositorio;

    private ContasRepositorio(){
        this.contas = new Conta[10];
        this.contasIndex = 0;
        this.ultimoId = 0;
    }

    public static ContasRepositorio getInstance(){
        if(repositorio == null){
            repositorio = new ContasRepositorio();
        }
        return repositorio;
    }

    public void adicionarCliente(String nome, String cpf, String telefone){
        if(contasIndex <= 9) {
            this.contas[this.contasIndex] = new Cliente(nome, cpf, telefone);
            this.contas[this.contasIndex].setIdConta("" + (this.ultimoId + 1));
            this.ultimoId++;
            this.contasIndex++;
        }
    }

    public void adicionarAdministrador(String nome, String cpf, String telefone){
        if(contasIndex <= 9) {
            this.contas[this.contasIndex] = new Administrador(nome, cpf, telefone);
            this.contas[this.contasIndex].setIdConta("" + (this.ultimoId + 1));
            this.ultimoId++;
            this.contasIndex++;
        }
    }

    private int buscarIndexConta(String idConta){
        for (int i = 0; i < this.contasIndex; i++){
            if(contas[i].getIdConta().equals(idConta)){
                return i;
            }
        }

        return -1;
    }

    public void removerConta(String idConta){

        int aux = this.buscarIndexConta(idConta);

        if(aux != -1){
            for(int i = 0; i+aux < 10; i++){
                if(i+aux < 9) {
                    contas[i + aux] = this.contas[i + aux + 1];
                } else{
                    contas[i+aux] = null;
                }
            }

            this.contasIndex --;
        }
    }

    public Conta getConta(String idConta){
        int aux = this.buscarIndexConta(idConta);
        return contas[aux];
    }

    public void atualizarConta(String idConta, String nome, String cpf, String telefone){
        int aux = this.buscarIndexConta(idConta);
        contas[aux].setNome(nome);
        contas[aux].setCpf(cpf);
        contas[aux].setTelefone(telefone);
    }

    public String toString(){
        String aux = "";

        for(int i = 0; i < this.contasIndex; i++){
            aux += contas[i].toString();
        }

        return aux;
    }
}
