/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.request;

import br.com.getnet.pagamento.model.Order;
import java.math.BigDecimal;
import java.math.MathContext;


public class CompraRequest {
    
    private String idCompra;
    private Double imposto;
    private String tipoProduto;

    public String getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public Double getImposto() {
        return imposto;
    }

    public void setImposto(Double imposto) {
        this.imposto = imposto;
    }

    public Order.ProductTypeEnum getTipoProduto() {
        return Order.ProductTypeEnum.fromValue(tipoProduto);
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    
    
}
