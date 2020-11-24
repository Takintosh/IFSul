package lista5;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class lista5Ex2 {

    public static void main(String[] args) {

        lista5Ex1.criarConta();

        lista5Ex1 ex1 = new lista5Ex1();
        String nome = ex1.nomeCompleto;
        String telefone = ex1.telefone;
        String email = ex1.email;
        String conta = ex1.tipoConta;
        int identidade = ex1.identidade;
        Double saldo = ex1.depositoInicial;
        Boolean status = ex1.status;

        Double retiro = 0.00;
        Double deposito = 0.00;
        Boolean done = false;
        int transferencia = 0;

        Scanner input = new Scanner(System.in);
        Random generador = new Random();

        int nroConta = generador.nextInt(((1000-100)+1)+100);

        while (true) {
            System.out.print("\n\nConta Bancaria N° " + nroConta);
            System.out.print("\n------------------------------\n");
            System.out.print("\n1 - Sacar");
            System.out.print("\n2 - Depositar");
            System.out.print("\n3 - Saldo");
            System.out.print("\n4 - Transferir");
            System.out.print("\n5 - Pagamentos");
            System.out.print("\n6 - Sair\n");
            System.out.print("\n------------------------------\n");
            System.out.print("Opcao: ");

            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    done = false;
                    while (!done) {
                        try {
                            System.out.print("\nValor a retirar da conta: ");
                            input = new Scanner(System.in);
                            retiro = input.nextDouble();
                            if (retiro <= saldo) {
                                saldo = (saldo - retiro);
                                System.out.print("\nValor retirado. Saldo atualizado.");
                                done = true;
                            } else {
                                System.out.print("\nSaldo nao disponivel.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("\nFormato incorreto, tente novamente. ");
                        } 
                    }
                    break;

                case 2:
                    done = false;
                    while (!done) {
                        try {
                            System.out.print("\nValor a depositar na conta: ");
                            input = new Scanner(System.in);
                            deposito = input.nextDouble();
                            saldo = (saldo + deposito);
                            System.out.print("\nValor depositado. Saldo atualizado.");
                            done = true;
                        } catch (InputMismatchException e) {
                            System.out.print("\nFormato incorreto, tente novamente. ");
                        } 
                    }
                    break;
                    
                case 3:
                    System.out.print("\nSaldo disponivel na conta: " + saldo + "\n");
                    break;

                case 4:
                    done = false;
                    while (!done) {
                        try {
                            System.out.print("\nNúmero de Conta a transferir: ");
                            input = new Scanner(System.in);
                            transferencia = input.nextInt();
                            done = true;
                        } catch (InputMismatchException e) {
                            System.out.print("\nFormato incorreto, tente novamente. ");
                        }
                    }
                    done = false;
                    while (!done) {
                        try {
                            System.out.print("\nValor a transferir: ");
                            input = new Scanner(System.in);
                            retiro = input.nextDouble();
                            if (retiro <= saldo) {
                                saldo = (saldo - retiro);
                                System.out.print("\nValor transferido. Saldo atualizado.");
                                done = true;
                            } else {
                                System.out.print("\nSaldo nao disponivel.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("\nFormato incorreto, tente novamente. ");
                        }
                    }
                    break;

                case 5:
                    done = false;
                    while (!done) {
                        try {
                            System.out.print("\nNúmero do boleto a pagar: ");
                            input = new Scanner(System.in);
                            transferencia = input.nextInt();
                            done = true;
                        } catch (InputMismatchException e) {
                            System.out.print("\nFormato incorreto, tente novamente. ");
                        }
                    }
                    done = false;
                    while (!done) {
                        try {
                            System.out.print("\nValor a pagar: ");
                            input = new Scanner(System.in);
                            retiro = input.nextDouble();
                            if (retiro <= saldo) {
                                saldo = (saldo - retiro);
                                System.out.print("\nBoleto pago. Saldo atualizado.");
                                done = true;
                            } else {
                                System.out.print("\nSaldo nao disponivel.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("\nFormato incorreto, tente novamente. ");
                        }
                    }
                    break;

                case 6:
                    System.out.print("\nSaindo do programa...\n");
                    System.exit(0);
                    break;

                default:
                    System.out.print("\nOpcao errada, selecione outra opcao.\n");
                    break;
            }

        }

    }
    
}