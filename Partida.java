import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao jogo de Truco!");
        System.out.println("Escolha o número de jogadores (2 ou 4): ");
        int numeroJogadores = scanner.nextInt();

        if (numeroJogadores != 2 && numeroJogadores != 4) {
            System.out.println("Número de jogadores inválido. Por favor, escolha 2 ou 4.");
            return;
        }

        Baralho baralho = new Baralho();

        ArrayList<Jogador> jogadores = new ArrayList<>();
        for (int i = 0; i < numeroJogadores; i++) {
            System.out.print("Digite o nome do jogador " + (i + 1) + ": ");
            String nome = scanner.next();
            Jogador jogador = new Jogador(nome); // Aqui fornecemos o nome do jogador ao construtor
            jogadores.add(jogador);
        }

        baralho.embaralhar();

        int vitoriasJogador1 = 0;
        int vitoriasJogador2 = 0;
        int rodadasJogadas = 0;
        boolean jogoTerminado = false;

        while (!jogoTerminado) {
            rodadasJogadas++;
            System.out.println("Rodada " + rodadasJogadas + ":");

            ArrayList<Carta> cartasDistribuidas = baralho.distribuirCartas(numeroJogadores);
            for (int i = 0; i < 3; i++) { // 3 cartas por rodada
                System.out.println("Carta " + (i+1) + ":");

                for (int j = 0; j < numeroJogadores; j++) {
                    System.out.println("\nMão do jogador " + (j + 1) + ":");
                    jogadores.get(j).mostrarMao();

                    ArrayList<Carta> maoJogador = jogadores.get(j).getMao();
                    if (maoJogador.isEmpty()) {
                        System.out.println("O jogador " + (j + 1) + " não tem cartas na mão.");
                        break; // Sai do loop e passa para a próxima rodada
                    }

                    int numeroCartaEscolhida = 1; // Supondo que o jogador escolha a primeira carta
                    Carta cartaJogada = jogadores.get(j).escolherCarta(numeroCartaEscolhida - 1); // Ajuste para o índice do ArrayList // Método para escolher a carta a ser jogada
                

                    if (j == 0) {
                        System.out.println("O jogador 1 jogou: " + cartaJogada);
                    } else {
                        System.out.println("O jogador 2 jogou: " + cartaJogada);
                    }
                }
            }
                
            public void jogarRodada() {
                for (Jogador jogador : jogadores) {
                    Carta cartaJogada = jogador.jogarCarta();
                    if (cartaJogada != null) {
                        // Faça algo com a carta jogada, como adicioná-la a uma lista de cartas na mesa
                    }
                } // Retorna null se o jogador não tiver cartas na mão
                }

            // Comparação de cartas após todas as cartas serem jogadas na rodada
            for (int i = 0; i < 3; i++) {
                if (jogadores.get(0).getMao().isEmpty() || jogadores.get(1).getMao().isEmpty()) {
                    break; // Se algum jogador ficou sem cartas, não há necessidade de comparar mais
                }

                int resultadoComparacao = jogadores.get(0).getMao().get(i).compareTo(jogadores.get(1).getMao().get(i));

                if (resultadoComparacao > 0) {
                    System.out.println("O jogador 1 venceu a rodada!");
                    vitoriasJogador1++;
                } else if (resultadoComparacao < 0) {
                    System.out.println("O jogador 2 venceu a rodada!");
                    vitoriasJogador2++;
                } else {
                    System.out.println("Empate! A próxima rodada decidirá o vencedor.");
                }
            }

            // Verifica se o jogo terminou
            if (vitoriasJogador1 == 2 || vitoriasJogador2 == 2 || (rodadasJogadas == 2 && vitoriasJogador1 != vitoriasJogador2)) {
                jogoTerminado = true;
            }
        }

        // Determina o vencedor
        if (vitoriasJogador1 > vitoriasJogador2) {
            System.out.println("O jogador 1 venceu!");
        } else if (vitoriasJogador1 < vitoriasJogador2) {
            System.out.println("O jogador 2 venceu!");
        } else {
            System.out.println("Empate!");
        }
    }
}