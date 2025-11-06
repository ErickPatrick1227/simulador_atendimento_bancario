package com;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cliente {
    private int id;
    private String nome;
    private int prioridade;
    private LocalDateTime chegada;
    private double tempoServico;
    private String status;

    public Cliente (int id, String nome, int prioridade, LocalDateTime chegada, double tempoServico, String status) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
        this.chegada = chegada;
        this.tempoServico = tempoServico;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public LocalDateTime getChegada() {
        return chegada;
    }

    public void setChegada(LocalDateTime chegada) {
        this.chegada = chegada;
    }

    public double getTempoServico() {
        return tempoServico;
    }

    public void setTempoServico(double tempoServico) {
        this.tempoServico = tempoServico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCancelado() {
        return false;
    }
}


