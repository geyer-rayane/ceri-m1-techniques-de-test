package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokedexTest {

    private Pokemon bulbizarre;
    private Pokemon aquali;

    @Mock
    private IPokedex pokedex;

    private List<Pokemon> pokemons;

    @Before
    public void setUp() {
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.00);

        pokemons = new ArrayList<>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);
        
        pokedex = Mockito.mock(IPokedex.class);
        when(pokedex.getPokemons()).thenReturn(pokemons);
    }

    @Test
    public void testSize() {
        when(pokedex.size()).thenReturn(2);
        assertEquals(2, pokedex.size());
    }


    @Test
    public void testAddPokemon() {
        when(pokedex.addPokemon(bulbizarre)).thenReturn(0);
        int index = pokedex.addPokemon(bulbizarre);
        assertEquals(0, index);
        verify(pokedex, times(1)).addPokemon(bulbizarre);
    }
 
    @Test
    public void testGetPokemon() throws PokedexException {
        when(pokedex.getPokemon(0)).thenReturn(bulbizarre);
        Pokemon pokemon = pokedex.getPokemon(0);
        assertEquals(bulbizarre, pokemon);
        verify(pokedex, times(1)).getPokemon(0);
    }

    /* Peut être le décaler dans la classe Pokemon factory => à l'instanciation vérifier l'ID ? */
    @Test(expected = PokedexException.class)
    public void testGetPokemonInvalidId() throws PokedexException {
        when(pokedex.getPokemon(200)).thenThrow(new PokedexException("Invalid ID. ID must be between 0 and 150"));
        pokedex.getPokemon(200);
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> result = pokedex.getPokemons();
        assertEquals(2, result.size());
        assertEquals(bulbizarre, result.get(0));
        assertEquals(aquali, result.get(1));
        verify(pokedex, times(1)).getPokemons();
    }

    @Test
    public void testGetPokemonsSorted() {
        Comparator<Pokemon> cpComparator = Comparator.comparingInt(Pokemon::getCp);
        List<Pokemon> sortedPokemons = new ArrayList<>();
        
        sortedPokemons.add(aquali);
        sortedPokemons.add(bulbizarre);

        when(pokedex.getPokemons(cpComparator)).thenReturn(Arrays.asList(aquali,bulbizarre));
        assertEquals(sortedPokemons,pokedex.getPokemons(cpComparator));

    }

}
