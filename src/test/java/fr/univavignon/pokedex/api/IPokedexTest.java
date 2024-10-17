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

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokedexTest {

    @Mock
    private Pokemon bulbizarre;
    @Mock
    private Pokemon aquali;

    @InjectMocks
    private IPokedex pokedex;

    private List<Pokemon> pokemons;

    @Before
    public void setUp() {
        pokemons = new ArrayList<>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);
        
        when(bulbizarre.getIndex()).thenReturn(0);
        when(bulbizarre.getName()).thenReturn("Bulbizarre");
        when(bulbizarre.getCp()).thenReturn(613);
        when(bulbizarre.getAttack()).thenReturn(126);
        when(bulbizarre.getDefense()).thenReturn(126);
        when(bulbizarre.getStamina()).thenReturn(90);
        when(bulbizarre.getCp()).thenReturn(613);
        when(bulbizarre.getHp()).thenReturn(64);
        when(bulbizarre.getDust()).thenReturn(4000);
        when(bulbizarre.getCandy()).thenReturn(4);
        when(bulbizarre.getIv()).thenReturn(0.56);

        when(aquali.getIndex()).thenReturn(133);
        when(aquali.getName()).thenReturn("Aquali");
        when(aquali.getAttack()).thenReturn(186);
        when(aquali.getDefense()).thenReturn(168);
        when(aquali.getStamina()).thenReturn(260);
        when(aquali.getCp()).thenReturn(2729);
        when(aquali.getHp()).thenReturn(202);
        when(aquali.getDust()).thenReturn(5000);
        when(aquali.getCandy()).thenReturn(4);
        when(aquali.getIv()).thenReturn(1.00);

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
        when(pokedex.getPokemons(cpComparator)).thenAnswer(invocation -> {
            pokemons.sort(cpComparator);
            return pokemons;
        });

        List<Pokemon> sortedPokemons = pokedex.getPokemons(cpComparator);
        assertEquals(aquali, sortedPokemons.get(0)); /* Cp(Aquali) > CP(Bulbizarre) */
        assertEquals(bulbizarre, sortedPokemons.get(1));
    }
}
