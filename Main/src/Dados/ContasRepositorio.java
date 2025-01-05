package Dados;
import Negocio.Basico.Conta;
import Interfaces.RepositoriosInterface;
import Exceptions.RepositorioCheioException;
import Exceptions.Contas.ContaNaoExisteException;
import Exceptions.Contas.ContaJaExisteException;

public class ContasRepositorio implements RepositoriosInterface{

    private Conta[] contas;
    private int contasIndex;
    private int tamanho;
    private static ContasRepositorio repositorio;

    private ContasRepositorio(int tamanho){
        this.contas = new Conta[tamanho];
        this.tamanho = tamanho;
        this.contasIndex = 0;
    }

    public static ContasRepositorio getInstance(){
        if(repositorio == null){
            repositorio = new ContasRepositorio(100);
        }
        return repositorio;
    }

    public void adicionarConta(Conta conta) throws RepositorioCheioException, ContaJaExisteException{
        this.buscarCpfConta(conta.getCpf());

        if(contasIndex < this.tamanho) {
            this.contas[this.contasIndex] = conta;
            this.contasIndex++;
        } else{
            throw new RepositorioCheioException();
        }
    }

    private void buscarCpfConta(String cpf) throws ContaJaExisteException{
        for(int i = 0; i < this.contasIndex; i++){
            if(this.contas[i].getCpf().equals(cpf)){
                throw new ContaJaExisteException();
            }
        }
    }

    private int buscarIndexConta(int id) throws ContaNaoExisteException{
        for (int i = 0; i < this.contasIndex; i++){
            if(contas[i].getIdConta() == id){
                return i;
            }
        }

        throw new ContaNaoExisteException();
    }

    public void removerConta(int idConta) throws ContaNaoExisteException{

        int aux = this.buscarIndexConta(idConta);


        for (int i = 0; i + aux < 10; i++) {
            if (i + aux < 9) {
                contas[i + aux] = this.contas[i + aux + 1];
            } else {
                contas[i + aux] = null;
            }
        }

        this.contasIndex--;

    }

    public Conta buscarConta(int idConta) throws ContaNaoExisteException{
        int aux = this.buscarIndexConta(idConta);

        return contas[aux];
    }

    public void atualizarConta(Conta conta) throws ContaNaoExisteException{
        int aux = this.buscarIndexConta(conta.getIdConta());

        contas[aux] = conta;
    }

    public String toString(){
        String aux = "\n\nLista de Contas:\n\n";

        for(int i = 0; i < this.contasIndex; i++){
            aux += contas[i].toString() + "\n\n";
        }

        return aux;
    }
}
