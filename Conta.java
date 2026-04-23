import java.util.ArrayList;

public class Conta {
    private final String nome;
    private double saldo;
    private final int numeroConta;
    private final int senha;
    private ArrayList<String> extrato;

    public Conta(String nome, double saldo, int numeroConta, int senha) {
        this.nome = nome;
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.senha = senha;
        this.extrato = new ArrayList<>();
    }

    public boolean depositar(double valor) {
        if (valor <= 0) {
            return false;
        } else {
            this.saldo = this.saldo + valor;
            adicionarExtrato("Depósito: +" + valor);
            return true;
        }
    }

    public boolean sacar(double valor2) {
        if (valor2 <= 0) {
            return false;
        }
        if (this.saldo >= valor2){
            this.saldo = this.saldo - valor2;
            adicionarExtrato("Saque: -" + valor2);
            return true;
        }
        return false;
    }

    public double verSaldo() {
        return this.saldo;
    }

    public String toString() {
        return ("Nome: " + this.nome +
                "\nNúmero da Conta: " +
                this.numeroConta + "\nSaldo: " +
                this.saldo);
    }

    public int getNumeroConta() {
        return this.numeroConta;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean verificarSenha(int senhaDigitada) {
        return this.senha ==
                senhaDigitada;
    }

    public void adicionarExtrato(String descricao) {
        extrato.add(descricao);
    }
    public void mostrarExtrato() {
        for (String descricao : extrato) {
            System.out.println(descricao);
        }
    }
    public boolean transferirPara(Conta contaRecebe, double valor) {
        if (valor <= 0 || this.saldo < valor) {
            System.out.println("Saldo insuficiente");
            return false;
        }
        this.saldo -= valor;
        contaRecebe.saldo += valor;
        adicionarExtrato("Transferência enviada para: " + contaRecebe.getNome() + " no valor de: -" + valor);
        contaRecebe.adicionarExtrato("Transferência recebida de: " + this.nome + " no valor de: +" + valor);
        return true;
    }
}
