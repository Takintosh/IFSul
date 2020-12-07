package avaliacao1;

import java.util.Scanner;

public class piramide {

    public static void main(String[] args) {

        String frase;
        Scanner input = new Scanner(System.in);

        System.out.print("\nPiramide");
        System.out.print("\n--------");

        System.out.print("\nInforme a frase da piramide: ");
        frase = input.nextLine();

        frase = frase.replace(" ", "");

        for (int i=0; i <= frase.length(); i++) {
            System.out.print(frase.substring(0, i));
            System.out.print("\n");
        }

        for (int i=(frase.length()-1); i >= 0; i--) {
            System.out.print(frase.substring(frase.length()-i));
            System.out.print("\n");
        }

    }
    
}