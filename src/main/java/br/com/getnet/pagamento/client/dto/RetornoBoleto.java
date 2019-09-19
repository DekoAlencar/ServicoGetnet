/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.client.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RetornoBoleto {
    private String idBoleto;
    private String codigoBanco;
    private String codigoBarra;
    private String linhaDigitavel;
    private Date dataVenciamento;
    private String situacao;
    private String urlBoleto;
    
}
