package com.devsuperior.pedido.entities;

import java.math.BigDecimal;

public class Pedido {

    private Integer codigo;

    private Double valorBasico;

    private Double porcentagemDesconto;


    public Pedido(Integer codigo, Double valorBasico, Double porcentagemDesconto) {
        this.codigo = codigo;
        this.valorBasico = valorBasico;
        this.porcentagemDesconto = porcentagemDesconto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Double getValorBasico() {
        return valorBasico;
    }

    public void setValorBasico(Double valorBasico) {
        this.valorBasico = valorBasico;
    }

    public Double getPorcentagemDesconto() {
        return porcentagemDesconto;
    }

    public void setPorcentagemDesconto(Double porcentagemDesconto) {
        this.porcentagemDesconto = porcentagemDesconto;
    }
}
