package avaliacao1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class banco {

    public static void main(String[] args) {

        int usuarios = 0;
        Boolean done = false;
        Scanner input = new Scanner(System.in);

        System.out.print("Banco\n");
        System.out.print("-------\n");
        while (!done) {
            try {
                System.out.print("\nInforme a quantidade de usuarios a registrar: ");
                usuarios = input.nextInt();
                done = true;
            } catch (InputMismatchException e) {
                System.out.print("Formato incorreto, tente novamente.\n");
            }
        }
        
        String nomes[] = new String[usuarios];
        Double saldos[] = new Double[usuarios];

        System.out.print("\nRegistro de Usuario");
        System.out.print("\n-------------------");
        for (int i=0; i < usuarios; i++) {
            System.out.print("\nNome do Usuario: ");
            input = new Scanner(System.in);
            nomes[i] = input.nextLine();
            done = false;
            while(!done) {
                try {
                    System.out.print("Saldo do Usuario: ");
                    input = new Scanner(System.in);
                    saldos[i] = input.nextDouble();
                    done = true;
                } catch (InputMismatchException e) {
                    System.out.print("Formato incorreto, tente novamente.\n");
                }
            }
        }

        Boolean fechar = false;
        while (!fechar) {
            done = false;
            int opcao = 0, nroConta = 0, nroContaAux = 0;
            Double deposito = 0.00, saque = 0.00;

            System.out.print("\n\n----------- Menu -----------");
            System.out.print("\n-----------------------------");
            System.out.print("\n1 - Depositar");
            System.out.print("\n2 - Sacar");
            System.out.print("\n3 - Transferir");
            System.out.print("\n4 - Imprimir conta");
            System.out.print("\n5 - Imprimir todas as contas");
            System.out.print("\n6 - Encerrar");
            System.out.print("\n-----------------------------");
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

                // Depositar
                case 1:
                    System.out.print("\nDepositar");
                    System.out.print("\n---------");
                    done = false;
                    while (!done) {
                        try {
                            System.out.print("\nNúmero da Conta: ");
                            input = new Scanner(System.in);
                            nroConta = input.nextInt();
                            if (nroConta > 0 || nroConta <= nomes.length) {
                                done = true;
                            } else {
                                System.out.print("Numero de Conta errada.\n");
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("Formato errado, tente novamente.\n");
                        }
                    }
                    done = false;
                    while (!done) {
                        try {
                            System.out.print("\nValor a Depositar: ");
                            input = new Scanner(System.in);
                            deposito = input.nextDouble();
                            done = true;
                        } catch (InputMismatchException e) {
                            System.out.print("Formato errado, tente novamente.\n");
                        }
                    }
                    saldos[nroConta] = saldos[nroConta] + deposito;
                    System.out.print("\nValor Depositado. \nSaldo atualizado.");
                    break;

                // Sacar
                case 2:
                    System.out.print("\nSacar");
                    System.out.print("\n-----");
                    done = false;
                    while (!done) {
                        try {
                            System.out.print("\nNúmero da Conta: ");
                            input = new Scanner(System.in);
                            nroConta = input.nextInt();
                            if (nroConta > 0 || nroConta <= nomes.length) {
                                done = true;
                            } else {
                                System.out.print("Numero de Conta errada.\n");
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("Formato errado, tente novamente.\n");
                        }
                    }
                    done = false;
                    while (!done) {
                        try {
                            System.out.print("\nValor a Sacar: ");
                            input = new Scanner(System.in);
                            saque = input.nextDouble();
                            if (saque <= saldos[nroConta]) {
                                done = true;
                            } else {
                                System.out.print("Saldo insuficiente.\n");
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("Formato errado, tente novamente.\n");
                        }
                    }
                    saldos[nroConta] = saldos[nroConta] - saque;
                    System.out.print("\nValor Retirado. \nSaldo atualizado.");
                    break;

                // Transferir
                case 3:
                    System.out.print("\nTransferir");
                    System.out.print("\n----------");
                    done = false;
                    while (!done) {
                        try {
                            System.out.print("\nNúmero da Conta a retirar: ");
                            input = new Scanner(System.in);
                            nroConta = input.nextInt();
                            if (nroConta > 0 || nroConta <= nomes.length) {
                                done = true;
                            } else {
                                System.out.print("Numero de Conta errada.\n");
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("Formato errado, tente novamente.\n");
                        }
                    }
                    done = false;
                    while (!done) {
                        try {
                            System.out.print("\nNúmero da Conta a depositar: ");
                            input = new Scanner(System.in);
                            nroContaAux = input.nextInt();
                            if (nroContaAux > 0 || nroContaAux <= nomes.length) {
                                done = true;
                            } else {
                                System.out.print("Numero de Conta errada.\n");
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("Formato errado, tente novamente.\n");
                        }
                    }
                    done = false;
                    while (!done) {
                        try {
                            System.out.print("\nValor a Transferir: ");
                            input = new Scanner(System.in);
                            saque = input.nextDouble();
                            if (saque <= saldos[nroConta]) {
                                done = true;
                            } else {
                                System.out.print("Saldo insuficiente.\n");
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("Formato errado, tente novamente.\n");
                        }
                    }
                    saldos[nroConta] = saldos[nroConta] - saque;
                    saldos[nroContaAux] = saldos[nroContaAux] + saque;
                    System.out.print("\nValor Transferido. \nSaldo atualizado.");
                    break;

                // Imprimir uma Conta
                case 4:
                    System.out.print("\nImprimir Conta");
                    System.out.print("\n--------------");
                    done = false;
                    while (!done) {
                        try {
                            System.out.print("\nNúmero da Conta: ");
                            input = new Scanner(System.in);
                            nroConta = input.nextInt();
                            if (nroConta > 0 || nroConta <= nomes.length) {
                                done = true;
                            } else {
                                System.out.print("Numero de Conta errada.\n");
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("Formato errado, tente novamente.\n");
                        }
                    }
                    
                    System.out.print("\nNro de Conta: " + nroConta);
                    System.out.print("\nNome do usuario: " + nomes[nroConta]);
                    System.out.print("\nSaldo disponivel: " + saldos[nroConta]);
                    break;

                // Imprimir todas as contas
                case 5:
                    System.out.print("\nImprimir todas as contas");
                    System.out.print("\n------------------------");
                    for (int i=0; i < nomes.length; i++) {
                        System.out.print("\nNro de Conta: " + i);
                        System.out.print("\nNome do usuario: " + nomes[i] + "\n");
                    }
                    break;

                // Encerrar
                case 6:
                    System.out.print("\nEncerrando o programa...\n\n");
                    fechar = true;
                    break;
                    
                // Default
                default:
                    System.out.print("\nOpcao errada, selecione outra opcao.\n");
                    break;

            }

        }
        
    }
    
}