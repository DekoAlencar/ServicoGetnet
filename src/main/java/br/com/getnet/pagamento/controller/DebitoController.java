/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.controller;

import br.com.getnet.pagamento.client.JSON;
import br.com.getnet.pagamento.client.dto.RetornoTransacao;
import br.com.getnet.pagamento.request.DebitoRequest;
import br.com.getnet.pagamento.request.PagamentoRequest;
import br.com.getnet.pagamento.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="v1/public/debito")
public class DebitoController {
    
    @Autowired
    private ApiService apiService;
    
    @PostMapping(value="/pagamento", produces = "application/json")
    public RetornoTransacao pagamentoDebito(@RequestBody PagamentoRequest request){
        return apiService.realizarPagamentoDebito(request);
    }
    
    @PostMapping(value = "/finalizar", produces = "application/json")
    public RetornoTransacao finalizarPagamento(@RequestBody DebitoRequest request){
        return apiService.finalizarPagamentoDebito(request);
    }
    
}
