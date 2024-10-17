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

public class IPokemonMetadataProviderTest {
    
    @Mock
    private IPokemonMetadataProvider metadataProvider;

    private PokemonMetadata pokemonMetadata;

    @Before
    public void setup() {
        metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        when(metadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadata);
        PokemonMetadata testPokemon=iPokemonMetadataProvider.getPokemonMetadata(0);
        assertNotNull(testPokemon);
        assertEquals(0, testPokemon.getInde));
        assertEquals(90, testPokemon.getStamina());
        assertEquals("Bulbizarre", testPokemon.getName());
        assertEquals(126, testPokemon.getAttack());
        assertEquals(126, testPokemon.getDefense());
    }
}
        
