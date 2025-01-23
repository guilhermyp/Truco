import java.util.ArrayList;

public class Jogo {
    private Baralho baralho;
    private Jogador jogador1;
    private Jogador jogador2;
    private int vitoriasJogador1;
    private int vitoriasJogador2;

    public Jogo() {
        baralho = new Baralho();
        jogador1 = new Jogador(); // Você precisa ajustar o construtor da classe Jogador
        jogador2 = new Jogador(); // Você precisa ajustar o construtor da classe Jogador
    }

    public void iniciar() {
        baralho.embaralhar();
        vitoriasJogador1 = 0;
        vitoriasJogador2 = 0;
        int rodadasJogadas = 0;
        boolean jogoTerminado = false;

        while (!jogoTerminado && vitoriasJogador1 < 12 && vitoriasJogador2 < 12) {
            rodadasJogadas++;
            System.out.println("Rodada " + rodadasJogadas + ":");

            ArrayList<Carta> cartasDistribuidas = baralho.distribuirCartas(2); // Corrija o tipo de retorno do método

            for (int i = 0; i < 3; i++) {
                System.out.println("Carta " + (i + 1) + ":");

                for (int j = 0; j < 2; j++) {
                    Jogador jogadorAtual = (j == 0) ? jogador1 : jogador2;
                    System.out.println("\nMão do jogador " + (j + 1) + ":");
                    jogadorAtual.mostrarMao();

                    ArrayList<Carta> maoJogador = jogadorAtual.getMao();
                    if (maoJogador.isEmpty()) {
                        System.out.println("O jogador " + (j + 1) + " não tem cartas na mão.");
                        break;
                    }

                    Carta cartaJogada = jogadorAtual.escolherCarta(0); // Ajuste para fornecer um argumento
                    jogadorAtual.descartarCarta(cartaJogada);

                    if (j == 0) {
                        System.out.println("O jogador 1 jogou: " + cartaJogada);
                    } else {
                        System.out.println("O jogador 2 jogou: " + cartaJogada);
                    }
                }
            }

            if (vitoriasJogador1 == 12 || vitoriasJogador2 == 12 || (rodadasJogadas == 12 && vitoriasJogador1 != vitoriasJogador2)) {
                jogoTerminado = true;
            }
        }

        if (vitoriasJogador1 >= 12) {
            System.out.println("O jogador 1 venceu o jogo!");
        } else {
            System.out.println("O jogador 2 venceu o jogo!");
        }
    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.iniciar();
    }
}