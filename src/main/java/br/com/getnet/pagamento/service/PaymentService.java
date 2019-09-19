/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.service;

import br.com.getnet.pagamento.client.ApiException;
import br.com.getnet.pagamento.client.dto.RetornoTransacao;
import br.com.getnet.pagamento.model.Boleto;
import br.com.getnet.pagamento.model.CancelRequest;
import br.com.getnet.pagamento.model.Card;
import br.com.getnet.pagamento.model.Credit;
import br.com.getnet.pagamento.model.Customer;
import br.com.getnet.pagamento.model.CustomerBoleto;
import br.com.getnet.pagamento.model.Debit;
import br.com.getnet.pagamento.model.Device;
import br.com.getnet.pagamento.model.Order;
import br.com.getnet.pagamento.model.PaymentBoleto;
import br.com.getnet.pagamento.model.PaymentCredit;
import br.com.getnet.pagamento.model.PaymentCreditResponse;
import br.com.getnet.pagamento.model.PaymentDebit;
import br.com.getnet.pagamento.util.PagamentoException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    
    private ApiService controller; 

    public PaymentService() {
        this.controller = new ApiService();
    }    
    
    public PaymentCredit preencherPagamentoCredito(BigDecimal parcela, Double valor, Credit credit, Customer customer, Order order, Device device, 
            String moeda, String sellerId){
        PaymentCredit paymentCredit = new PaymentCredit();
        
        paymentCredit.setAmount(converterEmCentavos(valor));
        paymentCredit.setCredit(credit);
        paymentCredit.setCustomer(customer);
        paymentCredit.setOrder(order);
        paymentCredit.setDevice(device);
        paymentCredit.setCurrency(moeda);
        paymentCredit.setSellerId(sellerId);
        
        return paymentCredit;
    }
    
    public PaymentCredit preencherPagamentoCreditoResumido(BigDecimal parcela, Double valor, Credit credit, Customer customer, Order order){
        PaymentCredit paymentCredit = preencherPagamentoCredito(parcela, valor, credit, customer, order, null, null, null);
        
        return paymentCredit;
    }
    
    public PaymentBoleto preencherPagamentoBoleto(Double valor, String sellerId, CustomerBoleto customer, Order order, Boleto boleto){
        PaymentBoleto paymentBoleto = new PaymentBoleto();
        
        paymentBoleto.setAmount(converterEmCentavos(valor));
        paymentBoleto.setSellerId(sellerId);
        paymentBoleto.setCustomer(customer);
        paymentBoleto.setOrder(order);
        paymentBoleto.setBoleto(boleto);
        
        return paymentBoleto;
    }
    
    public PaymentDebit preencherPagamentoDebito(Double valor,String sellerId, Customer customer, Order order, Debit debit){
        PaymentDebit paymentDebit = new PaymentDebit();
        
        paymentDebit.setAmount(converterEmCentavos(valor));
        paymentDebit.setSellerId(sellerId);
        paymentDebit.setCustomer(customer);
        paymentDebit.setDebit(debit);
        
        return paymentDebit;
    }
    
    public Credit preencherCredito(BigDecimal parcela, Boolean autenticacao, Boolean preAutorizacao, String descricao, Card card) throws ApiException{
        Credit credit = new Credit();
        
        credit.setDelayed(false);
        credit.setSaveCardData(false);
        credit.setTransactionType(Credit.TransactionTypeEnum.FULL);
        credit.setNumberInstallments(parcela);
        credit.setCard(card);
        credit.setAuthenticated(autenticacao);
        credit.setPreAuthorization(preAutorizacao);
        credit.setSoftDescriptor(descricao);
        
        return credit;
    }
    
    public Card preencherCartao(String cartaoNumero, String cartaoNome, String cartaoMes, String cartaoAno, String codigoSerguranca, Card.BrandEnum enumBandeira) throws ApiException{
        String cartaoTokenizado = controller.tokenizarCartao(cartaoNumero,null).getNumberToken();
        
        Card card = new Card();
        card.setNumberToken(cartaoTokenizado);
        card.setCardholderName(cartaoNome);
        card.setSecurityCode(codigoSerguranca);
        card.setBrand(enumBandeira);
        card.setExpirationMonth(cartaoMes);
        card.setExpirationYear(cartaoAno);
        
        return card;
    }    
    
    public Card preencherCartaoResumido(String cartaoNumero, String cartaoNome, String cartaoMes, String cartaoAno) throws ApiException{
        Card card = preencherCartao(cartaoNumero, cartaoNome, cartaoMes, cartaoAno, null, null);
        
        return card;
    }
    
    public Boleto preencherBoleto(String numeroDocumento, String instrucao){
        Boleto boleto = new Boleto();
        
        boleto.setDocumentNumber(numeroDocumento);
        boleto.setInstructions(instrucao);
        
        return boleto;
    }
    
    public Debit preencherDebito(Card card, String telefone, String descricao){
        Debit debit = new Debit();
        
        debit.setCard(card);
        debit.setCardholderMobile(telefone);
        debit.setSoftDescriptor(descricao);
        
        return debit;
    }
   
    public Order preencherCompra(String idCompra, Double valorImposto, Order.ProductTypeEnum enumTipoProduto){
        Order order = new Order();
        
        BigDecimal imposto = null;
        
        if(valorImposto != null){
            imposto = new BigDecimal(valorImposto,MathContext.UNLIMITED);
        }else{
            imposto = new BigDecimal(BigInteger.ZERO);
        }
        
        order.setOrderId(idCompra);
        
        order.setSalesTax(imposto);
        order.setProductType(enumTipoProduto);
        
        return order;
    }
    
    public Device preencherDispositivo(String uuid, String enderecoIp){
        Device device = new Device();
        
        device.setDeviceId(uuid);
        device.setIpAddress(enderecoIp);
        
        return device;
    }
    
    public CancelRequest preencherSolicitacaoCancelamento(Double valor, String idPagamento, String idCliente){
        CancelRequest cancelRequest = new CancelRequest();
        
        cancelRequest.setCancelAmount(converterEmCentavos(valor));
        cancelRequest.setPaymentId(idPagamento);
        cancelRequest.setCancelCustomKey(idCliente);
        
        return cancelRequest;
    }
    
    
    public RetornoTransacao pagamentoCreditoToDTO(PaymentCreditResponse response){
        RetornoTransacao retorno = new RetornoTransacao();
        
        retorno.setIdPagamento(response.getPaymentId());
        retorno.setStatus(response.getStatus().getValue());
        retorno.setIdAutorizacao(response.getCredit().getAuthorizationCode());
        retorno.setDataPagamento(response.getReceivedAt());
        
        return retorno;
    }
    
    public Integer converterEmCentavos(Double preco){
       String valor = preco.toString();
       Integer retorno = 0;
       if(valor.contains(".")){
           String arrayValor[] = valor.split("\\.");
           if(Integer.parseInt(arrayValor[0]) > 0 ){
               retorno = Integer.parseInt(arrayValor[0])*100;
           }
           retorno += Integer.parseInt(arrayValor[1]);
       }else{
           throw new PagamentoException("Valor está em formato incorreto");
       }
       
       return retorno;
    }
}
