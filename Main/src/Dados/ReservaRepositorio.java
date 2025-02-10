package Dados;

import Negocio.Basico.Cliente;
import Negocio.Basico.Reserva;
import Negocio.Basico.Conta;
import Negocio.Basico.Administrador;
import Interfaces.RepositorioReservasInterface;

public class ReservaRepositorio implements RepositorioReservasInterface {

    private Reserva[] reservas;
    private int contador;
    private int tamanho;
    private static ReservaRepositorio instance;

    private ReservaRepositorio(int tamanho) {
        this.reservas = new Reserva[tamanho];
        this.contador = 0;
        this.tamanho = tamanho;
    }

    public static ReservaRepositorio getInstance() {
        if (instance == null) {
            instance = new ReservaRepositorio(100);
        }
        return instance;
    }


    public void adicionarReserva(Reserva reserva) {
        if (contador < this.tamanho) {
            this.reservas[contador] = reserva;
        }
        contador++;
    }

    private int buscarIndex(int numero) {
        for (int i = 0; i < this.contador; i++) {
            if (this.reservas[i].getNumero() == numero) {
                return i;
            }
        }
        return -1;
    }

    public void removerReserva(int idReserva) {
        int aux = this.buscarIndex(idReserva);

        if (aux != -1) {
            for (int i = aux; i < contador; i++) {
                if (i < contador - 1) {
                    this.reservas[i] = this.reservas[i + 1];
                } else {
                    this.reservas[i] = null;
                }
            }
        }

        contador--;
    }

    public Reserva buscarReserva(int numero) {
        int aux = this.buscarIndex(numero);

        if (aux != -1) {
            return this.reservas[aux];
        }
        return null;
    }

    public void atualizarReserva(Reserva reservaAtualizada) {
        int aux = this.buscarIndex(reservaAtualizada.getNumero());
        if (aux != -1) {
            this.reservas[aux] = reservaAtualizada;
        }
    }

    public Reserva[] buscarReservasPorCliente(int idCliente) {
        Reserva[] auxReservas = new Reserva[this.tamanho];
        int auxContador = 0;

        for (int i = 0; i < this.tamanho; i++) {
            if (this.reservas[i].getCliente().getIdConta() == idCliente) {
                auxReservas[auxContador] = this.reservas[i];
                auxContador++;
            }
        }

        Reserva[] retorno = new Reserva[auxContador];

        for (int i = 0; i < auxContador; i++) {
            retorno[i] = auxReservas[i];
        }

        return retorno;
    }

    public Reserva[] buscarReservasPorCarro(int IdCarro) {
        Reserva[] resultado = new Reserva[tamanho];
        int auxj = 0;

        for (int i = 0; i < tamanho; i++) {
            if (this.reservas[i].getCarro().getIdCarro() == IdCarro) {
                resultado[auxj] = this.reservas[i];
            }
        }

        Reserva[] resultado2 = new Reserva[auxj + 1];

        for (int i = 0; i < resultado2.length; i++) {
            resultado2[2] = resultado[i];
        }

        return resultado2;
    }

    public String toString() {
        String resultado = "\n\nLista de reservas: \n\n";

        for (int i = 0; i < contador; i++) {
            resultado += reservas[i].toString() + "\n";
        }

        return resultado;
    }

    public String Relatorio() {

        String relatoriozinho = "";
        for (int i = 0; i < contador; i++) {
            relatoriozinho = this.reservas[i].gerarRelatorio();
        }
        return relatoriozinho;
    }
}

