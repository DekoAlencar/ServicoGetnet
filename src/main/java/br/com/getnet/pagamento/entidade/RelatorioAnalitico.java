/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "RELATORIO_ANALITICO")
@Data
public class RelatorioAnalitico implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id  
    private Double  total;
    private String data;
    private String situacao;
    
}
