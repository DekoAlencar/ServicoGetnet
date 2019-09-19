/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.repositorio;

import br.com.getnet.pagamento.entidade.Sistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface SistemaRepository extends JpaRepository<Sistema, Integer>{
    
    Sistema findById(int id);
    
    @Query("select s from Sistema s where s.token = ?1")
    Sistema findByToken(String token);
}
