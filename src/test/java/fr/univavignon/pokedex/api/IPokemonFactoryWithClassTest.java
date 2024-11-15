package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPokemonFactoryWithClassTest {

    private PokemonFactory pokemonFactory;
    private Pokemon createdPokemon;

    @Before
    public void setUp() {
        pokemonFactory = new PokemonFactory(); 
    }

    @Test
    public void testCreatePokemon() {
        createdPokemon = pokemonFactory.createPokemon(0, 126, 126, 90, 4);
        assertEquals(0, createdPokemon.getIndex());
        assertEquals(126, createdPokemon.getAttack());
        assertEquals(126, createdPokemon.getDefense());
        assertEquals(90, createdPokemon.getStamina());
        assertEquals(4, createdPokemon.getCandy());
    }
    

}
