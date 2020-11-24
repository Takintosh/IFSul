import java.util.Scanner;

public class retomada2 {

    public static void main (String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Escreva o seu texto: ");
        String texto = input.nextLine();

        input.close();

        String inverso = "";
        for(int i = texto.length()-1; i >= 0; i--) {
            inverso = inverso + texto.charAt(i);
        }

        String maiusculo = texto.toUpperCase();

        System.out.print("\nTamanho do texto: " + texto.length() + " caracteres.\n");

        System.out.print("\nPrimeiro caractere do texto: " + texto.charAt(0) + "\n");

        System.out.print("\nUltimo caractere do texto: " + inverso.charAt(0) + "\n");

        System.out.print("\nTexto em maiúsculo: \n" + maiusculo + "\n");

        String vogalM = "";
        for(int j = 0; j <= texto.length()-1; j++)  {
            if (texto.charAt(j) == 'a' || texto.charAt(j) == 'e' || 
            texto.charAt(j) == 'i' || texto.charAt(j) == 'o' || 
            texto.charAt(j) == 'u') 
            {
                vogalM = vogalM + maiusculo.charAt(j);
            } else {
                vogalM = vogalM + texto.charAt(j);
            }
        }
        System.out.print("\nVogais em maiúsculo: \n" + vogalM + "\n");

        inverso = inverso.replace(" ", "");
        System.out.print("\nTexto inverso sem espaço: \n" + inverso + "\n");

    }
}
