package Yourfirstaccount;

public class Account{
    private String descricao;
    private double saldo;

    public Account(String descricao, double saldo) {
        this.descricao = descricao;
        this.saldo = saldo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void withdraw(double valor){
        if(saldo >= valor)
            this.saldo -= valor;
        else
            System.out.println("Saldo insuficiente");
    }

    public void deposit(double valor){
        this.saldo += valor;
    }

    public double saldo(){
        return saldo;
    }

    @Override
    public String toString(){
        return descricao + "\n" + "Saldo: " + saldo;
    }
}
