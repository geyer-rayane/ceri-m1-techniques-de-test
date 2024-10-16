package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class IPokemonFactoryTest {

    @Mock
    private IPokemonFactory pokemonFactory;
    
    @Mock
    private Pokemon expectedPokemon;

    @Mock
    private Pokemon createdPokemon;

    @Before
    public void setUp() {
        pokemonFactory = mock(IPokemonFactory.class); 
        expectedPokemon = mock(Pokemon.class);
        createdPokemon = mock(Pokemon.class);
    }

    @Test
    public void testCreatePokemon() {
        int index = 1;
        int cp = 500;
        int hp = 150;
        int dust = 2000;
        int candy = 5;

        when(expectedPokemon.getIndex()).thenReturn(index);
        when(expectedPokemon.getCp()).thenReturn(cp);
        when(expectedPokemon.getHp()).thenReturn(hp);
        when(expectedPokemon.getDust()).thenReturn(dust);
        when(expectedPokemon.getCandy()).thenReturn(candy);
        when(expectedPokemon.getIv()).thenReturn(0.9); 

        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(expectedPokemon);
        
        createdPokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        assertNotNull(createdPokemon);

        assertEquals(index, createdPokemon.getIndex());
        assertEquals(cp, createdPokemon.getCp());
        assertEquals(hp, createdPokemon.getHp());
        assertEquals(dust, createdPokemon.getDust());
        assertEquals(candy, createdPokemon.getCandy());
    }
}
