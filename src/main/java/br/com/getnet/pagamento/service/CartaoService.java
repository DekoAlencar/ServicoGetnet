/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.service;

import br.com.getnet.pagamento.entidade.Cartao;
import br.com.getnet.pagamento.repositorio.CartaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {
    
    @Autowired
    CartaoRepository repositorio;
    
    public Cartao salvar(Cartao cartao){
       return repositorio.save(cartao);
    }
    
    public Cartao get(int id){
        return repositorio.findById(id);
    }
    
    public void remover(Cartao cartao){
        repositorio.delete(cartao);
    }
    
    public List<Cartao> getAll(){
        return repositorio.findAll();
    }
    
    public Cartao preencherCartaoSalvar(String numero, String nome){
        return preencherCartaoSalvar(numero, nome, null);
    }
    
    public Cartao preencherCartaoSalvar(String numero, String nome, String cvv){
        Cartao cartao = new Cartao();
        cartao.setNumero(numero);
        cartao.setNome(nome);
        cartao.setCvv(cvv);
        return salvar(cartao);
    }
}
