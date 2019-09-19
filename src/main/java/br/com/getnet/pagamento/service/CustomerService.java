/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.service;

import br.com.getnet.pagamento.model.Address;
import br.com.getnet.pagamento.model.AddressBoleto;
import br.com.getnet.pagamento.model.Customer;
import br.com.getnet.pagamento.model.CustomerBoleto;
import br.com.getnet.pagamento.model.CustomerInfo;
import br.com.getnet.pagamento.request.EnderecoRequest;
import org.w3c.dom.DocumentType;

public class CustomerService {
    
    public CustomerInfo preencherClienteInfo(String sellerId, String primeiroNome, String ultimoNome, CustomerInfo.DocumentTypeEnum enun, 
            String numeroDocumento, String idCliente, String dataNascimento, String telefonen, String email, String celular, Address address){
        CustomerInfo customer = new CustomerInfo();
        
        customer.setSellerId(sellerId);
        customer.setFirstName(primeiroNome);
        customer.setLastName(ultimoNome);
        customer.setDocumentType(enun);
        customer.setDocumentNumber(numeroDocumento);
        customer.setCustomerId(idCliente);
        customer.setBirthDate(dataNascimento);
        customer.setPhoneNumber(telefonen);
        customer.setEmail(email);
        customer.setCelphoneNumber(celular);
        customer.setAddress(address);
        
        return customer;
    }
    
    public CustomerInfo preencherClienteInfoResumido(String sellerId, String primeiroNome, String ultimoNome, String tipoDocumento, String numeroDocumento){
        
        CustomerInfo.DocumentTypeEnum enun = CustomerInfo.DocumentTypeEnum.valueOf(tipoDocumento);
        
        CustomerInfo customer =  preencherClienteInfo(sellerId, primeiroNome, ultimoNome, enun, numeroDocumento, null, null, null, null, null, null);
        
        return customer;
    }
    
    public CustomerInfo preencherClienteResumidoComEndereco(String sellerId, String primeiroNome, String ultimoNome, CustomerInfo.DocumentTypeEnum enun, String numeroDocumento, Address address){
        
        CustomerInfo customer =  preencherClienteInfo(sellerId, primeiroNome, ultimoNome, enun, numeroDocumento, null, null, null, null, null, address);
        
        return customer;
    }
    
    public Customer preencherCliente(String primeiroNome, String ultimoNome, Customer.DocumentTypeEnum enun, String numeroDocumento, 
            String idCliente, String dataNascimento, String telefonen, String email, String celular, Address address){
        
        Customer customer = new Customer();
        customer.setFirstName(primeiroNome);
        customer.setLastName(ultimoNome);
        customer.setDocumentType(enun);
        customer.setDocumentNumber(numeroDocumento);
        customer.setCustomerId(idCliente);
        customer.setPhoneNumber(telefonen);
        customer.setEmail(email);
        customer.setBillingAddress(address);
        
        return customer;
    }
    
    public Customer preencherClienteResumido(String nomeCompleto, String tipoDocumento, String numeroDocumento, String idCliente){
        
        String [] nome = nomeCompleto.split(" ");
        
        Customer.DocumentTypeEnum enun = null;
        
        if(tipoDocumento != null){
            enun = Customer.DocumentTypeEnum.valueOf(tipoDocumento);
        }
        
        Customer customer =  preencherCliente(nome[0], nome[nome.length-1], enun, numeroDocumento, idCliente, null, null, null, null, new Address());
        
        return customer;
    }
    
    public Customer preencherClienteResumidoComEndereco(String primeiroNome, String ultimoNome, Customer.DocumentTypeEnum enun, String numeroDocumento, Address address){
        
        Customer customer =  preencherCliente(primeiroNome, ultimoNome, enun, numeroDocumento, null, null, null, null, null, address);
        
        return customer;
    }
    
    public CustomerBoleto preencherClienteBoleto(String nome, String numeroDocumento, String tipoDocumento, AddressBoleto address){
        CustomerBoleto customer = new CustomerBoleto();
        
        customer.setName(nome);
        customer.setDocumentNumber(numeroDocumento);
        customer.setDocumentType(CustomerBoleto.DocumentTypeEnum.fromValue(tipoDocumento));
        customer.setBillingAddress(address);
        
        return customer;
    }
    
    
    public Address preencherEndereco (String cidade, String complemento, String pais, String bairro, String numero, String cep, String uf, String rua){
        Address address = new Address();
        
        address.setCity(cidade);
        address.setComplement(complemento);
        address.setCountry(pais);
        address.setDistrict(bairro);
        address.setNumber(numero);
        address.setPostalCode(cep);
        address.setState(uf);
        address.setStreet(rua);
        
        return address;
    }
    
    public AddressBoleto preencherEnderecoBoleto (EnderecoRequest endereco){
        AddressBoleto address = new AddressBoleto();
        
        address.setCity(endereco.getCidade());
        address.setComplement(endereco.getComplemento());
        address.setDistrict(endereco.getBairro());
        address.setNumber(endereco.getNumero());
        address.setPostalCode(endereco.getCep());
        address.setState(endereco.getUf());
        address.setStreet(endereco.getRua());
        
        return address;
    }
    
}
