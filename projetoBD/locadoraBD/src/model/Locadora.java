/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Carlos
 */
public class Locadora {
    private String cnpj;
    private String cidade;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }   
}