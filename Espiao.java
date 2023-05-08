public class Espiao extends Peca {
    public Espiao(int[] posicao) {
        super("Espiao", 1, posicao);
    }

    @Override
    public void mover(int[] novaPosicao) {
        // Verifica se o movimento é válido (uma casa para frente ou para os lados)
        if (Math.abs(novaPosicao[0] - this.getPosicao()[0]) + Math.abs(novaPosicao[1] - this.getPosicao()[1]) == 1) {
            // Atualiza a posição da peça
            this.setPosicao(novaPosicao);
        } else {
            // Movimento inválido
            System.out.println("Movimento inválido!");
        }
    }

    @Override
    public boolean atacar(Peca outraPeca) {
        // O Espião é a única peça que pode matar o Marechal
        if (outraPeca.getNome().equals("Marechal")) {
            return true;
        } else {
            return super.getForca() > outraPeca.getForca();
        }
    }
}