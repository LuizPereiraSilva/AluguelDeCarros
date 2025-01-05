package Negocio;

import Negocio.Basico.Administrador;

import Exceptions.LoginJaExisteException;
import Exceptions.Contas.ContaNaoExisteException;

public class NavegarAdministrador {

    private Administrador login;
    private CadastroReserva reservas;
    private CadastroCarro carros;
    private static NavegarAdministrador instance;

    private NavegarAdministrador(Administrador login) throws ContaNaoExisteException{
        CadastroConta contas = CadastroConta.getInstance();
        contas.buscarConta(login.getIdConta());

        this.login = login;
        this.reservas = CadastroReserva.getInstance();
        this.carros = CadastroCarro.getInstance();
    }

    public static NavegarAdministrador getInstance(Administrador login) throws
            LoginJaExisteException, ContaNaoExisteException{
        if(!NavegarCliente.existeInstancia()) {
            if (instance == null) {
                instance = new NavegarAdministrador(login);
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

    public static void apagarInstancia(){
        instance = null;
    }

    public void adicionarCarro(int modelo, float preco, String caracteristicas){
        carros.cadastrarCarro(modelo, preco, caracteristicas);
    }

    public void removerCarro(int id){
        carros.removerCarro(id);
    }

    public void editarPrecoCarro(int modelo, float preco){
        carros.atualizarPreco(modelo, preco);
    }

    public void trocarDisponibilidade(int id, boolean disponibilidade){
        carros.buscarCarro(id).setDisponivel(disponibilidade);
    }


}
