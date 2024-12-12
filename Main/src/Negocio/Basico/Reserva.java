package Negocio.Basico;


import java.util.Date;

public class Reserva {
    private Carro carro;
    private Cliente cliente;
    private Date datainicio;
    private Date datafinal;
    private String formapagamento;
    private String pagamento;

    public Reserva(Carro carro, Cliente cliente, Date datainício, Date datafinal, String formapagamento, String pagamento) {
        this.carro = carro;
        this.cliente = cliente;
        this.datainicio = datainicio;
        this.datafinal = datafinal;
        this.formapagamento = formapagamento;
        this.pagamento = pagamento;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

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

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public void cancelarReserva(Reserva reserva){
        
    }

}
