/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.repositorio;

import br.com.getnet.pagamento.client.dto.ResumoFinanceiro;
import br.com.getnet.pagamento.entidade.RelatorioAnalitico;
import br.com.getnet.pagamento.entidade.Sistema;
import br.com.getnet.pagamento.entidade.Transacao;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{
    
    Transacao findById(int id);
    
    @Query("select t from Transacao t where t.md = ?1")
    Transacao findByMD(String md);
    
    @Query("select t from Transacao t where t.idPagamento = ?1")
    Transacao findByIdPagamento(String idPagamento);
    
    @Query("Select new br.com.villefortconsulting.pagamento.client.dto.ResumoFinanceiro(sum(t.valor), t.status, t.tipoTransacao) "
            + "from Transacao t where t.dataSolicitacao between ?1 and ?2 GROUP BY t.status, t.tipoTransacao")
    List<ResumoFinanceiro> resumoFinanceiroByPeriodo(Date dataInicio, Date dataFinal);
        
    @Query("select t from Transacao t where t.idSistema=?1")
    List<Transacao> findAllByIdSistema(Sistema sistema);
    
    @Query("Select t from Transacao t where t.tipoTransacao=?1")
    List<Transacao> findAllByTipo(String tipoTransacao);
    
    @Query("Select t from Transacao t where t.dataSolicitacao > ?1 and dataFinal <= ?2")
    List<Transacao> findAllByPeriodo(Date solicitacao, Date finalizacao);
    
    @Query("select t from Transacao t order by t.dataSolicitacao desc")
    List<Transacao> findAllOrder();
   
    @Query("select ra from RelatorioAnalitico ra where ra.data between ?1 and ?2")
    List<RelatorioAnalitico> relatorioAnalitico(Date inicio, Date fim);
}
