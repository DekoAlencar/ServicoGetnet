/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.util;


public enum EnumTipoTransacao {
    DEBITO("D", "Debito"),
    CREDITO("C", "Credito"),
    BOLETO("B", "Boleto");
    
    public String tipo;
    public String descricao;

    private EnumTipoTransacao(String tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public static EnumTipoTransacao retornarEnumSelecionado(String enun){
        for (EnumTipoTransacao enumn : EnumTipoTransacao.values()) {
            if(enumn.equals(enun)){
                return enumn;
            }
        }
        return null;    
    }
}
