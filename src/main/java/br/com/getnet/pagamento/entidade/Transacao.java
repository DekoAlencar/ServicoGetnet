/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TRANSACAO")
@Data
public class Transacao implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
    @JoinColumn(name = "ID_SISTEMA", referencedColumnName = "ID")
    @ManyToOne
    private Sistema idSistema;
    
    @JoinColumn(name = "ID_CARTAO", referencedColumnName = "ID")
    @OneToOne
    private Cartao idCartao;
    
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID")
    @ManyToOne
    private Cliente idCliente;
    
    @Column(name = "TIPO_TRANSACAO")
    private String tipoTransacao;
    
    @Column(name = "VALOR")
    private Double valor;
    
    @Column(name = "DATA_SOLICITACAO")
    private Date dataSolicitacao;
    
    @Column(name = "DATA_FINALIZACAO")
    private Date dataFinalizacao;
    
    @Column(name = "STATUS")
    private String status;
    
    @Column(name = "MENSAGEM_ERRO")
    private String mensgaemErro;
    
    @Column(name = "CODIGO_ERRO")
    private String codigoErro;
    
    @Column(name = "ID_AUTORIZACAO")
    private String idAutorizacao;
    
    @Column(name = "ID_PAGAMENTO")
    private String idPagamento;
    
    @Column(name = "CERTIFICADO_EMISSOR")
    private String certificadoEmissor;
    
    @Column(name = "CERTIFICADO_PAGAMENTO")
    private String certificadoPagamento;
    
    @Column(name = "ID_CANCELAMENTO")
    private String idCancelamento;
    
    @Column(name = "MD")
    private String md;
    
    @Column(name = "OBS")
    private String obs;        
    
    @Column(name = "DATA_CANCELAMENTO")
    private Date dataCancelamento;
    
}
