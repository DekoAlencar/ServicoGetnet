/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.request;

import lombok.Data;

@Data
public class SistemaRequest {
    
    private Integer id;
    private String nome;
    private String token;
    private String urlAtualizacao;
}
