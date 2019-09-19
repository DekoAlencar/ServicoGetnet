/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.controller;

import br.com.getnet.pagamento.client.ApiException;
import br.com.getnet.pagamento.client.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.getnet.pagamento.service.ApiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "acesso")
public class AcessoController {
    
    @Autowired
    private ApiService apiService;
    
    @PostMapping(value ="/token", produces = "application/json")
    public Object tokenAcesso() throws ApiException{
        return JSON.createGson().create().toJson(apiService.gerarToken());
    }
    
}
