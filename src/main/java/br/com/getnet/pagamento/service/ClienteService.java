/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.service;

import br.com.getnet.pagamento.entidade.Cliente;
import br.com.getnet.pagamento.model.Customer;
import br.com.getnet.pagamento.model.CustomerBoleto;
import br.com.getnet.pagamento.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repositorio;
    
    public Cliente get(int id){
        return repositorio.findById(id);
    }
    
    public Cliente buscarClientePorDocumento(String documento){
        return repositorio.findByDocumento(documento);
    }
    
    public Cliente preencherCliente(String nome, String documento, String chave){
        Cliente cliente = buscarClientePorDocumento(documento);
        
        if(cliente == null){
            cliente = new Cliente();
            cliente.setNome(nome);
            cliente.setDocumento(documento);
            cliente.setChave_cliente(chave);
        }
        
        return cliente;
    }

    public Cliente customerBoletoToCliente(CustomerBoleto customer){
        Cliente cliente = buscarClientePorDocumento(customer.getDocumentNumber());
        
        if(cliente == null){
            cliente.setNome(customer.getName());
            cliente.setDocumento(customer.getDocumentNumber());
        }
        
        return repositorio.save(cliente);
    }
    
    public Cliente CustumerToCliente(Customer customer){
        Cliente cliente = buscarClientePorDocumento(customer.getDocumentNumber());

        if(cliente == null){
            cliente.setNome(customer.getName());
            cliente.setDocumento(customer.getDocumentNumber());
            cliente.setChave_cliente(customer.getCustomerId());
        }
        
        return repositorio.save(cliente);
    }
}
