package com.company;

//colaboradores: alunos de graduação, alunos
//de mestrado, alunos de doutorado, professores e pesquisadores.

import java.util.ArrayList;

public class Colaborador
{
    static int gid = 0;
    private int id;
    private String nome;
    private String email;
    private int tipo;//1 - alunog, 2 - alunom, 3 - alunod, 4 - professores, 5 - pesquisadores.
    private String tipostr;
    private boolean partdeprojeto = false;
    private ArrayList<Projeto> projetos;

    public static int getGid() { return gid; }
    public static void setGid(int gid) { Colaborador.gid = gid; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getTipo() { return tipo; }
    public void setTipo(int tipo) { this.tipo = tipo; }

    public String getTipostr() { return tipostr; }
    public void setTipostr(String tipostr) { this.tipostr = tipostr; }

    public boolean isPartdeprojeto() { return partdeprojeto; }
    public void setPartdeprojeto(boolean partdeprojeto) { this.partdeprojeto = partdeprojeto; }
}
