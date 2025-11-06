package com;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Simulador {

    public void simulate(List<Cliente> clientes, String strategy) {
        // Criar cópia da lista para não modificar a original
        List<Cliente> queue = new ArrayList<>(clientes);

        // Ordena de acordo com a estratégia
        if (strategy.equalsIgnoreCase("FIFO")) {
            queue.sort(Comparator.comparing(Cliente::getChegada));
        } else if (strategy.equalsIgnoreCase("PRIORITY")) {
            queue.sort(Comparator.comparingInt(Cliente::getPrioridade).reversed()
                    .thenComparing(Cliente::getChegada));
        } else {
            throw new IllegalArgumentException("Strategy inválida: use FIFO ou PRIORITY");
        }

        LocalDateTime now = LocalDateTime.now();
        double totalWait = 0.0;
        double totalService = 0.0;

        long startTime = System.currentTimeMillis();

        for (Cliente c : queue) {
            if (c.isCancelado()) {
                System.out.println("Cliente " + c.getNome() + " cancelou a consulta.");
                continue;
            }

            if (c.getChegada().isAfter(now)) {
                now = c.getChegada();
            }

            double tempoAtendimento = c.getTempoServico();
            double wait = Duration.between(c.getChegada(), now).toSeconds();
            totalWait += wait;
            totalService += tempoAtendimento;

            System.out.printf("Atendendo %s (p=%d) tempo=%.2fs wait=%.2fs\n",
                    c.getNome(), c.getPrioridade(), tempoAtendimento, wait);

            now = now.plusSeconds((long) tempoAtendimento);
        }

        long execTime = System.currentTimeMillis() - startTime;

        System.out.printf("[%s] n=%d temp_wait=%.2fs total_service=%.2fs tempo_exec=%dms\n",
                strategy.toUpperCase(), queue.size(), totalWait / queue.size(), totalService, execTime);
    }
}
