package Negocio.Basico;


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

}
