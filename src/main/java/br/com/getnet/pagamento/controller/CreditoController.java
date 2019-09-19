/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.controller;

import br.com.getnet.pagamento.client.JSON;
import br.com.getnet.pagamento.client.dto.RetornoTransacao;
import br.com.getnet.pagamento.request.PagamentoRequest;
import br.com.getnet.pagamento.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/public/credito")
public class CreditoController {
    @Autowired
    private ApiService apiService;
    
    @PostMapping(value="/pagamento", produces = "application/json")
    public RetornoTransacao pagamentoCredito(@RequestBody PagamentoRequest request){
        return apiService.realizarPagamentoCredito(request);
    }
    
    @GetMapping(value="/estonar/{idPagamento}", produces = "application/json")
    public Object estornar(@PathVariable(value = "idPagamento") String idPagamento){
        return apiService.estornoPagementoCredito(idPagamento);
    }
    
    @PostMapping(value = "/cancelar/{idPagamento}", produces = "application/json")
    public RetornoTransacao solicitarCancelamento(@PathVariable(value = "idPagamento") String idPagamento){
        return apiService.solicitarCancelamentoPagamentoCredito(idPagamento);
    }
    
    @GetMapping(value = "/solicitacao/{idPagamento}", produces = "application/json")
    public RetornoTransacao retornarSolicitacao(@PathVariable(value = "idPagamento") String idPagamento){
        return apiService.recuperarDadosSolicitacao(idPagamento);
    }
    
}
