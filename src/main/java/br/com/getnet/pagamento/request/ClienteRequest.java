/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.request;

import lombok.Data;

@Data
public class ClienteRequest {
    
    private String idCliente;
    private String primeiroNome;
    private String ultimoNome;
    private String nomeCompleto;
    private String email;
    private String tipoDocumento;
    private String numeroDocumento;
    private String telefone;
    private EnderecoRequest endereco;

}
