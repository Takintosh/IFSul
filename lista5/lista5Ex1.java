package lista5;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lista5Ex1 {

    private static final String regex = "^(.+)@(.+)$";

    public static String nomeCompleto, telefone, email = "", tipoConta ="";
    public static int identidade = 0;
    public static Double depositoInicial = 0.00;
    public static Boolean status = false;
    

    public static void main(String[] args) {

        criarConta();

    }

    public static void criarConta() {

        Boolean done;

        Scanner input = new Scanner(System.in);
        input = new Scanner(System.in);

        Pattern pattern = Pattern.compile(regex);

        System.out.print("\nCriaçao de conta nova \n");
        System.out.print("---------------------- \n");

        System.out.print("Nome Completo: ");
        nomeCompleto = input.nextLine();
        
        System.out.print("\nTelefone: ");
        telefone = input.nextLine();

        done = false;
        while (!done) {
            System.out.print("\nEmail: ");
            input = new Scanner(System.in);
            email = input.nextLine();
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                done = true;
            } else {
                System.out.print("\nFormato incorreto, tente novamente. ");
            }
        }

        done = false;
        while (!done) {
            System.out.print("\nTipo de Conta (Poupança ou Corrente) [P/C]: ");
            input = new Scanner(System.in);
            tipoConta = input.nextLine();
            if (tipoConta.equals("P")) {
                tipoConta = "poupança";
                done = true;
            } else if (tipoConta.equals("C")) {
                tipoConta = "corrente";
                done = true;
            } else {
                System.out.print("\nFormato incorreto, tente novamente. ");
            }
        }

        done = false;
        while (!done) {
            try {
                System.out.print("\nDocumento de Identidade (RG ou CI): ");
                input = new Scanner(System.in);
                identidade = input.nextInt();
                done = true;
            } catch (InputMismatchException e) {
                System.out.print("\nFormato incorreto, tente novamente. ");
            }
        }

        done = false;
        while (!done) {
            try {
                System.out.print("\nDeposito inicial: ");
                input = new Scanner(System.in);
                depositoInicial = input.nextDouble();
                done = true;
            } catch (InputMismatchException e) {
                System.out.print("\nFormato incorreto, tente novamente. ");
            }
        }

        status = true;

        System.out.print("\n\n--------------------");
        System.out.print("\nDados da conta");
        System.out.print("\nNome Completo: " + nomeCompleto);
        System.out.print("\nTelefone: " + telefone);
        System.out.print("\nEmail: " + email);
        System.out.print("\nTipo de Conta: " + tipoConta);
        System.out.print("\nIdentidade: " + identidade);
        System.out.print("\nDeposito: " + depositoInicial);
        System.out.print("\nEstado da Conta: ");
        if(status = true) {
            System.out.print("Ativa");
        } else {
            System.out.print("Desativada");
        }
        System.out.print("\n--------------------\n");

    }

}