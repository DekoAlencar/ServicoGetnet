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
@RequestMapping(value = "v1/public/boleto")
public class BoletoController {
    
    @Autowired
    private ApiService apiService;
    
    @PostMapping(value="/pagamento", produces = "application/json")
    public RetornoTransacao pagamentoBoleto(@RequestBody PagamentoRequest request){
        return apiService.realizarPagamentoBoleto(request);
    }
    
    @GetMapping(value="/{idPagamento}/{tipoArquivo}", produces = "application/json")
    public void linkDonwload(@PathVariable(value = "idPagamento") String idPagamento, @PathVariable(value = "tipoArquivo") String tipoArquivo){
        apiService.linkDownload(idPagamento, tipoArquivo);
    }
    
    @GetMapping(value="atualizar/{idBoleto}/{situacao}", produces = "application/json")
    public RetornoTransacao atulizarPagamento(@PathVariable(value = "idBoleto") Integer id, @PathVariable(value = "situacao") String situacao){
        return apiService.atualizarPagamentoBoleto(id, situacao);
    }
   
}
