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
    Peca pecaCapturada = tabuleiro.getCasa(x2, y2);
    if (pecaCapturada != null) {
        if (peca.getForca() > pecaCapturada.getForca()) {
            // A peça atacante venceu
            tabuleiro.moverPeca(x1, y1, x2, y2);
            if (jogador1.getPecas().contains(pecaCapturada)) {
                jogador1.getPecas().remove(pecaCapturada);
            } else {
                jogador2.getPecas().remove(pecaCapturada);
            }
        } else if (peca.getForca() == pecaCapturada.getForca()) {
            // Ambas as peças morrem
            tabuleiro.removerPeca(x1, y1);
            tabuleiro.removerPeca(x2, y2);
            jogador1.getPecas().remove(peca);
            jogador2.getPecas().remove(peca);
            jogador1.getPecas().remove(pecaCapturada);
            jogador2.getPecas().remove(pecaCapturada);
        } else {
            // A peça atacante perdeu
            tabuleiro.removerPeca(x1, y1);
            if (jogador1.getPecas().contains(peca)) {
                jogador1.getPecas().remove(peca);
            } else {
                jogador2.getPecas().remove(peca);
            }
        }
    } else {
        // Não há peça na posição final
        tabuleiro.moverPeca(x1, y1, x2, y2);
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
