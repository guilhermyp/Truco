import java.util.Map;
import java.util.ArrayList;

class Carta implements Comparable<Carta> {
    private String nome;
    private String naipe;
    private int forca;

    public Carta(String nome, String naipe, Map<String, Integer> forcaCartas) {
        this.nome = nome;
        this.naipe = naipe;
        this.forca = forcaCartas.get(nome);
    }

    public String getNome() {
        return nome;
    }

    public String getNaipe() {
        return naipe;
    }

    public int getForca() {
        return forca;
    }

    @Override
    public String toString() {
        return nome + " de " + naipe;
    }

    @Override
    public int compareTo(Carta outraCarta) {
        // Lógica de comparação de cartas
        // Implemente a comparação de acordo com as regras do truco
        // Retorne 0 se as cartas forem iguais, um número positivo se this for maior,
        // e um número negativo se this for menor
        int comparacaoNaipes = this.naipe.compareTo(outraCarta.naipe);
    
        if (comparacaoNaipes != 0) {
            // Se os naipes forem diferentes, a carta de ouro vence
            if (this.naipe.equals("OURO")) {
                return 1;
            } else if (outraCarta.naipe.equals("OURO")) {
                return -1;
            }
    
            // Se os naipes não forem ouro, a ordem é Espadas, Copas e Paus
            return comparacaoNaipes;
        }
    
        // Se os naipes forem iguais, comparar os valores
        int comparacaoValores = this.nome.compareTo(outraCarta.nome);
    
        if (comparacaoValores != 0) {
            return comparacaoValores;
        }
    
        // Se os nomes forem iguais, verificar se são manilhas
        boolean thisManilha = this.naipe.equals(viraNaipe);
        boolean outraManilha = outraCarta.naipe.equals(viraNaipe);
    
        if (thisManilha && !outraManilha) {
            return 1;
        } else if (!thisManilha && outraManilha) {
            return -1;
        }
    
        // Se ambas forem manilhas do mesmo naipe, comparar a ordem das manilhas
        if (thisManilha && outraManilha) {
            int ordemManilhaThis = ordemManilhas.indexOf(this.nome);
            int ordemManilhaOutra = ordemManilhas.indexOf(outraCarta.nome);
    
            return ordemManilhaThis - ordemManilhaOutra;
        }
    
        return 0;
    }
}