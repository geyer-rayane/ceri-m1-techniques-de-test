package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon mockPokemon;

    @BeforeEach
    public void setUp() {
        pokedex = Mockito.mock(IPokedex.class);
        mockPokemon = Mockito.mock(Pokemon.class);
    }

    @Test
    public void testAddPokemon() {
        when(pokedex.addPokemon(mockPokemon)).thenReturn(0);
        int index = pokedex.addPokemon(mockPokemon);
        assertEquals(0, index);
        verify(pokedex).addPokemon(mockPokemon); 
    }
}
