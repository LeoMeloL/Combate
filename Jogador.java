import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private List<Peca> pecas;

    public Jogador(String nome) {
        this.nome = nome;
        this.pecas = new ArrayList<>();
    }

    public void adicionarPeca(Peca peca) {
        this.pecas.add(peca);
    }

    public String getNome() {
        return nome;
    }

    public List<Peca> getPecas() {
        return pecas;
    }
}