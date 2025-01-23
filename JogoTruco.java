import java.util.ArrayList;

public class JogoTruco {
    private Baralho baralho;
    private Jogador jogador1;
    private Jogador jogador2;
    private int vitoriasJogador1;
    private int vitoriasJogador2;

    public JogoTruco() {
        baralho = new Baralho();
        jogador1 = new Jogador("Jogador 1");
        jogador2 = new Jogador("Jogador 2");
    }

    public void iniciar() {
        baralho.embaralhar();
        vitoriasJogador1 = 0;
        vitoriasJogador2 = 0;

        // Implemente a lógica do jogo
    }

    public static void main(String[] args) {
        JogoTruco jogo = new JogoTruco();
        jogo.iniciar();
    }
}