public class CaboArmeiro extends Peca {
    public CaboArmeiro(int[] posicao) {
        super("Cabo Armeiro", 3, posicao);
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
        // Verifica se a outra peça é uma bomba
        if (outraPeca.getNome().equals("Bomba")) {
            // Desarma a bomba
            return true;
        } else if (outraPeca.getForca() <= this.getForca()) {
            // Ataca a outra peça
            return true;
        } else {
            // Perde o ataque
            return false;
        }
    }
}