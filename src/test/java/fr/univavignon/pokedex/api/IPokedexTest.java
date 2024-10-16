package fr.univavignon.pokedex.api;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon pokemon;

    @BeforeEach
    public void setUp() {
        pokedex = Mockito.mock(IPokedex.class);
        pokemon = new Pokemon(1, "Pikachu", 55, 40, 35, 500, 35, 1000, 25, 0.9);
    }

    @Test
    public void testAddPokemon() {
        when(pokedex.addPokemon(pokemon)).thenReturn(0);
        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index);
        verify(pokedex).addPokemon(pokemon);
    }

    @Test
    public void testGetPokemon()
    {
        pokedex.addPokemon(pokemon);
        when(pokedex.getPokemon(0).thenReturn(0));
        int index = pokedex.getPokemon(0);
        assertEquals(0,index)
        verify(pokedex).getPokemon(0);    
    }
}
