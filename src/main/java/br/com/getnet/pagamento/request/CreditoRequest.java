/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.request;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 *
 * @author Desenvolvimento
 */
public class CreditoRequest {
    
    private Boolean confirmacaoTardia;
    private Boolean autenticado;
    private Boolean preAutenticado;
    private Boolean salvarCartao;
    private String tipoTransacao;
    private Double parcela;
    private String descricao;
    
    private CartaoRequest cartao;

    public Boolean getConfirmacaoTardia() {
        return confirmacaoTardia;
    }

    public void setConfirmacaoTardia(Boolean confirmacaoTardia) {
        this.confirmacaoTardia = confirmacaoTardia;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }

    public Boolean getPreAutenticado() {
        return preAutenticado;
    }

    public void setPreAutenticado(Boolean preAutenticado) {
        this.preAutenticado = preAutenticado;
    }

    public Boolean getSalvarCartao() {
        return salvarCartao;
    }

    public void setSalvarCartao(Boolean salvarCartao) {
        this.salvarCartao = salvarCartao;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public BigDecimal getParcela() {
        return new BigDecimal(parcela, MathContext.UNLIMITED);
    }

    public void setParcela(Double parcela) {
        this.parcela = parcela;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CartaoRequest getCartao() {
        return cartao;
    }

    public void setCartao(CartaoRequest cartao) {
        this.cartao = cartao;
    }
      
    
}
