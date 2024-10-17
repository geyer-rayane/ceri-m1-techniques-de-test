package fr.univavignon.pokedex.api;
import fr.univavignon.pokedex.api.*;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class IPokedexFactoryTest {

    @Mock
    private IPokedexFactory pokedexFactory;
    
    @Mock
    private IPokemonMetadataProvider metadataProvider;
    
    @Mock
    private IPokemonFactory pokemonFactory;
    
    @Mock
    private IPokedex pokedex;

    @Before
    public void setUp() {
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
	}


    @Test
    public void testCreatePokedex() {
        pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);
        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(createdPokedex);
        assertEquals(pokedex, createdPokedex);
        verify(pokedexFactory).createPokedex(metadataProvider, pokemonFactory);
    }

}
