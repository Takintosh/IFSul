import java.util.Arrays;
import java.util.Scanner;

public class lista3Ex1 {
    public static void main (String[] args) {

        int[] nota = new int[5];
        int aux = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese as 5 notas separadas por um ENTER:\n");
        for (int i=0; i<nota.length; i++) {
            nota[i] = input.nextInt();
            aux = aux + nota[i];
        }

        System.out.print("\nDe maior a menor, as notas sao: ");
        Arrays.sort(nota);
        for (int j=nota.length-1; j >= 0; j--) {
            System.out.print(nota[j] + " ");
        }

        int media = aux/nota.length;
        System.out.print("\nMedia das notas: " + media);

        
        input.close();
    }
}