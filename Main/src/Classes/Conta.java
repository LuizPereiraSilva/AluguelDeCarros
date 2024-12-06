package Classes;

public abstract class Conta{

    private String nome;
    private String idConta;
    private String cpf;
    private String telefone;
    private boolean administrador;

    public Conta(String nome, String cpf, String telefone, boolean administrador){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.administrador = administrador;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getIdConta(){
        return this.idConta;
    }

    public void setIdConta(String idConta){
        this.idConta = idConta;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setCpf(String CPF){
        this.cpf = CPF;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public boolean getAdministrador(){return administrador;}

    public String toString(){
        if(this.administrador) {
            return "Administrador: " + this.getNome() + "\nCPF: " + this.getCpf() + "\nTelefone: " + this.getTelefone();
        } else {
            return "Cliente: " + this.getNome() + "\nCPF: " + this.getCpf() + "\nTelefone: " + this.getTelefone();
        }
    }
}
