package Negocio.Basico;

public abstract class Conta{

    private String nome;
    private int idConta;
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

    public int getIdConta(){
        return this.idConta;
    }

    public void setIdConta(int id){
        this.idConta = id;
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
            return "Administrador: " + this.getNome() + "\nID: " + this.getIdConta() + "\nCPF: " + this.getCpf() + "\nTelefone: " + this.getTelefone();
        } else {
            return "Cliente: " + this.getNome()+ "\nID: " + this.getIdConta() + "\nCPF: " + this.getCpf() + "\nTelefone: " + this.getTelefone();
        }
    }

     @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if (obj instanceof Conta) {
            Conta param = (Conta) obj;
            // Não considera se ambos os objetos têm valores nulos de atributos
            if (param.getNumero() != null 
                    && param.getNumero().equals(this.getNumero()) 
                    && param.getSaldo() == this.getSaldo()) {
                resultado = true;
            }
        }
        return resultado;        
    }
}
