public class Bandeira extends Peca {
    public Bandeira(int[] posicao) {
        super("Bandeira", 0, posicao);
    }

    @Override
    public void mover(int[] novaPosicao) {
        // A bandeira não pode se mover
        System.out.println("A bandeira não pode se mover!");
    }

    @Override
    public boolean atacar(Peca outraPeca) {
        // A bandeira não pode atacar
        return false;
    }
}