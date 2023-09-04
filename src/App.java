import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Banco banco = new Banco();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Criar Conta");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Mostrar Saldo");
            System.out.println("7. Sair");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Digite o nome do cliente:");
                    String clientName = scanner.next();
                    System.out.println("Digite o CPF do cliente:");
                    String clientCpf = scanner.next();
                    banco.criarCliente(clientName, clientCpf);
                    break;
                case 2:
                    System.out.println("Digite o ID do cliente:");
                    int clientId = scanner.nextInt();
                    System.out.println("Digite o saldo inicial:");
                    double initialBalance = scanner.nextDouble();
                    System.out.println("Digite o número da conta:");
                    String accountNumber = scanner.next();
                    System.out.println("Digite o número da agência:");
                    String agency = scanner.next();
                    banco.criarConta(clientId, initialBalance, accountNumber, agency);
                    break;
                case 3:
                    System.out.println("Digite o ID da conta:");
                    int depositAccountId = scanner.nextInt();
                    System.out.println("Digite o valor a ser depositado:");
                    double depositAmount = scanner.nextDouble();
                    banco.depositar(depositAccountId, depositAmount);
                    break;
                case 4:
                    System.out.println("Digite o ID da conta:");
                    int withdrawAccountId = scanner.nextInt();
                    System.out.println("Digite o valor a ser sacado:");
                    double withdrawAmount = scanner.nextDouble();
                    banco.sacar(withdrawAccountId, withdrawAmount);
                    break;
                case 5:
                    System.out.println("Digite o ID da conta de origem:");
                    int sourceAccountId = scanner.nextInt();
                    System.out.println("Digite o ID da conta de destino:");
                    int targetAccountId = scanner.nextInt();
                    System.out.println("Digite o valor a ser transferido:");
                    double transferAmount = scanner.nextDouble();
                    banco.transferir(sourceAccountId, targetAccountId, transferAmount);
                    break;
                case 6:
                    System.out.println("Digite o ID da conta:");
                    int balanceAccountId = scanner.nextInt();
                    banco.mostrarSaldo(balanceAccountId);
                    break;
                case 7:
                    scanner.close();
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}