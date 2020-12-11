import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class lista7Ex1 {

    public static void main(String[]args) {

        boolean done = false;
        String frase;
        Scanner input = new Scanner(System.in);
        ArrayList<String> itens = new ArrayList<String>();

        while (!done) {
            System.out.println("\nInforme a String: ");
            input = new Scanner(System.in);
            frase = input.nextLine();
            if(frase.equals("Sair") || frase.equals("Salir") || frase.equals("sair") || frase.equals("salir")) {
                done = true;
            } else {
                itens.add(frase);
            }
        }

        Collections.sort(itens);
        System.out.println("\n\nLista ordenada: ");
        for (int i = 0; i < itens.size(); i++) {
			System.out.println(itens.get(i));
		}

    }

}