import java.util.ArrayList;
import java.util.Scanner;

public class BancoExpress {

    static class Conta {
        private double saldo;
        private ArrayList<String> extrato;

        public Conta() {
            saldo = 0.0;
            extrato = new ArrayList<>();
        }

        public void depositar(double valor) {
            if (valor > 0) {
                saldo += valor;
                extrato.add("Depósito: +" + valor);
                System.out.println("Depósito realizado com sucesso!");
            } else {
                System.out.println("Valor inválido para depósito!");
            }
        }

        public void sacar(double valor) {
            if (valor > 0 && valor <= saldo) {
                saldo -= valor;
                extrato.add("Saque: -" + valor);
                System.out.println("Saque realizado com sucesso!");
            } else {
                System.out.println("Saldo insuficiente. Operação inválida!");
            }
        }

        public void pagarBoleto(double valor) {
            if (valor > 0 && valor <= saldo) {
                saldo -= valor;
                extrato.add("Pagamento do boleto: -" + valor);
                System.out.println("Boleto pago com sucesso!");
            } else {
                System.out.println("Operação não sucedida!");
            }
        }

        public void consultarSaldo() {
            System.out.println("Saldo atual: " + saldo);
        }

        public void consultarExtrato() {
            System.out.println("====== Extrato bancário ======");
            for (String movimento : extrato) {
                System.out.println(movimento);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conta conta = new Conta(); // Instancia a conta
        int opcao;

        do {
            System.out.println("\n=== Banco Expresso ===");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Pagar boleto");
            System.out.println("4. Consultar saldo");
            System.out.println("5. Consultar extrato");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor para depositar: ");
                    double valorDeposito = sc.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Valor para sacar: ");
                    double valorSaque = sc.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    System.out.print("Valor do boleto: ");
                    double valorBoleto = sc.nextDouble();
                    conta.pagarBoleto(valorBoleto);
                    break;
                case 4:
                    conta.consultarSaldo();
                    break;
                case 5:
                    conta.consultarExtrato();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0); // Repete até o usuário escolher sair (opção 0)

        sc.close(); // Fecha o scanner
    }
}