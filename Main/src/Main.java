import Negocio.CadastroConta;

public class Main{

    public static void main(String[] args){
        CadastroConta cadastro = CadastroConta.getInstance();

        cadastro.cadastrarCliente("João", "001", "900001111");
        cadastro.cadastrarAdministrador("Pedro", "002", "911112222");

        cadastro.listarContas();

        cadastro.removerConta(2);

        cadastro.listarContas();

        cadastro.atualizarConta("Tobias",2, "004", "922223333");

        cadastro.listarContas();

        print("\n\nO DELÍCIA: ");

        System.out.println(cadastro.buscarConta(1));
    }

    public static void print(String line){
        System.out.println(line);
    }
}