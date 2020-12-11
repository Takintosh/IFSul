import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.InputMismatchException;

public class lista7Ex4 {

    public static void main(String[]args) {
        
        Map<Integer, String> myMap = new HashMap<>();
        Scanner input = new Scanner(System.in);
        int nrodoc = 0;
        String nome = "";
        Boolean loop = false, done = false;

        while(!loop) {

            while (!done) {
                try {
                    System.out.println("\nInsira o nro de documento: ");
                    input = new Scanner(System.in);
                    nrodoc = input.nextInt();
                    done = true;
                } catch (InputMismatchException e) {
                    System.out.println("\nFormato incorreto, tente novamente.");
                }
            }
            done = false;

            if (nrodoc == 0) {
                loop = true;
            } else {
                if(myMap.containsKey(nrodoc)){
                    System.out.println("\nO nro de documento ja existe para " + myMap.get(nrodoc));
                } else {
                    System.out.println("\nNome Completo: ");
                    input = new Scanner(System.in);
                    nome = input.nextLine();
                    myMap.put(nrodoc, nome);
                }
            }

        }

        Set<Integer> keys = myMap.keySet();
        TreeSet<Integer> sortedKeys = new TreeSet<>(keys);
        System.out.println("\nMapa:\n");
        for (int k:sortedKeys) {
            System.out.println("Chave: " + k);
            System.out.println("Nome: " + myMap.get(k) + "\n");
        }
        
    }
    
}