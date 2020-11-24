import java.util.Scanner;

public class lista4Ex1 {

    public static void main(String[] args) {

        String frase;
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("\nIngrese la frase a ser traducida a PigLatin: \n");
            input = new Scanner(System.in);
            frase = input.nextLine();
            frase = frase.toLowerCase();
            if (frase.equals("exit")) {
                System.exit(0);
            } else {
                translation(frase);
                System.out.print("\n");
            }

        }

    }

    public static void translation(String frase) {

        String[] palabras = frase.split(" ");

        for (int i = 0; i < palabras.length; i++) {

            if (palabras[i].length() > 1) {
                char primero = palabras[i].charAt(0);

                String traducido = palabras[i].substring(0);

                StringBuilder traducido2 = new StringBuilder(traducido);
                traducido2 = traducido2.deleteCharAt(0).append(primero).append("ay");

                System.out.print(traducido2 + " ");
            } else {
                System.out.print(palabras[i] + " ");
            }

        }

    }

}