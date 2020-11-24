import java.util.Scanner;

public class lista4Ex4 {

    public static void main(String[] args) {

        String frase = "";
        StringBuilder fraseConstruida = new StringBuilder(frase);

        String morse;
        Scanner input = new Scanner(System.in);
        System.out.print("\nIngrese la frase en código Morse: \n");
        morse = input.nextLine();

        input.close();

        String caracteres[] = morse.split(" ");
        String diccionario[][] = { { "a", ".-" }, { "b", "-..." }, { "c", "-.-." }, { "d", "-.." }, { "e", "." },
                { "f", "..-." }, { "g", "--." }, { "h", "...." }, { "i", ".." }, { "j", ".---" }, { "k", "-.-" },
                { "l", ".-.." }, { "m", "--" }, { "n", "-." }, { "o", "---" }, { "p", ".--." }, { "q", "--.-" },
                { "r", ".-." }, { "s", "..." }, { "t", "-" }, { "u", "..-" }, { "v", "...-" }, { "w", ".--" },
                { "x", "-..-" }, { "y", "-.--" }, { "z", "--.." }, { "0", "-----" }, { "1", ".----" }, { "2", "..---" },
                { "3", "...--" }, { "4", "....-" }, { "5", "....." }, { "6", "-...." }, { "7", "--..." },
                { "8", "---.." }, { "9", "----." }, { " ", "/" } };

        for (int i = 0; i < caracteres.length; i++) {

            for (int j = 0; j < diccionario.length; j++) {
                if (caracteres[i].equals(diccionario[j][1])) {
                    fraseConstruida = fraseConstruida.append(diccionario[j][0]);
                }
            }

        }

        frase = fraseConstruida.toString();
        frase = frase.substring(0, 1).toUpperCase() + frase.substring(1);
        System.out.print("\nFrase decodificada: \n" + frase + ".");

    }

}