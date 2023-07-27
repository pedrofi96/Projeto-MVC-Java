/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Pokemon;
import views.CadastroPokemon;
import views.ListaPokemons;

/**
 *
 * @author francisleide
 */
// implementar interface ActionListener para que seja possível escutar 
// os eventos de telas
public class PokemonsController implements ActionListener {

    //criar atributos do controller: todas as views pertinentes ao model 
    // relacionadas ao controller
    private CadastroPokemon cadastroPokemon;
    private ListaPokemons listaPokemons;
    private ArrayList<Pokemon> pokemons;

    public PokemonsController(CadastroPokemon cadastroPokemon, ListaPokemons listaPokemons) {
        this.cadastroPokemon = cadastroPokemon;
        this.listaPokemons = listaPokemons;
        //Mapear os botões que tenham ações na tela
        this.cadastroPokemon.btnSalvar.addActionListener(this);
        this.listaPokemons.btnCadastrar.addActionListener(this);
        //Instanciar a lista que vai ser nosso "banco de dados"
        this.pokemons = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // mapeamento do dos botões
        if (e.getSource() == this.cadastroPokemon.btnSalvar) {
            //capturando os dados da tela
            String nome = this.cadastroPokemon.txtNome.getText();
            String categoria = this.cadastroPokemon.txtCategoria.getText();
            String habilidade = this.cadastroPokemon.txtHabilidade.getText();

            // instanciar um objeto da classe Pokemon
            Pokemon pokemon = new Pokemon();
            pokemon.setHabilidade(habilidade);
            pokemon.setNome(nome);
            if (!pokemon.validarCategoria(categoria)) {
                JOptionPane.showMessageDialog(null, "Categoria inválida");
            } else {
                pokemon.setCategoria(categoria);
            }
            this.pokemons.add(pokemon);
            for (Pokemon pokemon1 : pokemons) {
                System.out.println("pokemon: " + pokemon1.getNome());
            }
            this.cadastroPokemon.dispose();
            construirTabela(this.listaPokemons.tabelaPokemons);
            this.listaPokemons.setVisible(true);
            

        }
        if(e.getSource() == this.listaPokemons.btnCadastrar){
            this.cadastroPokemon.setVisible(true);
            this.listaPokemons.dispose();
        }
    }

    public void construirTabela(JTable tabela) {
        DefaultTableModel table = new DefaultTableModel();
        tabela.setModel(table);
        table.addColumn("Nome");
        table.addColumn("Categoria");
        table.addColumn("Habilidade");

        Object[] colunas = new Object[3];
        for (Pokemon pokemon : pokemons) {
            colunas[0] = pokemon.getNome();
            colunas[1] = pokemon.getCategoria();
            colunas[2] = pokemon.getHabilidade();
            table.addRow(colunas);
        }
    }

}
