/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento;

import br.com.getnet.pagamento.controller.FinanceiroController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author Densenvolvimento2
 */
public class FinanceiroControllerTests extends PagamentoApplicationTests{
    private MockMvc mockMvc;
     
    @Autowired
    FinanceiroController controller;
    
    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    
    @Test
    public void testGetTransacoesFinanceiroController() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/"));
    }
    
    @Test
    public void testGetResumoFinanceiroController() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/resumo"));
    }
    
    @Test
    public void testGetTransacoesPorTipoFinanceiroController() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/").param("tipoTransaco", "C"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/").param("tipoTransaco", "D"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/").param("tipoTransaco", "B"));
    }
    
    @Test
    public void testGetTransacoesPorPeriodoFinanceiroController() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/").param("dataIncial", "2019-05-01")
                .param("dataFinal", "2019-05-09"));
    }
    
}
