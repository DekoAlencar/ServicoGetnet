/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.request;

import lombok.Data;

@Data
public class PagamentoRequest {
    private Integer idSistema;
    private String idPagamento;
    private String certificadoAutenticacao;
    private Double valor;
    private String moeda;
    private CompraRequest compra;
    private ClienteRequest cliente;
    private DispositivoRequest dispositivo;
    private CreditoRequest credito;
    private DebitoRequest debito;
    private BoletoRequest boleto;   
    
}
