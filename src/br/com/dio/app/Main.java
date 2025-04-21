package br.com.dio.app;

import br.com.dio.model.Cliente;
import br.com.dio.model.Conta;
import br.com.dio.model.ContaCorrente;
import br.com.dio.model.ContaPoupanca;
import br.com.dio.exception.SaldoInsuficienteException;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
        Cliente cliente = new Cliente();
        cliente.setNome(nomeCliente);

        Conta contaCorrente = new ContaCorrente(cliente);
        Conta contaPoupanca = new ContaPoupanca(cliente);

        boolean continuar = true;

        while (continuar) {
            String menu = """
                    Escolha uma opção:
                    1 - Depositar
                    2 - Sacar
                    3 - Transferir
                    4 - Ver Extratos
                    0 - Sair
                    """;

            String opcaoStr = JOptionPane.showInputDialog(menu);

            if (opcaoStr == null) break; // usuário apertou "cancelar"

            try {
                int opcao = Integer.parseInt(opcaoStr);

                switch (opcao) {
                    case 1 -> {
                        String tipoConta = JOptionPane.showInputDialog("Depositar em qual conta? (1 - Corrente | 2 - Poupança):");
                        double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do depósito:"));
                        if ("1".equals(tipoConta)) {
                            contaCorrente.depositar(valor);
                            JOptionPane.showMessageDialog(null, "Depósito realizado na Conta Corrente!");
                        } else {
                            contaPoupanca.depositar(valor);
                            JOptionPane.showMessageDialog(null, "Depósito realizado na Conta Poupança!");
                        }
                    }
                    case 2 -> {
                        String tipoConta = JOptionPane.showInputDialog("Sacar de qual conta? (1 - Corrente | 2 - Poupança):");
                        double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do saque:"));
                        Conta contaSelecionada = "1".equals(tipoConta) ? contaCorrente : contaPoupanca;
                        contaSelecionada.sacar(valor);
                        JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
                    }
                    case 3 -> {
                        String direcao = JOptionPane.showInputDialog("Transferir de Corrente para Poupança? (s/n):");
                        double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferência:"));
                        if (direcao.equalsIgnoreCase("s")) {
                            contaCorrente.transferir(valor, contaPoupanca);
                            JOptionPane.showMessageDialog(null, "Transferência feita da Corrente para Poupança.");
                        } else {
                            contaPoupanca.transferir(valor, contaCorrente);
                            JOptionPane.showMessageDialog(null, "Transferência feita da Poupança para Corrente.");
                        }
                    }
                    case 4 -> {
                        String extratoCC = String.format("""
                                === Extrato Conta Corrente ===
                                Titular: %s
                                Agência: %d
                                Número: %d
                                Saldo: R$ %.2f
                                """, cliente.getNome(), contaCorrente.getAgencia(), contaCorrente.getNumero(), contaCorrente.getSaldo());

                        String extratoCP = String.format("""
                                === Extrato Conta Poupança ===
                                Titular: %s
                                Agência: %d
                                Número: %d
                                Saldo: R$ %.2f
                                """, cliente.getNome(), contaPoupanca.getAgencia(), contaPoupanca.getNumero(), contaPoupanca.getSaldo());

                        JOptionPane.showMessageDialog(null, extratoCC + "\n\n" + extratoCP);
                    }
                    case 0 -> {
                        continuar = false;
                        JOptionPane.showMessageDialog(null, "Obrigado por usar o Banco Digital!");
                    }
                    default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida! Digite um número.");
            } catch (SaldoInsuficienteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
