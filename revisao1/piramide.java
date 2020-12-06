package revisao1;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.text.DecimalFormat;

public class piramide {

    public static void main(String[] args) {

        int linhas = 0;
        Boolean done = false;
        Scanner input = new Scanner(System.in);

        System.out.print("\nPiramide");
        System.out.print("\n--------");

        while (!done) {
            try {
                System.out.print("\nInforme a quantidade de linhas da piramide: ");
                linhas = input.nextInt();
                done = true;
            } catch (InputMismatchException e) {
                System.out.print("\nFormato incorreto, tente novamente.");
            }
        }

        for (int i=1; i <= linhas; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(new DecimalFormat("00").format(i) + " ");
            }
            System.out.print("\n");
        }

    }
    
}