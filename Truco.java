import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Truco {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Iniciar o jogo
        System.out.println("Bem-vindo ao jogo de Truco!");

        // Definir o número de jogadores
        System.out.print("Escolha o número de jogadores (2 ou 4): ");
        int numeroJogadores = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        // Criar jogadores
        ArrayList<Jogador> jogadores = new ArrayList<>();
        for (int i = 0; i < numeroJogadores; i++) {
            System.out.print("Digite o nome do jogador " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            jogadores.add(new Jogador(nome));
        }

        // Criar baralho e distribuir cartas
        Baralho baralho = new Baralho();
        baralho.embaralhar();
        for (Jogador jogador : jogadores) {
            jogador.receberCartas(baralho.distribuirCartas(3));
        }

        // Mostrar placar inicial
        mostrarPlacar(jogadores);

        // Jogar rodadas
        int rodadaAtual = 1;
        while (true) {
            System.out.println("\n=================== Rodada " + rodadaAtual + " ====================");

            // Jogar partidas da rodada
            for (int i = 0; i < 3; i++) {
                jogarPartida(jogadores, baralho, i + 1);
            }

            // Atualizar placar
            mostrarPlacar(jogadores);

            // Verificar se o jogo terminou
            if (verificarFimDeJogo(jogadores)) {
                break;
            }

            rodadaAtual++;
        }

        // Declarar o vencedor
        declararVencedor(jogadores);
    }

    // Função para jogar uma partida
    private static void jogarPartida(ArrayList<Jogador> jogadores, Baralho baralho, int numeroPartida) {
        // Jogar carta virada
        Carta cartaVirada = baralho.distribuirCarta();
        System.out.println("\nCarta virada: " + cartaVirada);

        // Jogar cartas dos jogadores
        for (Jogador jogador : jogadores) {
            mostrarMaoDoJogador(jogador);
            System.out.print("Escolha a carta que você deseja jogar (1, 2 ou 3): ");
            int indiceCarta = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            Carta cartaJogada = jogador.escolherCarta(indiceCarta - 1); // Índice começa em 0
            System.out.println("O jogador " + jogador.getNome() + " jogou: " + cartaJogada);
        }
    }

    // Função para mostrar a mão de um jogador
    private static void mostrarMaoDoJogador(Jogador jogador) {
        System.out.println("Mão do jogador " + jogador.getNome() + ":");
        jogador.mostrarMao();
    }

    // Função para mostrar o placar
    private static void mostrarPlacar(ArrayList<Jogador> jogadores) {
        System.out.println("\n===== Placar =====");
        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getNome() + ": " + jogador.getPontuacao());
        }
        System.out.println("===================");
    }

    // Função para verificar se o jogo terminou
    private static boolean verificarFimDeJogo(ArrayList<Jogador> jogadores) {
        for (Jogador jogador : jogadores) {
            if (jogador.getPontuacao() >= 12) {
                return true;
            }
        }
        return false;
    }

    // Função para declarar o vencedor
    private static void declararVencedor(ArrayList<Jogador> jogadores) {
        int maxPontuacao = -1;
        Jogador vencedor = null;
        for (Jogador jogador : jogadores) {
            if (jogador.getPontuacao() > maxPontuacao) {
                maxPontuacao = jogador.getPontuacao();
                vencedor = jogador;
            }
        }
        System.out.println("\nO jogador " + vencedor.getNome() + " venceu o jogo!");
    }
}