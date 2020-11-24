import java.util.Scanner;

public class lista3Ex4 {
    public static void main (String[] args) {

        String[] vagas = new String[10];
        int vaga;

        Scanner input = new Scanner(System.in);

        int choice;
        while (true) {
            System.out.print("\n\nEstacionamento de veiculos:\n");
            System.out.print("---------------------------\n");
            System.out.print("1 - Entrada de Veiculo\n");
            System.out.print("2 - Saida de Veiculo\n");
            System.out.print("3 - Listar situacao atual\n");
            System.out.print("4 - Sair do programa\n");
            System.out.print("---------------------------\n");
            System.out.print("Opcao: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    do {
                        System.out.print("\nNumero da vaga: ");
                        input = new Scanner(System.in);
                        vaga = input.nextInt();
                        if(vagas[vaga] != null) {
                            System.out.print("\nVaga ocupada, por favor, selecione outra vaga.");
                        }
                    } while (vagas[vaga] != null);
                    System.out.print("\nPlaca do veiculo: ");
                    input = new Scanner(System.in);
                    vagas[vaga] = input.nextLine();
                    break;

                case 2:
                    do {
                        System.out.print("\nNumero da vaga: ");
                        input = new Scanner(System.in);
                        vaga = input.nextInt();
                        if(vagas[vaga] == null) {
                            System.out.print("\nVaga vazía, por favor, selecione outra vaga.");
                        }
                    
                    } while (vagas[vaga] == null);
                    vagas[vaga] = null;
                    System.out.print("\nVaga esvaziada corretamente.");
                    break;

                case 3:
                    System.out.print("\nSituacao atual:");
                    for (int i=0; i<vagas.length; i++) {
                        System.out.print("\nVaga " + i + ": ");
                        if (vagas[i] == null) {
                            System.out.print("vazía.");
                        } else {
                            System.out.print(vagas[i] + ".");
                        }
                    }
                    break;

                case 4:
                    System.out.print("\nSaindo do programa...");
                    System.exit(0);
                    break;

                default:
                    System.out.print("\nOpcao errada, selecione outra opcao.\n");
                    break;
                    
            }

        }

    }

}