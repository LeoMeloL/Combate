public class Bomba extends Peca {
    public Bomba(int[] posicao) {
        super("Bomba", 0, posicao);
    }

    @Override
    public void mover(int[] novaPosicao) {
        // A bomba não pode se mover
        System.out.println("A bomba não pode se mover!");
    }

    @Override
    public boolean atacar(Peca outraPeca) {
        // A bomba não pode atacar
        return false;
    }
}