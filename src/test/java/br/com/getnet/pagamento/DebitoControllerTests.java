/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento;

import br.com.getnet.pagamento.controller.DebitoController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


public class DebitoControllerTests extends PagamentoApplicationTests{
   
    private MockMvc mockMvc;
    
    @Autowired
    private DebitoController controller;
    
    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    
    @Test
    public void testPOSTPagamentoDebitoController() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/pagamento").content(new String()));
    }
   
}
