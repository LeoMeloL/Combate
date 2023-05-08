public class Marechal extends Peca {
    public Marechal(int[] posicao) {
        super("Marechal", 10, posicao);
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
        if (outraPeca.getNome().equals("Espiao")) {
            // Perde o ataque
            return false;
        } else {
            // Ataca a outra peça
            return true;
        }
    }
}