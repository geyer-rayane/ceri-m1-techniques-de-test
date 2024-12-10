package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IRocketPokemonFactoryTest {

    private RocketPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemon() {
        Pokemon pokemon = pokemonFactory.createPokemon(0, 500, 60, 4000, 3);
        assertEquals(0, pokemon.getIndex());
        assertEquals(500, pokemon.getCp());
    }

    @Test
    public void testCreatePokemonWithIndex() {
        Pokemon pokemon = pokemonFactory.createPokemon(133, 1000, 120, 5000, 10);
        assertEquals(133, pokemon.getIndex());
        assertEquals(1000, pokemon.getCp());
        assertEquals(120, pokemon.getHp());
        assertEquals(5000, pokemon.getDust());
        assertEquals(10, pokemon.getCandy());
    }

    @Test
    public void testCreatePokemonInvalidIndex() {
        Pokemon pokemon = pokemonFactory.createPokemon(-1, 500, 60, 4000, 3);
        assertEquals("Ash's Pikachu", pokemon.getName());
    }

    @Test
    public void testCreatePokemonWithIndexToHigh() {
        Pokemon pokemon = pokemonFactory.createPokemon(155, 500, 60, 4000, 3);
        assertEquals("MISSINGNO", pokemon.getName());
    }
}