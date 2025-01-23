import java.util.ArrayList;

class Baralho {
    private ArrayList<Carta> cartas;
    private static final String[] nomeCartas = {"AS", "2", "3", "4", "5", "6", "7", "Q", "J", "K"};
    private static final String[] naipes = {"OURO", "ESPADAS", "COPAS", "PAUS"};
    private static final Map<String, Integer> forcaCartas = new HashMap<String, Integer>() {{
        put("4", 1);
        put("5", 2);
        put("6", 3);
        put("7", 4);
        put("Q", 5);
        put("J", 6);
        put("K", 7);
        put("AS", 8);
        put("2", 9);
        put("3", 10);
    }};

    public Baralho() {
        cartas = new ArrayList<>();
        for (String naipe : naipes) {
            for (String nome : nomeCartas) {
                cartas.add(new Carta(nome, naipe, forcaCartas));
            }
        }
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public Carta distribuirCarta() {
        if (!cartas.isEmpty()) {
            return cartas.remove(0);
        } else {
            return null; // Retorna null se não houver cartas no baralho
        }
    }

    public ArrayList<Carta> distribuirCartas(int numeroCartas) {
        ArrayList<Carta> cartasDistribuidas = new ArrayList<>();
        for (int i = 0; i < numeroCartas; i++) {
            Carta carta = distribuirCarta();
            if (carta != null) {
                cartasDistribuidas.add(carta);
            }
        }
        return cartasDistribuidas;
    }
}