import java.util.Random;

public class lista3Ex2 {
    public static void main (String[] args) {

        Random generador = new Random();

        int imagem[][] = new int[40][40];

        for (int i=0; i<40; i++) {
            for (int j=0; j<40; j++) {
                imagem[i][j] = generador.nextInt((255-0)+1)+0;
                System.out.print(imagem[i][j] + " ");
            }
            System.out.print("\n");
        }

    }
}