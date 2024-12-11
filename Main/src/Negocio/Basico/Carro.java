package Negocio.Basico;

import java.util.ArrayList;
import java.util.List;

public class Carro {

    private String modelo;
    private String idCarro; // A placa do carro
    private List<String> reservasFuturas; // Lista para armazenar as reservas futuras
    private float preco;
    private String caracteristicas;
    private boolean disponibilidade;

    
    public Carro(String modelo, String idCarro, float preco, String caracteristicas, boolean disponibilidade) {
        this.modelo = modelo;
        this.idCarro = idCarro;
        this.preco = preco;
        this.caracteristicas = caracteristicas;
        this.disponibilidade = disponibilidade;
        this.reservasFuturas = new ArrayList<>(); // Inicializa a lista de reservas
    }

    // Métodos get set
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(String idCarro) {
        this.idCarro = idCarro;
    }

    public List<String> getReservasFuturas() {
        return reservasFuturas;
    }

    public void adicionarReserva(String reserva) {
        this.reservasFuturas.add(reserva);
    }

    public void removerReserva(String reserva) {
        this.reservasFuturas.remove(reserva);
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    // metodo pra ver se esta disponivel
    public boolean verificarDisponibilidade() {
        return disponibilidade && reservasFuturas.isEmpty(); // O carro está disponível se não houver reservas futuras
    }

    // metodo para ver informacao do carro
    public void exibirInfo() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Placa: " + idCarro);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Características: " + caracteristicas);
        System.out.println("Disponibilidade: " + (disponibilidade ? "Disponível" : "Indisponível"));
        System.out.println("Reservas Futuras: " + reservasFuturas);
    }
}
