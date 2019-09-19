/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.controller;

import br.com.getnet.pagamento.client.ApiException;
import br.com.getnet.pagamento.client.JSON;
import br.com.getnet.pagamento.model.CustomerInfo;
import br.com.getnet.pagamento.model.CustomerInfoResponse;
import br.com.getnet.pagamento.request.ClienteRequest;
import br.com.getnet.pagamento.service.ApiService;
import javax.xml.ws.RequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="v1/public/cliente")
public class ClienteController {
    
    @Autowired
    private ApiService apiService;
    
    
    @PostMapping(value = "/cadastar", produces = "application/json")
    public CustomerInfoResponse cadastrar(@RequestBody ClienteRequest request) {
        return apiService.cadastrarCliente(request);
    }
 
    @GetMapping(value = "/{idCliente}")
    public CustomerInfo getCliente(@PathVariable(value = "idCliente") String idClente){
        return apiService.retonarCliente(idClente);
    }
    
//    @GetMapping(value = "lista/{pagina}/{}")
}
