import java.util.Random;

public class lista3Ex3 {
    public static void main (String[] args) {

        Random generador = new Random();

        int par[] = new int[10];
        int impar[] = new int[10];
        int indexpar = 0;
        int indeximpar = 0;

        for (int i=0; i<10; i++) {
            int n = generador.nextInt((20-1)+1)+1;
            if ((n % 2) == 0) {
                par[indexpar] = n;
                indexpar++;
            } else {
                impar[indeximpar] = n;
                indeximpar++;
            }
            
        }

        System.out.print("Array par: ");
        for (int i=0; i<indexpar; i++) {
            System.out.print(par[i] + " ");
        }

        System.out.print("\nArray impar: ");
        for (int i=0; i<indeximpar; i++) {
            System.out.print(impar[i] + " ");
        }

    }
}