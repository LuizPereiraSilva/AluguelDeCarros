import Negocio.CadastroConta;
import Negocio.CadastroCarro;
import Negocio.CadastroReserva;

import java.util.Date;

public class Teste{

    public static void main(String[] args){
        CadastroConta contaCadastro = CadastroConta.getInstance();
        CadastroCarro carroCadastro = CadastroCarro.getInstance();
        CadastroReserva reservaCadastro = CadastroReserva.getInstance();

        print("\nListas de Carros e de Contas após serem cadastrados: ");

        contaCadastro.cadastrarCliente("João", "001", "900001111");
        contaCadastro.cadastrarCliente("Matias", "002", "911112222");
        contaCadastro.cadastrarAdministrador("Pedro", "003", "922223333");
        contaCadastro.cadastrarAdministrador("Tobias", "004", "933334444");

        carroCadastro.cadastrarCarro(1, 500, "Argo");
        carroCadastro.cadastrarCarro(2, 650, "Cronos");
        carroCadastro.cadastrarCarro(3, 1300, "Hilux");
        carroCadastro.cadastrarCarro(4, 3000, "SW4");

        print(contaCadastro.listarContas());
        print(carroCadastro.listarCarros());

        print("\nListas de contas e carros depois de removermos os que possuem id 2 ou 4: ");

        contaCadastro.removerConta(2);
        contaCadastro.removerConta(4);

        carroCadastro.removerCarro(2);
        carroCadastro.removerCarro(4);

        print(contaCadastro.listarContas());
        print(carroCadastro.listarCarros());

        print("\nListas de contas e carros depois de atualizados: ");

        contaCadastro.atualizarConta("Tadeu", 1, "018", "190");

        carroCadastro.atualizarPreco(1, 550.5f);

        print(contaCadastro.listarContas());
        print(carroCadastro.listarCarros());

        print("\nReservas realizadas usando as contas cliente e o carro criados: \n" +
                "Administradores não podem fazer reservas. ");

        reservaCadastro.adicionarReserva(carroCadastro.buscarCarro(1), contaCadastro.buscarConta(1),
                new Date(2024, 12, 15), new Date(2024, 12, 18), "Débito");

        reservaCadastro.adicionarReserva(carroCadastro.buscarCarro(3), contaCadastro.buscarConta(1),
                new Date(2024, 12, 15), new Date(2024, 12, 18), "Débito");

        print(reservaCadastro.listarReservas());

        print("\nLista de reservas após a remoção de uma reserva: ");

        reservaCadastro.removerReserva(1);

        print(reservaCadastro.listarReservas());

        print("\nLista de reservas após atualização da reserva número 2: ");

        reservaCadastro.atualizarReserva(2, carroCadastro.buscarCarro(1), contaCadastro.buscarConta(1),
                new Date(2024, 12, 12), new Date(2024, 12, 25), "Crédito");

        print(reservaCadastro.listarReservas());
    }

    public static void print(String line){
        System.out.println(line);
    }
}