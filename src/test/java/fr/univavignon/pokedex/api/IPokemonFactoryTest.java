package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class IPokemonFactoryTest {
    
    @Mock
    private IPokemonFactory pokemonFactory;
    
    private Pokemon expectedPokemon;

    private Pokemon createdPokemon;

    @Before
    public void setUp() {
        expectedPokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        pokemonFactory = mock(IPokemonFactory.class); 
    }
    

    @Test
    public void testCreatePokemon() {
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(expectedPokemon);
    
        createdPokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(createdPokemon);

        /* Pas forcément utile.. */
        assertEquals(0, createdPokemon.getIndex());
        assertEquals(613, createdPokemon.getCp());
        assertEquals(64, createdPokemon.getHp());
        assertEquals(4000, createdPokemon.getDust());
        assertEquals(4, createdPokemon.getCandy());
    }


}
