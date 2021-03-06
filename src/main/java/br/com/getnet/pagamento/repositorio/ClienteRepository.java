/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.repositorio;

import br.com.getnet.pagamento.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
    Cliente findById(int id);
    
    @Query("select c from Cliente c where c.documento=?1")
    Cliente findByDocumento(String documento);
}
