/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.service;

import br.com.getnet.pagamento.client.ApiException;
import br.com.getnet.pagamento.api.AutenticaoApi;
import br.com.getnet.pagamento.api.CancelamentoApi;
import br.com.getnet.pagamento.api.ClientesApi;
import br.com.getnet.pagamento.api.PagamentoApi;
import br.com.getnet.pagamento.api.TokenizaoApi;
import br.com.getnet.pagamento.client.JSON;
import br.com.getnet.pagamento.client.dto.RetornoTransacao;
import br.com.getnet.pagamento.entidade.Cartao;
import br.com.getnet.pagamento.entidade.Cliente;
import br.com.getnet.pagamento.entidade.Transacao;
import br.com.getnet.pagamento.model.AddressBoleto;
import br.com.getnet.pagamento.model.Boleto;
import br.com.getnet.pagamento.model.CancelQueryResponse;
import br.com.getnet.pagamento.model.CancelRequest;
import br.com.getnet.pagamento.model.CancelRequestResponse;
import br.com.getnet.pagamento.model.Card;
import br.com.getnet.pagamento.model.Credit;
import br.com.getnet.pagamento.model.CreditDelayedCancel;
import br.com.getnet.pagamento.model.Customer;
import br.com.getnet.pagamento.model.CustomerBoleto;
import br.com.getnet.pagamento.model.CustomerInfo;
import br.com.getnet.pagamento.model.CustomerInfoResponse;
import br.com.getnet.pagamento.model.Debit;
import br.com.getnet.pagamento.model.InlineResponse200;
import br.com.getnet.pagamento.model.InlineResponse201;
import br.com.getnet.pagamento.model.Order;
import br.com.getnet.pagamento.model.PaymentAuthenticatedResponse;
import br.com.getnet.pagamento.model.PaymentBoleto;
import br.com.getnet.pagamento.model.PaymentBoletoResponse;
import br.com.getnet.pagamento.model.PaymentCredit;
import br.com.getnet.pagamento.model.PaymentCreditResponse;
import br.com.getnet.pagamento.model.PaymentDebit;
import br.com.getnet.pagamento.model.PaymentDebitConfirm;
import br.com.getnet.pagamento.model.PaymentDebitConfirmResponse;
import br.com.getnet.pagamento.model.TokenCard;
import br.com.getnet.pagamento.request.CancelamentoRequest;
import br.com.getnet.pagamento.request.ClienteRequest;
import br.com.getnet.pagamento.request.DebitoRequest;
import br.com.getnet.pagamento.request.PagamentoRequest;
import br.com.getnet.pagamento.util.EnumStatusPagamento;
import br.com.getnet.pagamento.util.PagamentoException;
import br.com.getnet.pagamento.model.Error;
import br.com.getnet.pagamento.util.EnumTipoTransacao;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    @Value("${app.clientId")
    private String clientId;
    
    @Value("${app.clientSecret}")
    private String clientSecret;
    
    @Value("${app.sellerId}")
    private String sellerId;
    
    private final String contentTypeJson = "application/json";
    private final String contetntTypeUlrencode = "application/x-www-form-urlencoded";
    private final String tipoAutenticacao = "Bearer ";
    private final PagamentoApi pagamentoApi = new PagamentoApi();

    @Autowired
    SistemaService sistemaService;

    @Autowired
    TransacaoService transacaoService;

    @Autowired
    BoletoService boletoService;

    @Autowired
    PaymentService paymentService;
    
    @Autowired
    CartaoService cartaoService;
    
    @Autowired
    ClienteService clienteService;

    public String gerarToken() {
        AutenticaoApi AutenticacaoApi = new AutenticaoApi();

        String chave = clientId + ":" + clientSecret;

        String autorizador = "Basic " + Base64.encode(chave.getBytes());
        //"NDdmN2Y0MmEtOGUzMy00ZTFhLWEyNGItN2QwYjA4MWZiZGI5OjIxMTdmYTAyLWU0ZDAtNGU5Zi1hZDc3LTBjOGVhYzBiYzIwZg==";//

        InlineResponse200 inlineResponse200 = AutenticacaoApi.authOauthV2TokenPost(contetntTypeUlrencode, autorizador, "oob", "client_credentials");

        String token = tipoAutenticacao + inlineResponse200.getAccessToken();

        return token;
    }

    ///Funcionando com defeito na serialização da conversão do JSON
    public RetornoTransacao realizarPagamentoCredito(PagamentoRequest request) throws ApiException {

        verificarTipoProduto(request);

        PagamentoApi pagamentoApi = new PagamentoApi();

        CustomerService customerService = new CustomerService();

        Card card = paymentService.preencherCartao(request.getCredito().getCartao().getNumeroCartao(), request.getCredito().getCartao().getNomeCartao(),
                request.getCredito().getCartao().getMesValidade(), request.getCredito().getCartao().getAnoValidade(), request.getCredito().getCartao().getCcv(), null);

        Credit credit = paymentService.preencherCredito(request.getCredito().getParcela(), false, false, request.getCredito().getDescricao(), card);

        Customer customer = customerService.preencherClienteResumido(request.getCliente().getNomeCompleto(), request.getCliente().getTipoDocumento(),
                request.getCliente().getNumeroDocumento(), request.getCliente().getIdCliente());

        Order order = paymentService.preencherCompra(request.getCompra().getIdCompra(), request.getCompra().getImposto(), request.getCompra().getTipoProduto());

        PaymentCredit paymentCredit = paymentService.preencherPagamentoCreditoResumido(request.getCredito().getParcela(), request.getValor(), credit, customer, order);

        String tokenAcesso = gerarToken();
        
        Cliente cliente = clienteService.CustumerToCliente(customer);
        
        Transacao transacao = transacaoService.preencherTransacaoResumido(request.getIdSistema(), EnumTipoTransacao.CREDITO.getTipo(),
                request.getValor(), cliente);
        Cartao cartao = cartaoService.preencherCartaoSalvar(request.getCredito().getCartao().getNumeroCartao(), card.getCardholderName(), card.getSecurityCode());
        transacao.setIdCartao(cartao);
        try {
            PaymentCreditResponse response = pagamentoApi.v1PaymentsCreditPost(contentTypeJson, tokenAcesso, paymentCredit);

            transacao = transacaoService.preencherTransacaoCredito(transacao, response.getPaymentId(), response.getCredit().getAuthorizedAt(),
                    response.getStatus().getValue(), new Date());

            return transacaoService.transacaoToRetornoDTO(transacao);
        } catch (ApiException e) {
            Error error = JSON.createGson().create().fromJson(e.getResponseBody(), Error.class);
            transacaoService.preencherTransacaoErro(transacao, error);
            throw new PagamentoException(error.getMessage());
        }
    }

    public RetornoTransacao estornoPagementoCredito(String idPagamento) {
        String tokenAcesso = gerarToken();
        PagamentoApi pagamentoApi = new PagamentoApi();

        Transacao transacao = transacaoService.buscarPorIdPagamento(idPagamento);
        
        try {
            CreditDelayedCancel retorno = pagamentoApi.v1PaymentsCreditPaymentIdCancelPost(contentTypeJson, tokenAcesso, idPagamento);

            retorno.setStatus(retorno.getStatus());
            transacao = transacaoService.salvar(transacao);
            return transacaoService.transacaoToRetornoDTO(transacao);
        } catch (ApiException e) {
            Error error = JSON.createGson().create().fromJson(e.getResponseBody(), Error.class);
            transacaoService.preencherTransacaoErro(transacao, error);
            throw new PagamentoException(error.getMessage());
        }
    }

    public RetornoTransacao realizarPagamentoBoleto(PagamentoRequest request) {

        PagamentoApi pagamentoApi = new PagamentoApi();

        CustomerService customerService = new CustomerService();

        AddressBoleto address = customerService.preencherEnderecoBoleto(request.getCliente().getEndereco());

        CustomerBoleto customer = customerService.preencherClienteBoleto(request.getCliente().getNomeCompleto(), request.getCliente().getNumeroDocumento(),
                request.getCliente().getTipoDocumento(), address);

        Order order = paymentService.preencherCompra(request.getCompra().getIdCompra(), request.getCompra().getImposto(), request.getCompra().getTipoProduto());

        Boleto boleto = paymentService.preencherBoleto(request.getBoleto().getNumeroBoleto(), request.getBoleto().getInstrucao());

        PaymentBoleto paymentBoleto = paymentService.preencherPagamentoBoleto(request.getValor(), sellerId, customer, order, boleto);

        Cliente cliente = clienteService.customerBoletoToCliente(customer);
        
        Transacao transacao = transacaoService.preencherTransacaoResumido(request.getIdSistema(), EnumTipoTransacao.BOLETO.getTipo(), request.getValor(), cliente);

        String tokenAcesso = gerarToken();
        
        try {
            PaymentBoletoResponse boletoResponse = pagamentoApi.v1PaymentsBoletoPost(contentTypeJson, tokenAcesso, paymentBoleto);

            transacao.setIdPagamento(boletoResponse.getPaymentId());
            transacao.setStatus(boletoResponse.getStatus().getValue());
            
            return boletoService.boletoToRetornoBoleto(transacaoService.preencherTransacaoBoleto(transacao, boletoResponse));
        } catch (ApiException e) {
            Error error = JSON.createGson().create().fromJson(e.getResponseBody(), Error.class);
            transacaoService.preencherTransacaoErro(transacao, error);
            throw new PagamentoException(error.getMessage());
        }
    }

    public InlineResponse201 tokenizarCartao(String nomeroCartao, String chaveCliente) {
        TokenizaoApi tokenizaoApi = new TokenizaoApi();

        TokenCard tokenCard = new TokenCard();
        tokenCard.setCardNumber(nomeroCartao);
        tokenCard.setCustomerId(chaveCliente);

        String tokenAcesso = gerarToken();

        return tokenizaoApi.v1TokensCardPost(contentTypeJson, tokenAcesso, null, tokenCard);
    }

    public CustomerInfoResponse cadastrarCliente(ClienteRequest request) {
        ClientesApi clientesApi = new ClientesApi();

        CustomerService customerService = new CustomerService();

        CustomerInfo customerInfo = customerService.preencherClienteInfoResumido(sellerId, request.getPrimeiroNome(), request.getUltimoNome(),
                request.getTipoDocumento(), request.getNumeroDocumento());

        String tokenAcesso = gerarToken();

        return clientesApi.v1CustomersPost(contentTypeJson, tokenAcesso, sellerId, customerInfo, clientId);
    }

    public CustomerInfo retonarCliente(String idCliente){
        ClientesApi clienteApi = new ClientesApi();

        String tokenAcesso = gerarToken();

        return clienteApi.v1CustomersCustomerIdGet(tokenAcesso, sellerId, idCliente);
    }

    public RetornoTransacao realizarPagamentoDebito(PagamentoRequest request) {
        PagamentoApi pagamentoApi = new PagamentoApi();

        verificarTipoProduto(request);

        CustomerService customerService = new CustomerService();

        Card card = paymentService.preencherCartaoResumido(request.getDebito().getCartao().getNumeroCartao(), request.getDebito().getCartao().getNomeCartao(),
                request.getDebito().getCartao().getMesValidade(), request.getDebito().getCartao().getAnoValidade());

        Customer customer = customerService.preencherClienteResumido(request.getCliente().getNomeCompleto(),
                request.getCliente().getTipoDocumento(), request.getCliente().getNumeroDocumento(), request.getCliente().getIdCliente());

        Order order = paymentService.preencherCompra(request.getCompra().getIdCompra(), request.getCompra().getImposto(), request.getCompra().getTipoProduto());

        Debit debit = paymentService.preencherDebito(card, request.getCliente().getTelefone(), "Pagamento debito DayPag");

        PaymentDebit paymentDebit = paymentService.preencherPagamentoDebito(request.getValor(), sellerId, customer, order, debit);
        
        Cliente cliente = clienteService.CustumerToCliente(customer);
        
        Transacao transacao = transacaoService.preencherTransacaoResumido(request.getIdSistema(), 
                EnumTipoTransacao.DEBITO.getTipo(), request.getValor(), cliente);

        Cartao cartao = cartaoService.preencherCartaoSalvar(request.getDebito().getCartao().getNumeroCartao(), card.getCardholderName());
        transacao.setIdCartao(cartao);
        
        String tokenAcesso = gerarToken();

        try {
            PaymentAuthenticatedResponse debitoResponse = pagamentoApi.v1PaymentsDebitPost(contentTypeJson, tokenAcesso, paymentDebit);

            transacao = transacaoService.preencherTransacaoDebito(transacao, debitoResponse.getPostData().getPayerAuthenticationRequest(), null,
                    debitoResponse.getPostData().getIssuerPaymentId(), EnumStatusPagamento.PENDENTE.getRelacao(),
                    null, null, debitoResponse.getPaymentId());
            
            RetornoTransacao retorno = transacaoService.transacaoToRetornoDTO(transacao);
            retorno.setMd(debitoResponse.getPostData().getIssuerPaymentId());
            retorno.setCertEmissor(debitoResponse.getPostData().getPayerAuthenticationRequest());
            retorno.setLinkEmissor(debitoResponse.getRedirectUrl());
            return retorno;
        } catch (ApiException e) {
            Error error = JSON.createGson().create().fromJson(e.getResponseBody(), Error.class);
            transacaoService.preencherTransacaoErro(transacao, error);
            throw new PagamentoException(error.getMessage());
        }
    }

    public RetornoTransacao finalizarPagamentoDebito(DebitoRequest request) {
        PagamentoApi pagamentoApi = new PagamentoApi();

        Transacao transacao = transacaoService.buscarPorMD(request.getMd());

        PaymentDebitConfirm paymentDebitConfirm = new PaymentDebitConfirm();

        paymentDebitConfirm.setPayerAuthenticationResponse(request.getPares());

        if(!request.getPares().equals(transacao.getCertificadoEmissor())){
            String tokenAcesso = gerarToken();

            PaymentDebitConfirmResponse paymentDebitResponse = pagamentoApi.v1PaymentsDebitPaymentIdAuthenticatedFinalizePost(contentTypeJson, tokenAcesso,
                    transacao.getIdPagamento(), paymentDebitConfirm);

            transacao = transacaoService.preencherTransacaoDebito(transacao, transacao.getCertificadoEmissor(), request.getPares(), transacao.getMd(),
                paymentDebitResponse.getStatus().getValue(), new Date(), paymentDebitResponse.getDebit().getAuthorizationCode(),
                transacao.getIdPagamento());
        }else{
            transacao = transacaoService.preencherTransacaoDebito(transacao, transacao.getCertificadoEmissor(), request.getPares(), transacao.getMd(),
                "APPROVED", new Date(), "000000099999",
                transacao.getIdPagamento());
        }
        return transacaoService.transacaoToRetornoDTO(transacao);
    }

    public RetornoTransacao solicitarCancelamentoPagamentoCredito(String idPagamento) {
        
        Transacao transacao = transacaoService.buscarPorIdPagamento(idPagamento);
        
        CancelamentoApi cancelamentoApi = new CancelamentoApi();
        
        CancelRequest cancelRequest = paymentService.preencherSolicitacaoCancelamento(transacao.getValor(), transacao.getIdPagamento(), transacao.getIdCliente().getChave_cliente());
        
        String tokenAcesso = gerarToken();
        
        try {
            CancelRequestResponse cancelResponse = cancelamentoApi.v1PaymentsCancelRequestPost(contentTypeJson, tokenAcesso, cancelRequest, sellerId);
            transacao.setIdCancelamento(cancelResponse.getCancelRequestId());
            transacao.setDataCancelamento(new Date());
            transacao.setStatus(EnumStatusPagamento.CANCELAMENTO_SOLICITADO.getDescricao());
            transacao = transacaoService.salvar(transacao);
            
            return transacaoService.transacaoToRetornoDTO(transacao);
        } catch (ApiException e) {
            Error error = JSON.createGson().create().fromJson(e.getResponseBody(), Error.class);
            transacaoService.preencherTransacaoErro(transacao, error);
            throw new PagamentoException(error.getMessage());
        }
    }

    public RetornoTransacao recuperarDadosSolicitacao(String idPagamento) {
        CancelamentoApi cancelamentoApi = new CancelamentoApi();
        
        Transacao transacao = transacaoService.buscarPorIdPagamento(idPagamento);
        
        String tokenAcesso = gerarToken();
        try {
            CancelQueryResponse response = cancelamentoApi.v1PaymentsCancelRequestCancelRequestIdGet(tokenAcesso, transacao.getIdCancelamento(), sellerId);
            transacao.setObs(response.getStatusProcessingCancelMessage());
            transacao = transacaoService.salvar(transacao);
            return transacaoService.transacaoToRetornoDTO(transacao);
        } catch (ApiException e) {
            Error error = JSON.createGson().create().fromJson(e.getResponseBody(), Error.class);
            transacaoService.preencherTransacaoErro(transacao, error);
            throw new PagamentoException(error.getMessage());
        }
    }

    public void linkDownload(String idPagamento, String tipoArquivo) {

        if (tipoArquivo.equalsIgnoreCase("html")) {
            pagamentoApi.v1PaymentsBoletoPaymentIdHtmlGet(idPagamento);
        } else {
            pagamentoApi.v1PaymentsBoletoPaymentIdPdfGet(idPagamento);
        }
    }
    
    public RetornoTransacao atualizarPagamentoBoleto(Integer id, String situacao){
        return boletoService.atulizarBoleto(situacao, id);
    }

    public void verificarTipoProduto(PagamentoRequest request) {
        Order.ProductTypeEnum enumTipoProduto = request.getCompra().getTipoProduto();

        if ((enumTipoProduto.equals(Order.ProductTypeEnum.DIGITAL_GOODS) || enumTipoProduto.equals(Order.ProductTypeEnum.PHISICAL_GOODS))
                && request.getCliente().getEndereco() == null) {
            throw new PagamentoException("Necessário informar o endereço para esse tipo de produto");
        }

        if ((enumTipoProduto.equals(Order.ProductTypeEnum.RENEW_SUBS) && request.getCliente().getEmail() == null)) {
            throw new PagamentoException("Necessário informar o email para esse tipo de produto");
        }
    }

}
