/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.controller;

import br.com.getnet.pagamento.client.JSON;
import br.com.getnet.pagamento.service.FinanceiroService;
import br.com.getnet.pagamento.service.TransacaoService;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping(value="v1/public/financeiro")
public class FinanceiroController {
    
    @Autowired
    FinanceiroService financeiroService;
    @Autowired
    TransacaoService transacaoService;
    
    @GetMapping(value = "", produces = "application/json")
    public Object transacoes(){
        return JSON.createGson().create().toJson(financeiroService.todasTransacoes());
    }
    
    @GetMapping(value="/resumo/{inicio}/{fim}", produces = "application/json")
    public Object resumoFinanceiro(@PathVariable(name = "inicio") String dataInicio, @PathVariable(name="fim") String dataFim) throws ParseException{
        return JSON.createGson().create().toJson(financeiroService.resumoFinenceiroBoleto(dataInicio, dataFim));
    }
    
    @GetMapping(value="/{tipoTransacao}", produces = "application/json")
    public Object transacoesPorTipo(@PathVariable(name = "tipoTransacao") String tipoTransacao){
        return JSON.createGson().create().toJson(financeiroService.transacoesPorTipo(tipoTransacao));
    }
    
    @GetMapping(value="/{dataInicial}/{dataFinal}", produces = "application/json")
    public Object transacoesPorPeriodo(@PathVariable(name = "dataInicial") String dataInicial, @PathVariable("dataFinal") String dataFinal) throws ParseException{
        return JSON.createGson().create().toJson(financeiroService.transacoesPorPeriodo(dataInicial, dataFinal));
    }
    
    @GetMapping(value="analitico/{dataInicial}/{dataFinal}", produces = "application/json")
    public Object relatorioAnalitico(@PathVariable(name = "dataInicial") String dataInicial, @PathVariable("dataFinal") String dataFinal) throws ParseException{
        return JSON.createGson().create().toJson(transacaoService.relatorioAnalitico(dataInicial, dataFinal));
    }
    
}
