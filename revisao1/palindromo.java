package revisao1;

import java.util.Scanner;

public class palindromo {

    public static void main(String[] args) {

        String frase;
        Scanner input = new Scanner(System.in);

        System.out.print("\nPalindromo");
        System.out.print("\n----------");

        System.out.print("\nInforme a frase: ");
        frase = input.nextLine();
        input.close();

        frase = frase.replace(" ", "");
        frase = frase.toLowerCase();
        System.out.print("\nNova frase: " + frase);

        check(frase);

    }

    public static void check(String frase) {

        String frase2;
        StringBuilder inverso = new StringBuilder(frase);
        frase2 = inverso.reverse().toString();
        if (frase.equals(frase2)) {
            System.out.print("\nA frase é um palindromo.");
        } else {
            System.out.print("\nA frase nao é um palindromo.");
        }

    }
    
}