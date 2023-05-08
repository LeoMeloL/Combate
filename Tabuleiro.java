public class Tabuleiro {
    private int tamanho;
    private Peca[][] casas;

    public Tabuleiro() {
        this.tamanho = 5;
        this.casas = new Peca[tamanho][tamanho];
    }

    public void adicionarPeca(Peca peca, int x, int y) {
        if (x < 0 || x >= tamanho || y < 0 || y >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }
        if (casas[x][y] != null) {
            throw new IllegalArgumentException("Casa já ocupada");
        }
        casas[x][y] = peca;
    }

public void moverPeca(int x1, int y1, int x2, int y2) {
    if (x1 < 0 || x1 >= tamanho || y1 < 0 || y1 >= tamanho) {
        throw new IllegalArgumentException("Posição inicial inválida");
    }
    if (x2 < 0 || x2 >= tamanho || y2 < 0 || y2 >= tamanho) {
        throw new IllegalArgumentException("Posição final inválida");
    }
    if (casas[x1][y1] == null) {
        throw new IllegalArgumentException("Não há peça na posição inicial");
    }
    Peca peca = casas[x1][y1];
    peca.mover(new int[]{x2, y2});
    casas[x2][y2] = peca;
    casas[x1][y1] = null;
}
}