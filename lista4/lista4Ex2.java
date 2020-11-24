import java.util.Random;

public class lista4Ex2 {

    public static void main(String[] args) {

        Random generador = new Random();

        String sustantivos[] = { "profesor", "albañil", "narcotraficante", "perro", "boliviano", "computadora" };
        String verbos[] = { "comío", "murió", "vendió", "cayó", "mató", "rompió" };
        String local[] = { "batuva", "Livramento", "Rivera", "cárcel", "IFSul", "campaña" };

        for (int i = 0; i < 12; i++) {

            String[] palavras = new String[3];
            String frase;
            StringBuilder fraseConstruida = new StringBuilder();

            palavras[0] = sustantivos[generador.nextInt((5 - 0) + 1) + 0];
            palavras[1] = verbos[generador.nextInt((5 - 0) + 1) + 0];
            palavras[2] = local[generador.nextInt((5 - 0) + 1) + 0];

            fraseConstruida.append(palavras[0]).append(" ").append(palavras[1]).append(" en ").append(palavras[2]);
            frase = fraseConstruida.toString();

            frase = frase.substring(0, 1).toUpperCase() + frase.substring(1);

            System.out.print("\nFrase " + (i + 1) + ": " + frase + ".");

        }
    }

}