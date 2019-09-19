/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.client.dto;

import lombok.Data;

@Data
public class RetornoTransacao{
    private String idPagamento;
    private String status;
    private String idAutorizacao;
    private String dataPagamento;
    private String mensagem;
    private String md;
    private String linkEmissor;
    private String certEmissor;
    private RetornoBoleto boleto;
}
