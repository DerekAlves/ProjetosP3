package com.company;

import java.util.ArrayList;

public class Comunidade
{
    private String nome;
    private String descricao;
    private String adm;
    private ArrayList<Usuario> membros = new ArrayList<Usuario>();

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getAdm() { return adm; }
    public void setAdm(String adm) { this.adm = adm; }

    public ArrayList<Usuario> getMembros() { return membros; }
    public void setMembros(ArrayList<Usuario> membros) { this.membros = membros; }
}
