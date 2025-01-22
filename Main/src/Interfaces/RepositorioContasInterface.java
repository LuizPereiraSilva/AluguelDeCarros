package Interfaces;

import Exceptions.Contas.ContaJaExisteException;
import Exceptions.Contas.ContaNaoExisteException;
import Exceptions.RepositorioCheioException;
import Negocio.Basico.Conta;

public interface RepositorioContasInterface {

    public void adicionarConta(Conta conta) throws RepositorioCheioException, ContaJaExisteException;

    public void removerConta(int idConta) throws ContaNaoExisteException;

    public Conta buscarConta(int idConta) throws ContaNaoExisteException;

    public void atualizarConta(Conta conta) throws ContaNaoExisteException;
}
