package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPokedexFactoryWithClassTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokedexFactory = new PokedexFactory();
        metadataProvider = new PokemonMetaDataProvider();
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreatePokedex() {
        Pokedex createdPokedex = (Pokedex) pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(createdPokedex);
    }
}
