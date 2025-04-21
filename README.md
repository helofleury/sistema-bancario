# 🏦 Desafio: Sistema Bancário em Java

Este projeto é uma implementação de um sistema bancário simples desenvolvido em Java como parte de um desafio da Digital Innovation One (DIO). O sistema permite operações básicas de conta bancária através de uma interface gráfica simples com `JOptionPane`.

## 📋 Visão Geral do Projeto

O sistema bancário implementa:

- **Contas Correntes e Poupanças**
- **Operações de depósito, saque e transferência**
- **Visualização de extratos**
- **Tratamento de exceções para saldo insuficiente**

  ## 🏗️ Estrutura do Projeto

O código está organizado em pacotes seguindo boas práticas de desenvolvimento:

```text
br.com.dio
├── app
│   └── Main.java            # Classe principal com interface do usuário
├── exception
│   └── SaldoInsuficienteException.java  # Exceção personalizada
├── interfaces
│   └── IConta.java          # Interface com operações bancárias
├── model
│   ├── Cliente.java         # Modelo de cliente
│   ├── Conta.java           # Classe abstrata de conta
│   ├── ContaCorrente.java   # Implementação de conta corrente
│   └── ContaPoupanca.java   # Implementação de conta poupança
└── service
    └── Banco.java           # Classe para gerenciamento do banco (não implementada)
```

 ## 🎯 Funcionalidades Implementadas

💰 Operações Bancárias
Depósito: Permite depositar valores em conta corrente ou poupança

- Saque: Realiza saques com verificação de saldo

- Transferência: Transfere valores entre contas corrente e poupança

- Extrato: Exibe informações detalhadas das contas

 ## 🛡️ Tratamento de Exceções
- SaldoInsuficienteException: Lançada quando não há saldo suficiente para operações

- Validação de entradas numéricas

## 🖥️ Interface do Usuário
A interface utiliza JOptionPane para interação com o usuário através de caixas de diálogo:

Menu Principal:
1 - Depositar
2 - Sacar
3 - Transferir
4 - Ver Extratos
0 - Sair

## 🧩 Como Executar
 - Certifique-se de ter o Java JDK instalado.

 - Compile todos os arquivos .java.

 - Execute a classe Main

## 📚 Conceitos Aplicados
- POO: Abstração, encapsulamento, herança, polimorfismo

- Tratamento de exceções

- Interfaces

- Classes abstratas

- Manipulação de entrada/saída
