/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.client.dto;

import br.com.getnet.pagamento.util.EnumStatusPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ResumoFinanceiro {
    
    private Double total;
    private String situcao;
    private String tipo;

    public ResumoFinanceiro(Double total, String sitaucao, String tipo) {
        this.total = total;
        this.situcao = EnumStatusPagamento.retonarEnumSelecionado(sitaucao).getDescricao();
        this.tipo = tipo;
    }
    
    
}
