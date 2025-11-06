package com;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        BancoDados banco = new BancoDados();
        List<Cliente> clientes = banco.getClientes();

        Simulador simulador = new Simulador();

        System.out.println("=== Simulação FIFO ===");
        simulador.simulate(clientes, "FIFO");

        System.out.println("\n=== Simulação Prioridade ===");
        simulador.simulate(clientes, "PRIORITY");
    }
}