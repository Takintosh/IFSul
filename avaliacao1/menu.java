package avaliacao1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class menu {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("\n\n----------- Menu -----------");
            System.out.print("\n-----------------------------");
            System.out.print("\n1 - Piramide");
            System.out.print("\n2 - Banco");
            System.out.print("\n3 - Palindromo de Data");
            System.out.print("\n4 - Encerrar");
            System.out.print("\n-----------------------------");

            Boolean done = false;
            int opcao = 0;

            while (!done) {
                try {
                    System.out.print("\nOpcao: ");
                    input = new Scanner(System.in);
                    opcao = input.nextInt();
                    done = true;
                } catch (InputMismatchException e) {
                    System.out.print("Formato errado, tente novamente.");
                }
            }

            switch (opcao) {
                case 1:
                    piramide.main(null);
                    break;

                case 2:
                    banco.main(null);
                    break;
                    
                case 3:
                    palindromo.main(null);
                    break;

                case 4:
                    System.out.print("\nEncerrando o programa...\n\n");
                    System.exit(0);
                    break;

                default:
                    System.out.print("\nOpcao errada, selecione outra opcao.\n");
                    break;
            }

        }

    }
    
}