import java.util.ArrayList;
import java.util.List;

public class CarroRepositorio {

    private List<Carro> carros; // lista dos carros

    // inicializa a lista dos carros
    public CarroRepositorio() {
        this.carros = new ArrayList<>();
    }

    // adicionar carro
    public void adicionarCarro(Carro carro) {
        carros.add(carro);
    }

    // remover carro pelo id (placa)
    public boolean removerCarroPorId(String idCarro) {
        for (Carro carro : carros) {
            if (carro.getIdCarro().equals(idCarro)) {
                carros.remove(carro);
                return true;
            }
        }
        return false;
    }

    // buscar carro pelo id (placa)
    public Carro buscarCarroPorId(String idCarro) {
        for (Carro carro : carros) {
            if (carro.getIdCarro().equals(idCarro)) {
                return carro;
            }
        }
        return null; 
    }

    // buscar carro por modelo
    public List<Carro> buscarCarrosPorModelo(String modelo) {
        List<Carro> carrosEncontrados = new ArrayList<>();
        for (Carro carro : carros) {
            if (carro.getModelo().equalsIgnoreCase(modelo)) {
                carrosEncontrados.add(carro);
            }
        }
        return carrosEncontrados;
    }

    // listar todos os carros
    public void listarTodosCarros() {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro disponível!");
        } else {
            for (Carro carro : carros) {
                carro.exibirInfo(); // Chama o método exibirInfo() da classe Carro
            }
        }
    }

    // atualizar o preço
    public boolean atualizarPreco(String idCarro, float novoPreco) {
        Carro carro = buscarCarroPorId(idCarro);
        if (carro != null) {
            carro.setPreco(novoPreco);
            return true;
        }
        return false;
    }

    // checar se esta disponivel
    public boolean verificarDisponibilidade(String idCarro) {
        Carro carro = buscarCarroPorId(idCarro);
        return carro != null && carro.isDisponibilidade();
    }
}
