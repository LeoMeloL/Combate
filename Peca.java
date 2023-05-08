public abstract class Peca {
    private String nome;
    private int forca;
    private int[] posicao;

    public Peca(String nome, int forca, int[] posicao) {
        this.nome = nome;
        this.forca = forca;
        this.posicao = posicao;
    }

    public String getNome() {
        return nome;
    }

    public int getForca() {
        return forca;
    }

    public int[] getPosicao() {
        return posicao;
    }

    public void setPosicao(int[] posicao) {
        this.posicao = posicao;
    }

    public abstract void mover(int[] novaPosicao);

    public abstract boolean atacar(Peca outraPeca);
}