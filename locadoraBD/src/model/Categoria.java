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
public class Categoria {
    private String sigla;
    private String Categoria;

    public String getNomeCategoria() {
        return Categoria;
    }

    public void setNomeCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }   
}