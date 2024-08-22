package Projeto_Banco_Java;

import java.text.ParseException;

import java.util.ArrayList;

import java.util.Scanner;



public class Menu {



    public static void Select() throws ParseException, InterruptedException {



        ArrayList<Cliente> contas = new ArrayList<>();

        Cliente Gustavo = new Cliente("123", "João Robens", "RobensJ@gmail.com", "12345678900",

                "06/10/1995", "20/07/2012", 25000.00, 12500.00);

        contas.add(Gustavo);



        Scanner input = new Scanner(System.in);

        int opcoes = 0;

        String id1;

        String id2;

        double quantia;



        do {

            System.out.println("Sejam bem-vindos ao banco digital.");

            System.out.println("Por favor selecione qual opção você deseja realizar?");

            System.out.println("1 - Criar contas");

            System.out.println("2 - Efetuar Saque");

            System.out.println("3 - Efetuar Depósito");

            System.out.println("4 - Efetuar Transferência");

            System.out.println("5 - Listar Contas");

            System.out.println("6 - Sair do Sistema");

            System.out.println();



            opcoes = input.nextInt();

            input.nextLine();



            switch (opcoes){

                case(1):

                    System.out.println("Você escolheu criar uma nova conta.");

                    System.out.println();

                    Conta.CriarConta(contas);

                    break;

                case(2):

                    System.out.println("Você escolheu realizar um saque na sua conta.");

                    Conta.EfetuarSaque(contas);

                    break;

                case(3):

                    System.out.println("Você escolheu realizar um deposito na sua conta.");

                    Conta.EfetuarDeposito(contas);

                    break;

                case(4):

                    System.out.println("Você escolheu realizar uma transferencia de sua conta para outra conta.");

                    Conta.EfetuarTransferencia(contas);

                    break;

                case(5):

                    System.out.println("Você escolheu ver todas as contas dentro do sistema");

                    System.out.println();

                    Conta.ListarContas(contas);

                    break;

                case(6):

                    System.out.println("Você escolheu sair do sistema. " +

                            "\nAgradecemos você ter escolhido o Banco digital esperamos pelo seu retorno");

                    System.exit(0);

                    break;

                default:

                    System.out.println("Opção inválida");

                    break;

            }

        } while(opcoes != 6);

        System.exit(0);

    }

}