import Negocio.Basico.Carro;
import Negocio.Fachada;
import Dados.ContasRepositorio;
import Negocio.CadastroConta;
import Negocio.CadastroCarro;
import Negocio.CadastroReserva;
import Negocio.Basico.Cliente;

import java.time.LocalDate;


public class Teste2 {

    public static void main(String[] args) {
//        CadastroConta contas = CadastroConta.getInstance();
//        try {
//            for(int i = 1; i< 8; i++) {
//                contas.removerConta(i);
//            }
//        }catch(Exception e){
//            print(e.getMessage());
//        }
//        print(contas.listarContas());

//        CadastroCarro carros = CadastroCarro.getInstance();
//
//        try{
//            carros.atualizarPreco(5, 150f);
//        }catch(Exception e){
//            print("a");
//            print(e.getMessage());
//        }
//
//        print(carros.listarCarros());

//        CadastroReserva reservas = CadastroReserva.getInstance();
//
//        try{
//
//            reservas.cadastrarReserva(carros.buscarCarro(5), contas.buscarConta(1),
//                    LocalDate.of(2024, 06, 12),
//                    LocalDate.of(2025, 02, 12), "Putaria");
//        } catch(Exception e){
//            print(e.getMessage());
//        }
//
//        print(contas.listarContas());
//
//        print(carros.listarCarros());
//
//        print(reservas.toString());
    }

    public static void print(String string){
        System.out.println(string);
    }
}
