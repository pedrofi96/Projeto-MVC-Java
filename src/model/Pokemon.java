/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author francisleide
 */
public class Pokemon {
    private String nome;
    private String categoria;
    private String habilidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if(validarCategoria(categoria)){
            this.categoria = categoria;
        }
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }
    
    public boolean validarCategoria(String categoria){
        if(categoria.equalsIgnoreCase("lagarto") || 
                categoria.equalsIgnoreCase("semente") ||
                categoria.equalsIgnoreCase("pássaro")){
            return true;
        }
        return false;
    }
    
    
}
