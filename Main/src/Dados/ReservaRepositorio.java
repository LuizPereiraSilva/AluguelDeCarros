package Dados;

import Exceptions.DataInvalidaException;
import Negocio.Basico.Reserva;
import Interfaces.RepositorioReservasInterface;
import Exceptions.NenhumaReservaException;

import java.time.LocalDate;

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

    public Reserva[] buscarReservasPorCliente(int idCliente) throws NenhumaReservaException {
        Reserva[] auxReservas = new Reserva[this.tamanho];
        int auxContador = 0;

        for (int i = 0; i < this.tamanho; i++) {
            if (this.reservas[i] != null && this.reservas[i].getCliente().getIdConta() == idCliente) {
                auxReservas[auxContador] = this.reservas[i];
                auxContador++;
            }
        }
        if (auxContador == 0) {
            throw new NenhumaReservaException();
        }

        Reserva[] retorno = new Reserva[auxContador];

        for (int i = 0; i < auxContador; i++) {
            retorno[i] = auxReservas[i];
        }

        return retorno;
    }

    public Reserva[] buscarReservasPorCarro(int IdCarro) throws NenhumaReservaException {
        Reserva[] resultado = new Reserva[tamanho];
        int auxj = 0;

        for (int i = 0; i < tamanho; i++) {
            if (this.reservas[i] != null && this.reservas[i].getCarro().getIdCarro() == IdCarro) {
                resultado[auxj] = this.reservas[i];
            }
        }
        if (auxj == 0) {
            throw new NenhumaReservaException();
        }

        Reserva[] resultado2 = new Reserva[auxj + 1];

        for (int i = 0; i < resultado2.length; i++) {
            resultado2[2] = resultado[i];
        }

        return resultado2;
    }

    public Reserva[] buscarReservasPorPeriodo(LocalDate datainicio, LocalDate datafinal) throws NenhumaReservaException {

        int encontradas = 0;

        for (int i = 0; i < this.contador; i++) {
            Reserva reserva = this.reservas[i];
            if (reserva != null) {
                LocalDate reservaDataInicio = reserva.getDatainicio();
                LocalDate reservaDataFinal = reserva.getDatafinal();

                if ((reservaDataInicio.isBefore(datafinal) || reservaDataInicio.isEqual(datafinal)) &&
                        (reservaDataFinal.isAfter(datainicio) || reservaDataFinal.isEqual(datainicio))) {
                    encontradas++;
                }
            }
        }

        if (encontradas == 0) {
            throw new NenhumaReservaException();
        }

        Reserva[] reservasDentroDoPeriodo = new Reserva[encontradas];
        int index = 0;

        for (int i = 0; i < this.contador; i++) {
            Reserva reserva = this.reservas[i];
            if (reserva != null) {
                LocalDate reservaDataInicio = reserva.getDatainicio();
                LocalDate reservaDataFinal = reserva.getDatafinal();

                if ((reservaDataInicio.isBefore(datafinal) || reservaDataInicio.isEqual(datafinal)) &&
                        (reservaDataFinal.isAfter(datainicio) || reservaDataFinal.isEqual(datainicio))) {
                    reservasDentroDoPeriodo[index] = reserva;
                    index++;
                }
            }
        }

        return reservasDentroDoPeriodo;
    }


    public String toString() {
        String resultado = "\n\nLista de reservas: \n\n";

        for (int i = 0; i < contador; i++) {
            resultado += reservas[i].toString() + "\n";
        }

        return resultado;
    }

    public String Relatorio(Reserva[] reservasFiltradas) {
        String relatoriozinho = "";


        for (int i = 0; i < reservasFiltradas.length; i++) {

            relatoriozinho += reservasFiltradas[i].gerarRelatorio() + "\n";
        }

        return relatoriozinho;
    }

    public String gerarRelatorioPorCliente(int idCliente) throws NenhumaReservaException {

        Reserva[] reservasDoCliente = buscarReservasPorCliente(idCliente);

        return Relatorio(reservasDoCliente);
    }

    public float Faturamento(Reserva[] reservasEncontradas) {
        float faturamento = 0;

        for (int i = 0; i < reservasEncontradas.length; i++) {
            faturamento += reservasEncontradas[i].valorTotal();
        }
        return faturamento;
    }

    public float gerarFaturamentoPorPeriodo(LocalDate datainicio, LocalDate datafinal) throws NenhumaReservaException, DataInvalidaException {
        if (datafinal.isAfter(datainicio)) {
            Reserva[] reservasNoPeriodo = buscarReservasPorPeriodo(datainicio, datafinal);


            return Faturamento(reservasNoPeriodo);
        } else {
            throw new DataInvalidaException();

        }
    }

    public String formatarArray(Reserva[] reservas) {

        String resultado = "";
        for (Reserva reserva : reservas) {
            resultado += reserva.toString() + "\n";
        }
        return resultado;
    }

}



