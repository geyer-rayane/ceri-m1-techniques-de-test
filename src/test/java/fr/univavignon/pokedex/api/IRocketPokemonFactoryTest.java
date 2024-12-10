package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IRocketPokemonFactoryTest {

    private RocketPokemonFactory  rocketPokemonFactory;
    private Pokemon createdPokemon;

    @Before
    public void setUp() {
        rocketPokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemon() {
        createdPokemon = rocketPokemonFactory.createPokemon(0, 126, 126, 90, 4);
        assertEquals(0, createdPokemon.getIndex());
        assertEquals(126, createdPokemon.getAttack());
        assertEquals(126, createdPokemon.getDefense());
        assertEquals(90, createdPokemon.getStamina());
        assertEquals(4, createdPokemon.getCandy());
    }
    

}
