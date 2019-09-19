/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.service;

import br.com.getnet.pagamento.client.dto.ResumoFinanceiro;
import br.com.getnet.pagamento.client.dto.RetornoTransacao;
import br.com.getnet.pagamento.entidade.Boleto;
import br.com.getnet.pagamento.entidade.Cliente;
import br.com.getnet.pagamento.entidade.Sistema;
import br.com.getnet.pagamento.entidade.Transacao;
import br.com.getnet.pagamento.model.PaymentBoletoResponse;
import br.com.getnet.pagamento.repositorio.TransacaoRepository;
import br.com.getnet.pagamento.model.Error;
import br.com.getnet.pagamento.repositorio.RelatorioAnaliticoRepository;
import br.com.getnet.pagamento.util.EnumStatusPagamento;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {
    
    @Autowired
    TransacaoRepository repositorio;
    
    @Autowired
    RelatorioAnaliticoRepository analiticoRepositorio;
    
    @Autowired
    SistemaService sistemaService;
    
    @Autowired
    BoletoService boletoService;
    
    @Autowired
    ClienteService clienteService;
    
    public Transacao salvar(Transacao transacao){
        return repositorio.save(transacao);
    }
    
    public Transacao get(int id){
        return repositorio.findById(id);
    }
    
    public void remover(Transacao transacao){
        repositorio.delete(transacao);
    }
    
    public Transacao buscarPorMD(String md){
        return repositorio.findByMD(md);
    }
    
    public Transacao buscarPorIdPagamento(String idPagamento){
        return repositorio.findByIdPagamento(idPagamento);
    }
    
    public Transacao preencherTransacaoResumido(Integer idSistema, String enunTipoTranscacao, Double valor, Cliente cliente){
        return preencherTransacaoResumido(idSistema, enunTipoTranscacao, null, valor, cliente);
    }
    public Transacao preencherTransacaoResumido(Integer idSistema, String enunTipoTranscacao, String status, Double valor, Cliente cliente){
        Transacao transacao = new Transacao();
        
        Sistema sistema = sistemaService.get(idSistema);
        
        transacao.setIdSistema(sistema);
        transacao.setIdCliente(cliente);
        transacao.setDataSolicitacao(new Date());
        transacao.setTipoTransacao(enunTipoTranscacao);
        transacao.setStatus(EnumStatusPagamento.retonarEnumPorRelacao(status).getDescricao());
        transacao.setValor(valor);
        
        return transacao;
    }
    
    public Transacao preencherTransacaoDebito(Transacao transacao, String pareq, String pares, String md, String status, Date dataFinal, String idAutorizacao, String idPagamento){
        if(transacao.getCertificadoEmissor() != null){
            transacao.setCertificadoPagamento(pares);
        }else{
            transacao.setCertificadoEmissor(pareq);
        }
        transacao.setMd(md);
        transacao.setStatus(EnumStatusPagamento.retonarEnumPorRelacao(status).getDescricao());
        transacao.setDataFinalizacao(dataFinal);
        transacao.setIdAutorizacao(idAutorizacao);
        transacao.setIdPagamento(idPagamento);
        return salvar(transacao);
    }
    
    public Transacao preencherTransacaoCredito(Transacao transacao, String idPagamento, String idAutorizacao, String status, Date dataFinal){
        transacao.setIdPagamento(idPagamento);
        transacao.setIdAutorizacao(idAutorizacao);
        transacao.setStatus(EnumStatusPagamento.retonarEnumPorRelacao(status).getStatus());
        transacao.setDataFinalizacao(dataFinal);
        return salvar(transacao);
    }
    
    public Transacao preencherTransacaoErro(Transacao transacao, Error error){
        if (error.getDetails().size() > 0 && error.getDetails().get(0).getCodeErro() != null) {
            transacao.setStatus(error.getDetails().get(0).getStatus());
            transacao.setCodigoErro(error.getDetails().get(0).getCodeErro());
            transacao.setObs(error.getDetails().get(0).getDescriptionDetail());
        }
        transacao.setStatus(EnumStatusPagamento.CANCELADO.getDescricao());       
        transacao.setMensgaemErro(error.getMessage());
        return salvar(transacao);
    }
    
    public Boleto preencherTransacaoBoleto(Transacao transacao, PaymentBoletoResponse boletoResponse){
        transacao = salvar(transacao);
        Boleto boleto = boletoService.preencherBoletoSalvar(transacao, boletoResponse.getBoleto().getBoletoId(), 
                boletoResponse.getBoleto().getExpirationDate(), boletoResponse.getBoleto().getBank(), 
                boletoResponse.getBoleto().getBarCode(), boletoResponse.getBoleto().getStatusLabel(), 
                boletoResponse.getBoleto().getTypefulLine(), boletoResponse.getBoleto().getLinks().get(0).toString());
        
        return boleto;
    }
    
    public RetornoTransacao transacaoToRetornoDTO(Transacao transacao){
        RetornoTransacao dto = new RetornoTransacao();
        dto.setDataPagamento(transacao.getDataSolicitacao().toString());
        dto.setIdPagamento(transacao.getIdPagamento());
        dto.setIdAutorizacao(transacao.getIdAutorizacao());
        dto.setStatus(EnumStatusPagamento.retonarEnumSelecionado(transacao.getStatus()).getStatus());
        
        return dto;
    }
    
    public List<Transacao> buscarTransacao(){
        return repositorio.findAllOrder();
    }
    
    public List<Transacao> buscarTranscoesPorSistema(Sistema sistema){
        return repositorio.findAllByIdSistema(sistema);
    }
    
    public List<Transacao> buscarTransacoesPorTipo(String tipoTransacao){
        return repositorio.findAllByTipo(tipoTransacao);
    }
    
    public List<Transacao> buscarTransacaoPorPeriodo(String dataSolicitacao, String dataFinalizacao) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        Date solicitacao = (Date)format.parse(dataSolicitacao);
        Date finalizacao = (Date)format.parse(dataFinalizacao);
        
        return repositorio.findAllByPeriodo(solicitacao, finalizacao);
    }
    
    public List<ResumoFinanceiro> resumoFinanceiroPorPeriodo(String dataSolicitacao, String dataFinalizacao) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        
        Date solicitacao = (Date)format.parse(dataSolicitacao);
        Date finalizacao = (Date)format.parse(dataFinalizacao);
        
        return repositorio.resumoFinanceiroByPeriodo(solicitacao, finalizacao);
    }
    
    public Object relatorioAnalitico(String dataInicio, String dataFim) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        Date solicitacao = format.parse(dataInicio);
        Date finalizacao = format.parse(dataFim);
        
        return analiticoRepositorio.relatorioAnalitico();
    }
}
