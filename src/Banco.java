import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<Cliente> clientes;
    private List<Conta> contas;

    public Banco() {
        clientes = new ArrayList<>();
        contas = new ArrayList<>();
    }

    public void criarCliente(String nome, String cpf) {
        Cliente cliente = new Cliente(nome, cpf);
        clientes.add(cliente);
        System.out.println("Cliente criado: " + cliente);
    }

    public void criarConta(int idCliente, double saldoInicial, String numeroConta, String agencia) {
        Cliente cliente = encontrarCliente(idCliente);
        if (cliente != null) {
            Conta conta = new Conta(cliente, saldoInicial, numeroConta, agencia);
            contas.add(conta);
            System.out.println("Conta criada: " + conta);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void depositar(int idConta, double valor) {
        Conta conta = encontrarConta(idConta);
        if (conta != null) {
            conta.depositar(valor);
            System.out.println("Depósito realizado. Novo saldo: " + conta.getSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void sacar(int idConta, double valor) {
        Conta conta = encontrarConta(idConta);
        if (conta != null) {
            conta.sacar(valor);
            System.out.println("Saque realizado. Novo saldo: " + conta.getSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void transferir(int idContaOrigem, int idContaDestino, double valor) {
        Conta contaOrigem = encontrarConta(idContaOrigem);
        Conta contaDestino = encontrarConta(idContaDestino);
        if (contaOrigem != null && contaDestino != null) {
            contaOrigem.transferir(contaDestino, valor);
            System.out.println("Transferência realizada.");
            System.out.println("Saldo da conta de origem: " + contaOrigem.getSaldo());
            System.out.println("Saldo da conta de destino: " + contaDestino.getSaldo());
        } else {
            System.out.println("Uma ou ambas as contas não encontradas.");
        }
    }

    public void mostrarSaldo(int idConta) {
        Conta conta = encontrarConta(idConta);
        if (conta != null) {
            System.out.println("Saldo da conta: " + conta.getSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private Cliente encontrarCliente(int idCliente) {
        return clientes.stream()
                .filter(cliente -> cliente.getIdCliente() == idCliente)
                .findFirst()
                .orElse(null);
    }

    private Conta encontrarConta(int idConta) {
        return contas.stream()
                .filter(conta -> conta.getContaId() == idConta)
                .findFirst()
                .orElse(null);
    }
}