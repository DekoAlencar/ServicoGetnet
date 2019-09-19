/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.service;

import br.com.getnet.pagamento.entidade.Sistema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.getnet.pagamento.repositorio.SistemaRepository;
import br.com.getnet.pagamento.request.SistemaRequest;
import java.util.List;

@Service
public class SistemaService {
    
    @Autowired
    SistemaRepository repostorio;
    
    public Sistema salvar(Sistema sistema){
        return repostorio.save(sistema);
    }
    
    public Sistema get(int id){
        return repostorio.findById(id);
    }
    
    public List<Sistema> getAll(){
        return repostorio.findAll();
    }
    
    public Sistema cadastro(SistemaRequest request){
        Sistema sistema = preencherSistema(request.getNome(), request.getToken(), request.getUrlAtualizacao());
        
        return salvar(sistema);
    }
    
    public Sistema atualizar(SistemaRequest request){
        Sistema sistema = get(request.getId());
        
        sistema.setNome(request.getNome());
        sistema.setToken(request.getToken());
        sistema.setUrlAtualizacao(request.getUrlAtualizacao());
        
        return salvar(sistema);
    }
    
    public Sistema preencherSistema(String nome, String token, String urlAtualizacao){
        Sistema sistema = new Sistema();
        
        sistema.setNome(nome);
        sistema.setToken(token);
        sistema.setUrlAtualizacao(urlAtualizacao);
        
        return sistema;
    }
   
    public void deletar(Integer id){
        Sistema sistema = get(id);
        repostorio.delete(sistema);
    }
}
