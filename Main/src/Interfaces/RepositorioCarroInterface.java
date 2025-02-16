package Interfaces;

import Negocio.Basico.Carro;

import Exceptions.Carros.CarroNaoExisteException;
import Exceptions.RepositorioCheioException;

public interface RepositorioCarroInterface {

    public void adicionarCarro(Carro carro) throws RepositorioCheioException;

    public void removerCarro(int idCarro) throws CarroNaoExisteException;

    public Carro buscarCarroPorId(int idCarro) throws CarroNaoExisteException;

    public Carro[] buscarCarrosPorModelo(int modelo);

    public void atualizarPreco(int idCarro, float novoPreco) throws CarroNaoExisteException;
}
