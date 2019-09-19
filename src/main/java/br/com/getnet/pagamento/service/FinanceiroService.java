/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.service;

import br.com.getnet.pagamento.client.dto.ResumoFinanceiro;
import br.com.getnet.pagamento.entidade.Transacao;
import br.com.getnet.pagamento.util.EnumTipoTransacao;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinanceiroService {
    
    @Autowired
    TransacaoService transacaoService;
    
    public List<ResumoFinanceiro> resumoFinenceiroBoleto(String dataInicio, String dataFim) throws ParseException{
        List<ResumoFinanceiro> resumoLista = transacaoService.resumoFinanceiroPorPeriodo(dataInicio, dataFim);
        
        return resumoLista;
    }
    
    public List<Transacao> transacoesPorTipo(String tipoTransacao){
        return transacaoService.buscarTransacoesPorTipo(tipoTransacao);
    }
    
    public List<Transacao> todasTransacoes(){
        return transacaoService.buscarTransacao();
    }
    
    public List<Transacao> transacoesPorPeriodo(String dataInicial, String dataFinal) throws ParseException{
        return transacaoService.buscarTransacaoPorPeriodo(dataInicial, dataFinal);
    }
}
