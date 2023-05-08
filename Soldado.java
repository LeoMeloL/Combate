public class Soldado extends Peca {
    private boolean podeAtacar;

    public Soldado(int[] posicao) {
        super("Soldado", 2, posicao);
        this.podeAtacar = true;
    }

    @Override
    public void mover(int[] novaPosicao) {
        // Se o Soldado se mover mais de uma casa, ele não pode atacar na mesma vez
        if (Math.abs(novaPosicao[0] - super.getPosicao()[0]) > 1 || Math.abs(novaPosicao[1] - super.getPosicao()[1]) > 1) {
            this.podeAtacar = false;
        } else {
            this.podeAtacar = true;
        }
    }

    @Override
    public boolean atacar(Peca outraPeca) {
        // O Soldado só pode atacar se ele não correu na mesma vez
        if (this.podeAtacar) {
            return super.getForca() > outraPeca.getForca();
        } else {
            return false;
        }
    }
}