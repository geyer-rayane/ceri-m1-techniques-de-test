package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPokemonFactoryWithClassTest {

    private PokemonFactory pokemonFactory;
    private Pokemon expectedPokemon;
    private Pokemon createdPokemon;

    @Before
    public void setUp() {
        pokemonFactory = new PokemonFactory(); 
        expectedPokemon = new Pokemon(0, 126, 126, 90, 4,613,64,4000,4,0.56); 
    }

    @Test
    public void testCreatePokemon() {
        createdPokemon = pokemonFactory.createPokemon(0, 126, 126, 90, 4);
        assertNotNull(createdPokemon);
        assertEquals(expectedPokemon.getIndex(), createdPokemon.getIndex());
        assertEquals(expectedPokemon.getAttack(), createdPokemon.getAttack());
        assertEquals(expectedPokemon.getDefense(), createdPokemon.getDefense());
        assertEquals(expectedPokemon.getStamina(), createdPokemon.getStamina());
        assertEquals(expectedPokemon.getCandy(), createdPokemon.getCandy());
    }
}
