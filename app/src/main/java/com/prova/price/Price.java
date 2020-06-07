package com.prova.price;

import java.io.Serializable;

public class Price implements Serializable {

    private Double numeroParcelas;
    private Double prestacao;
    private Double juros;
    private Double amortizacao;
    private Double saldo;

    public Price(Double numeroParcelas, Double prestacao, Double juros, Double amortizacao, Double saldo) {
        this.numeroParcelas = numeroParcelas;
        this.prestacao = prestacao;
        this.juros = juros;
        this.amortizacao = amortizacao;
        this.saldo = saldo;
    }

    public Double getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Double numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public Double getPrestacao() {
        return prestacao;
    }

    public void setPrestacao(Double prestacao) {
        this.prestacao = prestacao;
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    public Double getAmortizacao() {
        return amortizacao;
    }

    public void setAmortizacao(Double amortizacao) {
        this.amortizacao = amortizacao;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
