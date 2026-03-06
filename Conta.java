class Conta {
    String nome;
    double saldo;
    int numeroConta;

    public Conta(String nome, double saldo, int numeroConta) {
        this.nome = nome;
        this.saldo = saldo;
        this.numeroConta = numeroConta;
    }

    boolean depositar(double valor) {
        if (valor <= 0) {
            return false;
        } else {
            this.saldo = this.saldo + valor;
            return true;
        }
    }

    boolean sacar(double valor2) {
        if (this.saldo >= valor2){
            this.saldo = this.saldo - valor2;
            return true;
        } else {
            return false;
        }
    }
    double verSaldo() {
        return this.saldo;
    }
    public String toString() {
        return ("Nome: " + this.nome +
                "\nNúmero da Conta: " +
                this.numeroConta + "\nSaldo: " +
                this.saldo);
    }
}

