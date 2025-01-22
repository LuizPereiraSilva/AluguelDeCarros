package Interfaces;

import Negocio.Basico.Carro;

public interface RepositorioCarroInterface {

    public void adicionarCarro(Carro carro);

    public void removerCarro(int idCarro);

    public Carro buscarCarroPorId(int idCarro);

    public Carro[] buscarCarrosPorModelo(int modelo);

    public void atualizarPreco(int idCarro, float novoPreco);
}
