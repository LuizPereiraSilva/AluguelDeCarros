package Negocio.Basico;


import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Reserva {
    private Carro carro;
    private int numero;
    private Cliente cliente;
    private Date datainicio;
    private Date datafinal;
    private String formapagamento;
    private boolean pagamento;

    public Reserva(Carro carro, Conta cliente, Date datainicio, Date datafinal, String formapagamento) {
        this.carro = carro;
        this.cliente = ((Cliente)cliente);
        this.datainicio = datainicio;
        this.datafinal = datafinal;
        this.formapagamento = formapagamento;
        this.pagamento = false;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public int getNumero(){return this.numero;}

    public void setNumero(int numero){this.numero = numero;};

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro){
        this.carro = carro;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafinal() {
        return datafinal;
    }

    public void setDatafinal(Date datafinal) {
        this.datafinal = datafinal;
    }

    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }

    public boolean getPagamento() {
        return pagamento;
    }

    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }

    public String toString(){
        String resultado = "\nReserva " + this.numero + ": \n\n";
        resultado += this.cliente.toString();
        resultado += this.carro.toString();
        resultado += " \n\nData de inicio: "+ this.datainicio;
        resultado += " \nData final: " + this.datafinal;
        resultado += " \nForma de pagamento: " + this.formapagamento;
        resultado += " \nStatus do pagamento: " + this.pagamento;

        return resultado;
    }

    public int daysDate() {

     int diff = this.datafinal.getDate() - this.datainicio.getDate();

     return diff;

    }

    public String gerarRelatorio() {
        StringBuilder relatorio = new StringBuilder("Relatório da reserva: ");
        relatorio.append("\n\n").append("Número da reserva: ").append(numero).append("\n");
        relatorio.append("Cliente: ").append(cliente.getNome()).append(" (CPF: ").append(cliente.getCpf()).append(")\n");
        relatorio.append("Carro: ").append(carro.getModelo()).append(" (Placa: ").append(carro.getIdCarro()).append(")\n");
        relatorio.append("Período de aluguel: ").append(datainicio).append(" a ").append(datafinal).append("\n");
        relatorio.append("Valor por dia: ").append(carro.getPreco()).append("\n");
        relatorio.append("Valor total: ").append(carro.getPreco() * daysDate()).append("\n");



        return relatorio.toString();
    }

}
