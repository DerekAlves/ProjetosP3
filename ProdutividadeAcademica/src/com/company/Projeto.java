package com.company;

//Projetos possuem
//as seguintes informações básicas: título, data de início, data de término, agência financiadora,
//valor financiado, objetivo, descrição e participantes. Um projeto de pesquisa deve ter pelo
//menos um professor como participante.

import java.util.ArrayList;

public class Projeto
{
    private String titulo;
    private int status; //1 - elaboração, 2 - em andamento, 3 - concluido.
    private Data inicio;
    private Data termino;
    private String agfinan;
    private double valfinan;
    private String objetivo;
    private String descricao;
    private ArrayList<Colaborador> participantes = new ArrayList<Colaborador>();
    private ArrayList<Publicacao> publicacoes =  new ArrayList<Publicacao>();

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Data getInicio() { return inicio; }
    public void setInicio(Data inicio) { this.inicio = inicio; }

    public Data getTermino() { return termino; }
    public void setTermino(Data termino) { this.termino = termino; }

    public String getAgfinan() { return agfinan; }
    public void setAgfinan(String agfinan) { this.agfinan = agfinan; }

    public double getValfinan() { return valfinan; }
    public void setValfinan(double valfinan) { this.valfinan = valfinan; }

    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public ArrayList<Colaborador> getParticipantes() { return participantes; }
    public void setParticipantes(ArrayList<Colaborador> participantes) { this.participantes = participantes; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public ArrayList<Publicacao> getPublicacoes() { return publicacoes; }
    public void setPublicacoes(ArrayList<Publicacao> publicacoes) { this.publicacoes = publicacoes; }

}
