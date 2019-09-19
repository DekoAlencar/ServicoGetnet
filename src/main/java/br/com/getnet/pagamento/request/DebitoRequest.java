/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.request;

import lombok.Data;

@Data
public class DebitoRequest {
    private CartaoRequest cartao;
    private String md;
    private String pareq;
    private String pares;

    
}
