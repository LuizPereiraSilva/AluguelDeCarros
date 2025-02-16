import Negocio.Fachada;

import Exceptions.Contas.ContaJaExisteException;
import Exceptions.RepositorioCheioException;

import java.time.LocalDate;
import Negocio.Basico.Reserva;
import java.util.Date;

public class Teste{

    public static void main(String[] args){
        Fachada cadastro = Fachada.getInstance();

        print("Listas de Carros e de Contas após serem cadastrados: ");

        try {
            cadastro.cadastrarCliente("João", "001", "900001111");
            cadastro.cadastrarCliente("Matias", "002", "911112222");
            cadastro.cadastrarAdministrador("Pedro", "003", "922223333");
            cadastro.cadastrarAdministrador("Tobias", "004", "933334444");

            cadastro.cadastrarCarro(1, 500, "Argo");
            cadastro.cadastrarCarro(2, 650, "Cronos");
            cadastro.cadastrarCarro(3, 1300, "Hilux");
            cadastro.cadastrarCarro(4, 3000, "SW4");
        } catch(Exception e){
            print(e.getMessage());
        }

        print(cadastro.listarContas());
        print(cadastro.listarCarros());

        print("Listas de contas e carros depois de removermos os que possuem id 2 ou 4: ");

        try {
            cadastro.removerConta(2);
            cadastro.removerConta(4);
            cadastro.removerCarro(2);
            cadastro.removerCarro(4);
        }catch(Exception e){
            print(e.getMessage());
        }

        print(cadastro.listarContas());
        print(cadastro.listarCarros());

        print("Listas de contas e carros depois de atualizados: ");

        try {
            cadastro.atualizarConta("Tadeu", 1, "018", "190");
            cadastro.atualizarPreco(1, 550.5f);
        } catch(Exception e){
            print(e.getMessage());
        }

        print(cadastro.listarContas());
        print(cadastro.listarCarros());

        print("Reservas realizadas usando as contas cliente e o carro criados: \n" +
                "Administradores não podem fazer reservas. ");

        try {
            cadastro.cadastrarReserva(cadastro.buscarCarro(1), cadastro.buscarConta(1),
                    LocalDate.of(2024, 12, 15), LocalDate.of(2024, 12, 18), "Débito");

            cadastro.cadastrarReserva(cadastro.buscarCarro(3), cadastro.buscarConta(3),
                     LocalDate.of(2024, 12, 15),  LocalDate.of(2024, 12, 18), "Débito");
        } catch(Exception e){
            print(e.getMessage());
        }

        print(cadastro.listarReservas());

        print("Realizando segundo cadastro de reserva: ");

        try {
            cadastro.cadastrarReserva(cadastro.buscarCarro(3), cadastro.buscarConta(1),
                    LocalDate.of(2024, 12, 18), LocalDate.of(2024, 12, 21), "Crédito");
        }catch(Exception e){
            print(e.getMessage());
        }

        print(cadastro.listarReservas());

        print("Lista de reservas após a remoção de uma reserva: ");

        cadastro.removerReserva(1);

        print(cadastro.listarReservas());

        print("Lista de reservas após atualização da reserva número 2: ");

        try {
            cadastro.atualizarReserva(2, cadastro.buscarCarro(1), cadastro.buscarConta(1),
                    LocalDate.of(2024, 12, 12), LocalDate.of(2024, 12, 25),
                    "Crédito");
        }catch(Exception e){
            print(e.getMessage());
        }

        print(cadastro.listarReservas());

        try {
            print(cadastro.relatorioReservas(1));

        }catch(Exception e){
            print(e.getMessage());
        }


        try{
            print(cadastro.gerarFaturamentoNoPeriodo(LocalDate.of(2024,12, 12), LocalDate.of(2024, 12, 25)));
        }catch(Exception e){
            print(e.getMessage());
        }

        print("\n -----------------------------------------");
        print("Filtrando as buscas de reservas: \n");

        print("Por cliente: \n");

        try{
            print(cadastro.buscarReservasCliente(1));
        }catch(Exception e){
            print(e.getMessage());
        }

        print("\n -----------------------------------------");
        print("\n Por carro: \n");

        try {
            print(cadastro.buscarReservasCarro(1));
        }catch(Exception e){
            print(e.getMessage());
        }
        print("\n -----------------------------------------");
        print("\n Por periodo: \n");

        try {
            print(cadastro.buscarReservasPeriodo(LocalDate.of(2024,12,12), LocalDate.of(2024,12,25)));
        }catch(Exception e){
            print(e.getMessage());
        }




    }

    public static void print(String line){
        System.out.println(line);
    }
}