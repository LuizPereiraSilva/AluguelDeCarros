package Dados;
import Negocio.Basico.Conta;
import Interfaces.RepositoriosInterface;

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

    public void adicionarConta(Conta conta){
        if(contasIndex < this.tamanho) {
            this.contas[this.contasIndex] = conta;
            this.contasIndex++;
        }
    }

    private int buscarIndexConta(int id){
        for (int i = 0; i < this.contasIndex; i++){
            if(contas[i].getIdConta() == id){
                return i;
            }
        }

        return -1;
    }

    public void remover(int idConta){

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

    public Conta buscarConta(int idConta){
        int aux = this.buscarIndexConta(idConta);
        if(aux != -1) {
            return contas[aux];
        }
        return null;
    }

    public void atualizarConta(Conta conta){
        int aux = this.buscarIndexConta(conta.getIdConta());
        if(aux != -1) {
            contas[aux] = conta;
        }
    }

    public String toString(){
        String aux = "\n\nLista:\n\n";

        for(int i = 0; i < this.contasIndex; i++){
            aux += contas[i].toString() + "\n\n";
        }

        return aux;
    }
}
