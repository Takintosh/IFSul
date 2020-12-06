package revisao1;

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class adivinhe {
    public static void main (String[] args) {
        
        Random generador = new Random();
        int n = generador.nextInt((100-1)+1)+1, contador = 0, numero = 0;
        Boolean done = false;
        Scanner input = new Scanner(System.in);

        System.out.print("\nAdivinhe o numero");
        System.out.print("\n-----------------");

        while (true) {

            while (!done) {
                try {
                    System.out.print("\nDigite um valor de 1 a 100: ");
                    input = new Scanner(System.in);
                    numero = input.nextInt();
                    if (numero < 1 || numero > 100) {
                        System.out.print("\nValor fora dos limites, tente novamente.");
                    } else {
                        contador = contador + 1;
                        done = true;                    
                    }
                } catch (InputMismatchException e) {
                    System.out.print("\nFormato incorreto, tente novamente.");
                }
            }

            if (numero == n) {
                System.out.print("Felicidades! Acertou o número sorteado em " + contador + " tentativas.");
                break;
            } else if (numero < n) {
                System.out.print("Pista: o numero sorteado é maior.");
                done = false;
            } else {
                System.out.print("Pista: o numero sorteado é menor.");
                done = false;
            }

        }

        input.close();
    }

}