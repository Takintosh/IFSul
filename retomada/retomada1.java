import java.util.Scanner;

public class retomada1 {

    public static void main (String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Escreva o 1° numero: ");
        int nro1 = input.nextInt();
        System.out.print("Escreva o 2° numero: ");
        int nro2 = input.nextInt();

        input.close();

        if (nro1 == nro2) {
            System.out.print("\nOs numeros sao iguais");
        } else if (nro1 > nro2) {
            System.out.print("\nO " + nro1 + " é o maior, e " + nro2 + " é o menor.");
        } else {
            System.out.print("\nO " + nro2 + " é o maior, e " + nro1 + " é o menor.");
        }

    }
}
