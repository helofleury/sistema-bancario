package br.com.dio.model;

import br.com.dio.interfaces.IConta;
import br.com.dio.model.Cliente;
import br.com.dio.exception.SaldoInsuficienteException;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para transferência.");
        }
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s%n", cliente.getNome());
        System.out.printf("Agência: %d%n", agencia);
        System.out.printf("Número: %d%n", numero);
        System.out.printf("Saldo: %.2f%n", saldo);
    }
}
