import java.util.ArrayList;

public class Rodada {
    private Baralho baralho;
    private Jogador jogador1;
    private Jogador jogador2;

    public Rodada(Baralho baralho, Jogador jogador1, Jogador jogador2) {
        this.baralho = baralho;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    public ResultadoRodada jogar() {
         // Obtém as cartas jogadas por cada jogador
    Carta cartaJogador1 = jogador1.escolherCarta();
    Carta cartaJogador2 = jogador2.escolherCarta();

    // Exibe as cartas jogadas por cada jogador
    System.out.println("Jogador 1 jogou: " + cartaJogador1);
    System.out.println("Jogador 2 jogou: " + cartaJogador2);

    // Compara as cartas jogadas
    int resultadoComparacao = cartaJogador1.compareTo(cartaJogador2);

    // Determina o resultado da rodada com base na comparação das cartas
    if (resultadoComparacao > 0) {
        return ResultadoRodada.VITORIA_JOGADOR1;
    } else if (resultadoComparacao < 0) {
        return ResultadoRodada.VITORIA_JOGADOR2;
    } else {
        return ResultadoRodada.EMPATE;
    }
    }

    public ResultadoRodada jogar() {
        // ...
    
        // Comparar as cartas
        int resultadoComparacao = cartaJogador1.compareTo(cartaJogador2);
    
        // Determinar o vencedor da rodada
        if (resultadoComparacao > 0) {
            System.out.println("O jogador " + (jogador1Index + 1) + " venceu a rodada!");
            vitoriasJogador1++;
        } else if (resultadoComparacao < 0) {
            System.out.println("O jogador " + (jogador2Index + 1) + " venceu a rodada!");
            vitoriasJogador2++;
        } else {
            System.out.println("Empate! A próxima rodada decidirá o vencedor.");
        }
    
        // ...
    
        return resultadoComparacao > 0 ? ResultadoRodada.VITORIA_JOGADOR1 : (resultadoComparacao < 0 ? ResultadoRodada.VITORIA_JOGADOR2 : ResultadoRodada.EMPATE);
    }



}