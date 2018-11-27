package com.company;
import java.lang.String;

public class Funcionario
{
    static int gid = 0;
    private int id;
    private String nome;
    private String endereco;
    private int tiponum;
    private String tipostr;
    private int diaw = 0;
    private double horw = 0;
    private double hj = 0;
    private int paymentype; //1- semanalmente(1, 8, 15, 22, 29) , 2- bi semanalmente(8, 22), 3- fim do mes(31)
    private int[] paymentdays = new int[5];
    private Salario salario;


    public static int getGid() { return gid; }
    public static void setGid(int gid) { Funcionario.gid = gid; }

    public Salario getSalario() { return salario; }
    public void setSalario(Salario salario) { this.salario = salario; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public int getTiponum() { return tiponum; }
    public void setTiponum(int tiponum) { this.tiponum = tiponum; }

    public String getTipostr() { return tipostr; }
    public void setTipostr(String tipostr) { this.tipostr = tipostr; }

    public int getDiaw() { return diaw; }
    public void setDiaw(int diaw) { this.diaw = diaw; }

    public double getHorw() { return horw; }
    public void setHorw(double horw) { this.horw = horw; }

    public double getHj() { return hj; }
    public void setHj(double hj) { this.hj = hj; }

    public int getPaymentype() { return paymentype; }
    public void setPaymentype(int paymentype) { this.paymentype = paymentype; }

    public int[] getPaymentdays() { return paymentdays; }
    public void setPaymentdays(int[] paymentdays) { this.paymentdays = paymentdays; }
}
