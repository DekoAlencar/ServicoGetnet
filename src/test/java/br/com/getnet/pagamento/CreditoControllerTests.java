/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento;

import br.com.getnet.pagamento.controller.CreditoController;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author Densenvolvimento2
 */
public class CreditoControllerTests extends PagamentoApplicationTests{
    
    private MockMvc mockMvc;
    
    @Autowired
    private CreditoController controller;
    
    
    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    
}
