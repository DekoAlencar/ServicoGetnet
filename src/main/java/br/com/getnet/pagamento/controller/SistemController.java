/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.controller;

import br.com.getnet.pagamento.client.JSON;
import br.com.getnet.pagamento.entidade.Sistema;
import br.com.getnet.pagamento.request.SistemaRequest;
import br.com.getnet.pagamento.service.SistemaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="v1/public/sistema")
public class SistemController {
    
    @Autowired
    private SistemaService service;
    
    @GetMapping
    public Object buscarSistema(){
        return JSON.createGson().create().toJson(service.getAll());
    }
    
    @PutMapping
    public Object cadastrar(@RequestBody SistemaRequest request){
        return JSON.createGson().create().toJson(service.cadastro(request));
    }
    
    @DeleteMapping
    private void delete(@RequestBody SistemaRequest request){
        service.deletar(request.getId());
    }
    
    @PostMapping
    public Object atulizar(@RequestBody SistemaRequest request){
        return JSON.createGson().create().toJson(service.atualizar(request));
    }
}
