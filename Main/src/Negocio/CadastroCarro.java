package Negocio;

import Dados.CarroRepositorio;

import Negocio.Basico.Carro;

public class CadastroCarro {

    private int ultimoId;
    private CarroRepositorio repositorio;
    private static CadastroCarro instance;

    private CadastroCarro(){
        this.ultimoId = 0;
        this.repositorio = CarroRepositorio.getInstance();
    }

    public static CadastroCarro getInstance(){
        if (instance == null) {
            instance = new CadastroCarro();
        }

        return instance;
    }

    public void cadastrarCarro(int modelo, float preco, String caracteristicas){
        if(0 < modelo && modelo < 5 && preco > 0){
            Carro carro = new Carro(modelo, this.ultimoId +1, preco, caracteristicas);
            this.repositorio.adicionarCarro(carro);
            ultimoId++;
        }
    }

    public void removerCarro(int id){
        this.repositorio.removerCarro(id);
    }

    public Carro buscarCarro(int id){
        return this.repositorio.buscarCarroPorId(id);
    }

    public void atualizarPreco(int id, float novoPreco){
        if(novoPreco > 0) {
            this.repositorio.atualizarPreco(id, novoPreco);
        }
    }

    public String listarCarros(){
        return this.repositorio.toString();
    }
}
