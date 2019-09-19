/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.repositorio;

import br.com.getnet.pagamento.entidade.RelatorioAnalitico;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioAnaliticoRepository extends CrudRepository<RelatorioAnalitico, Double>{
    
    @Query("select ra from RelatorioAnalitico ra")
    List<RelatorioAnalitico> relatorioAnalitico();
    
}
