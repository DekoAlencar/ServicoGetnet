/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "BOLETO")
@Data
public class Boleto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @JoinColumn(name = "ID_TRANSACAO", referencedColumnName = "ID")
    @OneToOne
    private Transacao idTransacao;
    
    @Column(name = "ÌD_BOLETO")
    private String idBoleto;
    
    @Column(name = "CODIGO_BANCO")
    private String codigoBanco;
    
    @Column(name = "SITAUCAO")
    private String sitaucao;
    
    @Column(name = "CODIGO_SITUACAO")
    private Integer codigoSituacao;
    
    @Column(name = "DATA_VENCIMENTO")
    private Date dataVencimento;
    
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    
    @Column(name = "CODIGO_BARRA")
    private String codigoBarra;
    
    @Column(name = "LINHA_DIGITAVEL")
    private String linhaDigitavel;
    
    @Column(name = "NOME")
    private String nome;
    
    @Column(name = "URL_BOLETO")
    private String urlBoleto;

}
