package revisao1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class clinica {

    public static void main(String[] args) {

        int p = 0, suma = 0, qh = 0, qm = 0, qp = 0, velho = 0, pvelho = 0, baixa = 300, pbaixa = -1;
        Boolean done = false;
        Scanner input = new Scanner(System.in);

        System.out.print("\nClinica");
        System.out.print("\n-------");

        while (!done) {
            try {
                System.out.print("\nInforme a quantidade de pacientes: ");
                p = input.nextInt();
                done = true;
            } catch (InputMismatchException e) {
                System.out.print("\nFormato incorreto, tente novamente.");
            }
        }

        String[] nomes = new String[p];
        int[] idades = new int[p];
        Double[] pesos = new Double[p];
        int[] alturas = new int[p];
        char[] sexos = new char[p];

        for (int i=0; i < p; i++) {
            
            System.out.print("\nPaciente N° " + (i+1));

            done = false;
            while (!done) {
                try {
                    System.out.print("\nInforme o nome do paciente: ");
                    input = new Scanner(System.in);
                    nomes[i] = input.nextLine();
                    done = true;
                } catch (InputMismatchException e) {
                    System.out.print("\nFormato incorreto, tente novamente.");
                }
            }

            done = false;
            while (!done) {
                try {
                    System.out.print("\nInforme a idade do paciente: ");
                    input = new Scanner(System.in);
                    idades[i] = input.nextInt();
                    done = true;
                } catch (InputMismatchException e) {
                    System.out.print("\nFormato incorreto, tente novamente.");
                }
            }

            done = false;
            while (!done) {
                try {
                    System.out.print("\nInforme o peso do paciente (kg): ");
                    input = new Scanner(System.in);
                    pesos[i] = input.nextDouble();
                    done = true;
                } catch (InputMismatchException e) {
                    System.out.print("\nFormato incorreto, tente novamente.");
                }
            }

            done = false;
            while (!done) {
                try {
                    System.out.print("\nInforme a altura do paciente (cm): ");
                    input = new Scanner(System.in);
                    alturas[i] = input.nextInt();
                    done = true;
                } catch (InputMismatchException e) {
                    System.out.print("\nFormato incorreto, tente novamente.");
                }
            }

            done = false;
            while (!done) {
                try {
                    System.out.print("\nInforme o sexo do paciente (M/F): ");
                    input = new Scanner(System.in);
                    sexos[i] = input.next().charAt(0);
                    sexos[i] = Character.toLowerCase(sexos[i]);
                    done = true;
                } catch (InputMismatchException e) {
                    System.out.print("\nFormato incorreto, tente novamente.");
                }
            }

            if (sexos[i] == 'm') {
                suma = suma + idades[i];
                qh++;
            }
            if ( (sexos[i] == 'f') && ((alturas[i] < 170) && (alturas[i] > 160)) && (pesos[i]>70) ) {
                qm++;
            }
            if (idades[i] > 18 && idades[i] < 25) {
                qp++;
            }
            if (idades[i] > velho) {
                velho = idades[i];
                pvelho = i;
            }
            if (sexos[i] == 'f' && alturas[i] < baixa ) {
                baixa = alturas[i];
                pbaixa = i;
            }


        }

        System.out.print("\nRelatorio ");
        System.out.print("\n-------------------------------------------------------------------------------------");
        System.out.print("\n1 - Quantidade de Pacientes: " + p);
        System.out.print("\n2 - Media da idade dos homens: " + (suma/qh));
        System.out.print("\n3 - Quantidade de Mulheres com altura entre 1,60m e 1,70m; e peso acima de 70Kg: " + qm);
        System.out.print("\n4 - Quantidade de Pacientes com idade entre 18 e 25 anos: " + qp);
        System.out.print("\n5 - Paciente mais velho: " + nomes[pvelho]);
        System.out.print("\n6 - Mulher mais baixa: ");
        if (pbaixa == -1) {
            System.out.print("N/D");
        } else {
            System.out.print(nomes[pbaixa]);
        }
        System.out.print("\n-------------------------------------------------------------------------------------");
        
        input.close();

    }
    
}