/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.request;

/**
 *
 * @author Desenvolvimento
 */
public class CartaoRequest {
    
    private String nomeCartao;
    private String ccv;
    private String bandeira;
    private String mesValidade;
    private String anoValidade;
    private String numeroCartao;
    
    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getMesValidade() {
        return mesValidade;
    }

    public void setMesValidade(String mesValidade) {
        this.mesValidade = mesValidade;
    }

    public String getAnoValidade() {
        return anoValidade;
    }

    public void setAnoValidade(String anoValidade) {
        this.anoValidade = anoValidade;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
    
    
    
}
