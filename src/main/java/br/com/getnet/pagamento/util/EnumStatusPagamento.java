/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.util;


public enum EnumStatusPagamento {
    
    APROVADO("A", "Aprovado", "APPROVED"),
    NEGADO("N", "Negado", "DENIED"),
    PENDENTE("P", "Pendente", "PENDING"),
    CANCELADO("C", "Cancelado", "CANCEL"),
    CANCELAMENTO_SOLICITADO("SC", "Solicitacao de Cancelamento", "CANCELAMENTO SOLICITACAO");
    
    public String status;
    
    public String descricao;
    
    public String relacao;

    EnumStatusPagamento(String status, String descricao, String relacao) {
        this.status = status;
        this.descricao = descricao;
        this.relacao = relacao;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getRelacao(){
        return relacao;
    }
    
    public void setRelacao(String relacao){
        this.relacao = relacao;
    }
    
    public static EnumStatusPagamento retonarEnumSelecionado(String enumStatus){
        for(EnumStatusPagamento enun: EnumStatusPagamento.values()){
            if(enun.getStatus().equals(enumStatus)){
                return enun; 
            }
        }
        return null;
    }
    
    public static EnumStatusPagamento retonarEnumPorRelacao(String relacao){
        for(EnumStatusPagamento enun: EnumStatusPagamento.values()){
            if(enun.getRelacao().equalsIgnoreCase(relacao)){
                return enun;
            }
        }
        return null;
    }
    
    public static EnumStatusPagamento retonarEnumPorDescricao(String descricao){
        for(EnumStatusPagamento enun: EnumStatusPagamento.values()){
            if(enun.getDescricao().equalsIgnoreCase(descricao)){
                return enun;
            }
        }
        return null;
    }
}
