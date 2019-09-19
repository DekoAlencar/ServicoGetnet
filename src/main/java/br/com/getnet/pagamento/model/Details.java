/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.model;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-25T16:02:55.559Z")
public class Details {
    
    @SerializedName("status")
    private String status;
    
    @SerializedName("error_code")
    private String codeErro;
    
    @SerializedName("description_detail")
    private String descriptionDetail;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodeErro() {
        return codeErro;
    }

    public void setCodeErro(String codeErro) {
        this.codeErro = codeErro;
    }

    public String getDescriptionDetail() {
        return descriptionDetail;
    }

    public void setDescriptionDetail(String descriptionDetail) {
        this.descriptionDetail = descriptionDetail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.status);
        hash = 29 * hash + Objects.hashCode(this.codeErro);
        hash = 29 * hash + Objects.hashCode(this.descriptionDetail);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Details other = (Details) obj;
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.codeErro, other.codeErro)) {
            return false;
        }
        if (!Objects.equals(this.descriptionDetail, other.descriptionDetail)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Details{" + "status=" + status + ", codeErro=" + codeErro + ", descriptionDetail=" + descriptionDetail + '}';
    }
    
}
