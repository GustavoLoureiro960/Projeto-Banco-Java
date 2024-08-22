package Projeto_Banco_Java;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Conta {

    private static String id;


    public static void CriarConta(ArrayList<Cliente> contas) throws ParseException {



        Scanner scan = new Scanner(System.in);



        System.out.println("Por favor insiria as seguintes informações nesta ordem començando pelo seu nome completo");

        String nome = scan.nextLine();

        if (nome.equals("quit") || nome.isEmpty()){

            System.exit(0);

        }



        System.out.println("Agora insira o seu E-mail");

        String email = scan.nextLine();



        System.out.println("Agora insira o número de seu CPF");

        String cpf = scan.nextLine();



        System.out.println("Por favor informe sua data de nascimento: dia/mês/ano");

        String data = scan.nextLine();



        DateTimeFormatter formattter = DateTimeFormatter.ofPattern("dd/MM/yyyy");



        LocalDate dataNasci = LocalDate.parse(data, formattter);

        String dataNascimento = formattter.format(dataNasci);



        System.out.println("Por favor insira o saldo inicial de sua conta");

        Double saldo = scan.nextDouble();



        //Define os limites de Saque e Deposito permitidos do cliente

        Double limiteSaque = saldo / 2;



        //Definie a data em que o registro foi realizado

        LocalDate dataCadas = LocalDate.now();

        String dataCadastro = formattter.format(dataCadas);



        //Instancia o numero da conta conta.

        Random rand = new Random();

        String id = String.valueOf(rand.nextInt(99,1000));

        IdCheck(contas,id);



        //Crie novo Cliente com os dados especificados

        Cliente conta = new Cliente(id, nome, email, cpf, dataNascimento, dataCadastro, saldo, limiteSaque);



        //Analise se já existe uma conta com os mesmos parametros.

        Boolean check = AnalisaContas(contas, nome, email, cpf);



        if (!check){

            System.out.println("Seu número de identificação de conta é:" + id);

            contas.add(conta);

            System.out.println("Sua conta foi criada com sucesso");

            System.out.println();

        }else{

            System.out.println("Por favor revise os dados que você deseja inserir em sua conta");

            System.out.println();

        }

    }



    public static Cliente LocalizarConta(ArrayList<Cliente> contas){

        Scanner scan = new Scanner(System.in);

        String Id;

        Cliente conta = null;



        Id = scan.nextLine();



        for(Cliente c : contas){

            if (c != null ){

                if(c.getId().equals(Id)){

                    conta = c;

                    System.out.println("Conta " + conta.getId() + " encontrada");

                }

            } else {

                System.out.println("Não foi encontrada conta com esse número de idenficação");

            }

        }

        return conta;

    }



    public static void EfetuarSaque(ArrayList<Cliente> contas) {



        double saque;



        System.out.println("Por favor informe o Nûmero de Identificação de sua conta");

        Cliente conta = LocalizarConta(contas);



        // Infrome a Quantia que deseja ser sacada

        System.out.println("Por favor informe a quantia que você deseja sacar de sua conta");

        Scanner scan = new Scanner(System.in);

        saque = scan.nextDouble();



        //Verifica se a conta possui saldo atual o bastante para ser sacada.

        if (conta.getLimiteSaque() >= saque && conta.getSaldo() > 0) {

            if (conta.getSaldo() - saque < 0 || conta.getSaldo() - saque == 0) {

                System.out.println("Você tentou realizar um saque de R$ " + saque + " na conta: " + conta.getId() +

                        "\nmas o saldo atual de sua conta não é o bastante para realizar um saque nesta quantia");

            } else {

                conta.setSaldo(conta.getSaldo() - saque);

                System.out.println("Você realizou um saque de R$:" + saque + " na conta: " + conta.getId());

            }

        }else {

            System.out.println("Você não pode realizar um saque dessa quantia nesta conta");

        }

        System.out.println();

    }



    public static void EfetuarDeposito(ArrayList<Cliente> contas) {

        double saque;

        System.out.println("Por favor informe o Nûmero de Identificação de sua conta");

        Cliente conta = LocalizarConta(contas);



        //Realiza a busca da conta baseando-se no Nûmero de Identificação

        System.out.println("Por favor informe a quantia que você deseja depositarr em sua conta");

        Scanner teclado = new Scanner(System.in);

        saque = teclado.nextDouble();

        conta.setSaldo(conta.getSaldo() + saque);

        System.out.println("Você realizou um saque de R$:" + saque + " na conta: " + conta.getId());



        System.out.println();

    }




    public static void EfetuarTransferencia(ArrayList<Cliente> contas) {

        Scanner scan = new Scanner(System.in);

        double transferencia;



        System.out.println("Por favor informe o numero de ID da sua conta");

        Cliente conta1 = LocalizarConta(contas);



        System.out.println("Por favor informe o nûmero de identificação da conta para a qual você deseja transfererir");

        Cliente conta2 = LocalizarConta(contas);



        //Passe a quantia que deseja tranferir de sua conta

        System.out.println("Por favor informe a quantia que você deseja transferir");

        transferencia = scan.nextDouble();



        //Condicional que compara o valor da transferencia e avalia se ela pode ser realizada.

        if(conta1.getLimiteSaque() >= transferencia && conta1.getSaldo() > 0) {



            conta1.setSaldo(conta1.getSaldo() - transferencia);

            conta2.setSaldo(conta2.getSaldo() + transferencia);

            System.out.println("Você realizou uma transferencia de R$:" + transferencia +

                    " da conta: " + conta1.getId() + " para a conta:" + conta2.getId());



        }else{

            System.out.println("Você não pode realizar uma transferencia dessa quantia nesta conta");

        }

        System.out.println();

    }




    public static String IdCheck(ArrayList<Cliente> contas, String id) {

        Random rand = new Random();

        boolean idExistente = true;



        while (idExistente) {

            idExistente = false;



            for (Cliente c : contas) {

                if (c.getId().equals(id)) {

                    id = String.valueOf(rand.nextInt(99, 1000));

                    idExistente = true;

                    break;

                }

            }

        }

        return id;

    }



    public static Boolean AnalisaContas(ArrayList<Cliente> contas, String nome, String email, String cpf) {

        boolean contaExiste = false;

        for (int i = 0; i < contas.size(); i++) {

            for (Cliente c : contas) {

                if (c.getNome().equals(nome) || c.getEmail().equals(email) || c.getCpf().equals(cpf)) {

                    if (c.getNome().equals(nome)) {

                        System.out.println("Já existe uma conta no nome desta pessoa e E-mail");

                        contaExiste = true;

                    } else if (c.getEmail().equals(email)) {

                        System.out.println("Já existe uma conta com este E-mail");

                        contaExiste = true;

                    } else if (c.getCpf().equals(cpf)) {

                        System.out.println("Já existe uma conta com este CPF");

                        contaExiste = true;

                    } else {

                        contaExiste = true;

                    }

                } else if(c.getNome().equals(nome) && c.getEmail().equals(email) && c.getCpf().equals(cpf)){

                    System.out.println("Já existe uma conta com esses dados");

                }

            }

        }

        System.out.println();

        return contaExiste;

    }



    public static void ListarContas(ArrayList<Cliente> contas){

        for (int i = 0; i < contas.size(); i++){

            System.out.println(contas.get(i).toString());

            System.out.println();

        }

    }

}