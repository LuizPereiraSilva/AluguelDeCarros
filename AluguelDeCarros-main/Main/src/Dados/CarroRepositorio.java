package Dados;

import Negocio.Basico.Carro;

public class CarroRepositorio {

    private Carro[] carros; // lista dos carros
    private int contador;
    private int tamanho;
    private static CarroRepositorio instance;

    // inicializa a lista dos carros
    private CarroRepositorio(int tamanho) {
        this.carros = new Carro[tamanho];
        this.contador = 0;
        this.tamanho = tamanho;
    }

    public static CarroRepositorio getInstance(){
        if(instance == null){
            instance = new CarroRepositorio(100);
        }

        return instance;
    }

    // adicionar carro
    public void adicionarCarro(Carro carro) {
        if(this.contador < tamanho){
            carros[contador] = carro;
            contador++;
        }
    }

    // remover carro pelo id
    public void removerCarro(int idCarro) {
        int aux = this.buscarIndexCarro(idCarro);
        if(aux != -1){
            for(int i = aux; i < contador; i++){
                if(i < contador-1) {
                    this.carros[i] = this.carros[i+1];
                } else{
                    this.carros[i] = null;
                }
            }
            this.contador--;
        }
    }

    // buscar carro pelo id (placa)
    public Carro buscarCarroPorId(int idCarro) {
        int aux = buscarIndexCarro(idCarro);

        if(aux != -1){
            return carros[aux];
        }

        return null;
    }

    private int buscarIndexCarro(int idCarro){
        for(int i = 0; i < this.tamanho; i++){
            if(carros[i].getIdCarro() == idCarro){
                return i;
            }
        }
        return -1;
    }

    // buscar carro por modelo
    public Carro[] buscarCarrosPorModelo(int modelo) {
        Carro[] carrosEncontrados = new Carro[this.tamanho];
        for (int i = 0; i < this.contador; i++) {
            for(int j = 0; ; ) {
                if (carros[i].getIdModelo() == modelo) {
                    carrosEncontrados[j] = carros[i];
                    j++;
                }
            }
        }
        return carrosEncontrados;
    }

    // atualizar o preço
    public void atualizarPreco(int idCarro, float novoPreco) {
        Carro carro = buscarCarroPorId(idCarro);
        if (carro != null) {
            carro.setPreco(novoPreco);
        }
    }

    public String toString(){
        String resultado = "\n\nLista de carros: \n";

        for(int i = 0; i < this.contador; i++){
            resultado += carros[i].toString() + "\n";
        }

        return resultado;
    }
}
