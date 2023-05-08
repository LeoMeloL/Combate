public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;

    public Jogo(Jogador jogador1, Jogador jogador2) {
        this.tabuleiro = new Tabuleiro();
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.jogadorAtual = jogador1;
    }

    public void moverPeca(int x1, int y1, int x2, int y2) {
        Peca peca = tabuleiro.getCasa(x1, y1);
        if (peca == null) {
            throw new IllegalArgumentException("Não há peça na posição inicial");
        }
        if (!jogadorAtual.getPecas().contains(peca)) {
            throw new IllegalArgumentException("Não é a vez do jogador");
        }
        tabuleiro.moverPeca(x1, y1, x2, y2);
        Peca pecaCapturada = tabuleiro.getCasa(x2, y2);
        if (pecaCapturada != null) {
            if (pecaCapturada.getTipo().equals("Bandeira")) {
                // O jogo acabou
            } else {
                // A peça foi capturada
                if (jogador1.getPecas().contains(pecaCapturada)) {
                    jogador1.getPecas().remove(pecaCapturada);
                } else {
                    jogador2.getPecas().remove(pecaCapturada);
                }
            }
        }
        trocarJogador();
    }

    private void trocarJogador() {
        if (jogadorAtual == jogador1) {
            jogadorAtual = jogador2;
        } else {
            jogadorAtual = jogador1;
        }
    }
}