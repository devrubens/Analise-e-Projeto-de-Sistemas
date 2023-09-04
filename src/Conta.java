public class Conta {

    private int idConta;
    private Cliente cliente;
    private double saldo;
    private String numeroConta;
    private String agencia;

    public Conta(Cliente cliente, double saldo, String numeroConta, String agencia) {
        this.idConta = Conta.incrementarId();
        this.cliente = cliente;
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
    }

    public static int incrementarId() {
        return Conta.contadorId++;
    }
    
    public int getContaId() {
        return idConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(Conta destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conta [ID: " + idConta + ", Cliente: " + cliente.getNome() + ", Saldo: " + saldo + ", Número da Conta: " + numeroConta + ", Agência: " + agencia + "]";
    }
}
