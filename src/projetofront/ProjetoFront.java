/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetofront;

import controller.PokemonsController;
import views.CadastroPokemon;
import views.ListaPokemons;

/**
 *
 * @author francisleide
 */
public class ProjetoFront {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CadastroPokemon cadastroPokemon = new CadastroPokemon();
        ListaPokemons listaPokemons = new ListaPokemons();
        cadastroPokemon.setVisible(true);
        PokemonsController pController = new PokemonsController(cadastroPokemon, listaPokemons);
    }
    
}
