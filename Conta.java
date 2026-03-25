public class Conta {
    private final String nome;
    private double saldo;
    private final int numeroConta;
    private final int senha;

    public Conta(String nome, double saldo, int numeroConta, int senha) {
        this.nome = nome;
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.senha = senha;
    }

    public boolean depositar(double valor) {
        if (valor <= 0) {
            return false;
        } else {
            this.saldo = this.saldo + valor;
            return true;
        }
    }

    public boolean sacar(double valor2) {
        if (this.saldo >= valor2){
            this.saldo = this.saldo - valor2;
            return true;
        } else {
            return false;
        }
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
        return this.senha == senhaDigitada;
    }
    public boolean fazerTransferencia(int senhaDigitada) {
        return this.senha == senhaDigitada;
    }
}
