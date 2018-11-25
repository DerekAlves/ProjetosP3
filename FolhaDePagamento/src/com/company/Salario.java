package com.company;

public class Salario
{
    private double salhor;
    private double salmen;
    private double comis;
    private double vendas = 0;
    private double taxas = 0;
    private double saltot = 0;

    public double getSalhor() { return salhor; }
    public void setSalhor(double salhor) { this.salhor = salhor; }

    public double getSalmen() { return salmen; }
    public void setSalmen(double salmen) { this.salmen = salmen; }

    public double getComis() { return comis; }
    public void setComis(double comis) { this.comis = comis; }

    public double getVendas() { return vendas; }
    public void setVendas(double vendas) { this.vendas = vendas; }

    public double getTaxas() { return taxas; }
    public void setTaxas(double taxas) { this.taxas = taxas; }

    public double getSaltot() { return saltot; }
    public void setSaltot(double saltot) { this.saltot = saltot; }

}
