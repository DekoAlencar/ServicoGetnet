/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.service;

import br.com.getnet.pagamento.client.dto.RetornoBoleto;
import br.com.getnet.pagamento.client.dto.RetornoTransacao;
import br.com.getnet.pagamento.entidade.Boleto;
import br.com.getnet.pagamento.entidade.Transacao;
import br.com.getnet.pagamento.repositorio.BoletoRepository;
import br.com.getnet.pagamento.util.EnumStatusPagamento;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoletoService {
    
    @Autowired
    private BoletoRepository repositorio;
    
    public Boleto get(int id){
        return repositorio.findById(id);
    }
    
    public void remove(Boleto boleto){
        repositorio.delete(boleto);
    }
    
    public Boleto salvar(Boleto boleto){
        return repositorio.save(boleto);
    }
    
    public Boleto preencherBoletoSalvar(Transacao transacao, String idBoleto, String vencimento, String codigoBanco, String codigoBarra, 
            String sitaucao, String linhaDigitavel, String urlBoleto){
        Boleto boleto = new Boleto();
        
        Date dataVencimento = new Date();
        
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            dataVencimento = (Date)formatter.parse(vencimento);   
        } catch (Exception e) {
            throw new RuntimeException("Erro na conversão da data");
        }
          
        boleto.setIdTransacao(transacao);
        boleto.setIdBoleto(idBoleto);
        boleto.setDataVencimento(dataVencimento);
        boleto.setCodigoBanco(codigoBanco);
        boleto.setCodigoBarra(codigoBarra);
        boleto.setSitaucao(sitaucao);
        boleto.setLinhaDigitavel(linhaDigitavel);
        boleto.setUrlBoleto(urlBoleto);
        
        return salvar(boleto);
    }
    
    public Boleto buscarBoletoPorIdPagamento(String idPagamento){
        return repositorio.findByIdPagamento(idPagamento);
    }
    
    public Boleto buscarBoletoPorTransacao(Transacao transacao){
        return repositorio.findByIdTransacao(transacao);
    }
    
    public RetornoTransacao atulizarBoleto(String situacao, Integer id){
        Boleto boleto = get(id);
        boleto.setSitaucao(situacao);
        Transacao transacao = boleto.getIdTransacao();
        if(situacao.equalsIgnoreCase("Aprovado")){
            transacao.setStatus(EnumStatusPagamento.APROVADO.getStatus());
        }else{
            transacao.setStatus(EnumStatusPagamento.NEGADO.getStatus());
        }
        boleto.setIdTransacao(transacao);
        return boletoToRetornoBoleto(boleto);
    }
    
    public RetornoTransacao boletoToRetornoBoleto(Boleto boleto){
        RetornoTransacao retorno = new RetornoTransacao();
        RetornoBoleto retornoBoleto = new RetornoBoleto(boleto.getIdBoleto(), boleto.getCodigoBanco(), boleto.getCodigoBarra(), boleto.getLinhaDigitavel(), 
                boleto.getDataVencimento(), boleto.getSitaucao(), boleto.getUrlBoleto());

        retorno.setBoleto(retornoBoleto);
        retorno.setIdPagamento(boleto.getIdTransacao().getIdPagamento());
        retorno.setStatus(boleto.getIdTransacao().getStatus());
        return retorno;
    }
    
}

