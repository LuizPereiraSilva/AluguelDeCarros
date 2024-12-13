package Dados;

import Negocio.Basico.Cliente;
import Negocio.Basico.Reserva;

public class ReservaRepositorio {

    private Reserva[] reservas;
    private int contador;
    private int tamanho;
    private static ReservaRepositorio instance;

    private ReservaRepositorio(int tamanho) {
        this.reservas = new Reserva[tamanho];
        this.contador = 0;
        this.tamanho = tamanho;
    }

    public static ReservaRepositorio getInstance(){
        if(instance == null){
            instance = new ReservaRepositorio(100);
        }
        return instance;
    }


    public void adicionarReserva(Reserva reserva) {
        if(contador < this.tamanho){
            this.reservas[contador] = reserva;
        }
        contador++;
    }

    private int buscarIndex(int numero){
        for(int i = 0; i < this.contador; i++){
            if(this.reservas[i].getNumero() == numero){
                return i;
            }
        }
        return -1;
    }

    public void removerReserva(int idReserva) {
        int aux = this.buscarIndex(idReserva);

        if(aux != -1){
            for(int i = aux; i < contador; i++){
                if(i < contador - 1) {
                    this.reservas[i] = this.reservas[i + 1];
                } else{
                    this.reservas[i] = null;
                }
            }
        }

        contador--;
    }

    public Reserva buscarReserva(int numero) {
        int aux = this.buscarIndex(numero);

        if(aux != -1){
            return this.reservas[aux];
        }
        return null;
    }

    public void atualizarReserva(Reserva reservaAtualizada) {
        int aux = this.buscarIndex(reservaAtualizada.getNumero());
        if(aux != -1) {
            this.reservas[aux] = reservaAtualizada;
        }
    }

    public String toString(){
        String resultado = "\n\nLista de reservas: \n\n";

        for(int i = 0; i < contador; i++){
            resultado += reservas[i].toString()+ "\n";
        }

        return resultado;
    }
}
