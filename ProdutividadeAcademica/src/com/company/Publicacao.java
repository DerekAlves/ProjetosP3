package com.company;

//título, nome da conferência onde foi publicada, ano de publicação e projeto
//de pesquisa associado (se houver).

public class Publicacao
{
    private String titulo;
    private String nomeconf;
    private Data publicacao;
    private Projeto ppassociado;

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getNomeconf() { return nomeconf; }
    public void setNomeconf(String nomeconf) { this.nomeconf = nomeconf; }

    public Data getPublicacao() { return publicacao; }
    public void setPublicacao(Data publicacao) { this.publicacao = publicacao; }

    public Projeto getPpassociado() { return ppassociado; }
    public void setPpassociado(Projeto ppassociado) { this.ppassociado = ppassociado; }
}
