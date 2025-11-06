package com;

public class Cliente {
    private int id;
    private String nome;
    private int prioridade;
    private String chegada;
    private double tempoServico;
    private String status;

    public Cliente (int id, String nome, int prioridade, String chegada, double tempoServico, String status) {
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

    public String getChegada() {
        return chegada;
    }

    public void setChegada(String chegada) {
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
}


