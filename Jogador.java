import java.util.ArrayList;
import java.util.Random;

class Jogador {
    private ArrayList<Carta> mao;
    private String nome;
    private int pontuacao;

    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<Carta>();
        this.pontuacao = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public ArrayList<Carta> getMao() {
        return mao;
    }

    public void receberCartas(ArrayList<Carta> cartas) {
        this.mao.addAll(cartas);
    }

    public Carta escolherCarta(int indiceCarta) {
        if (indiceCarta >= 0 && indiceCarta < mao.size()) {
            return mao.remove(indiceCarta);
        } else {
            return null; // Retorna null se o índice for inválido
        }
    }

    public void mostrarMao() {
        for (int i = 0; i < mao.size(); i++) {
            System.out.println((i + 1) + ": " + mao.get(i));
        }
    }
}
