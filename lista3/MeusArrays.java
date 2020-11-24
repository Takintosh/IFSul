package lista3;

import java.util.Scanner;
import java.util.Random;

public class MeusArrays {

    public static void array1() {
        int arrayA[] = new int[3];
        int arrayB[] = new int[3];
        int aux = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("Digite os valores do array A, seguidos de um ENTER: ");
        for (int i=0; i<arrayA.length; i++) {
            arrayA[i] = input.nextInt();
        }
        System.out.print("Digite os valores do array B, seguidos de um ENTER: ");
        for (int i=0; i<arrayB.length; i++) {
            arrayB[i] = input.nextInt();
        }
        System.out.print("Digite o valor a procurar: ");
        int n = input.nextInt();

        for (int i=0; i<arrayA.length; i++) {
            if (arrayA[i] == n) {
                aux = aux + 1;
                break;
            }
        }
        for (int i=0; i<arrayB.length; i++) {
            if (arrayB[i] == n) {
                aux = aux + 1;
                break;
            }
        }
        System.out.print("Valor: " + aux + "\n");
        
    }

    public static void array2() {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite um valor (n): ");
        int n = input.nextInt();
        int array2[] = new int[n];
        Random generador = new Random();
        System.out.print("\nValores do array: ");
        for (int i=0; i<n; i++) {
            array2[i] = generador.nextInt((1000-0)+1)+0;
            System.out.print(array2[i] + " ");
        }
    }

}