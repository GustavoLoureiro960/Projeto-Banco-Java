package Projeto_Banco_Java;

public class Cliente {



    private String id;



    private String nome;

    private String email;

    private String cpf;



    private String dataDeNascimento;

    private String dataDeCadastro;



    private Double saldo;



    private Double limiteSaque;



    public Cliente(String id, String nome, String email, String cpf,

                   String dataDeNascimento, String dataCadastro, Double saldo, Double limiteSaque) {



        this.nome = nome;

        this.email = email;

        this.cpf = cpf;

        this.dataDeNascimento = dataDeNascimento;

        this.dataDeCadastro = dataCadastro;

        this.saldo = saldo;

        this.limiteSaque = limiteSaque;

        this.id = id;

    }



    public String getId(){

        return id;

    }



    public void setId(String id){

        this.id = id;

    }



    public String getNome(){

        return nome;

    }



    public void setNome(String nome){

        this.nome = nome;

    }

    public String getEmail(){

        return email;

    }



    public void setEmail(String email){

        this.email = email;

    }



    public String getCpf(){

        return cpf;

    }



    public void setCpf(String cpf){

        this.cpf = cpf;

    }



    public String getDataDeNascimento(){

        return dataDeNascimento;

    }



    public void setDataDeNascimento(String dataDeNascimento){

        this.dataDeNascimento = dataDeNascimento;

    }



    public String getDataDeCadastro(){

        return dataDeCadastro;

    }



    public void setDataDeCadastro(String dataDeCadastro){

        this.dataDeCadastro = dataDeCadastro;

    }



    public Double getSaldo(){

        return saldo;

    }



    public void setSaldo(Double saldo){

        this.saldo = saldo;

    }



    public Double getLimiteSaque(){return limiteSaque;}



    public void setLimiteSaque(Double limiteSaque){this.limiteSaque = limiteSaque;}



    @Override

    public String toString(){

        return "Conta: " + id +

                "\nNome: " + nome +

                "\nEmail: " + email +

                "\nCPF: " + cpf +

                "\nData de Nascimento: " +  dataDeNascimento +

                "\nData de Cadastro: " + dataDeCadastro +

                "\nSaldo: R$: " + saldo +

                "\nLimite de Saque R$: " + limiteSaque;

    }



}