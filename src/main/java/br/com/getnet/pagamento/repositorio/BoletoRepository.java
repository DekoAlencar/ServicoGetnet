/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.repositorio;

import br.com.getnet.pagamento.entidade.Boleto;
import br.com.getnet.pagamento.entidade.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoletoRepository extends JpaRepository<Boleto, Integer>{
    
    Boleto findById(int id);
    
    @Query("select b from Boleto b join Transacao t on t.id = b.idTransacao where t.idPagamento = ?1")
    Boleto findByIdPagamento(String idPagamento);
    
    @Query("select b from Boleto b where b.idTransacao = ?1")
    Boleto findByIdTransacao(Transacao transacao);
}
