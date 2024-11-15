package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPokedexFactoryWithClassTest {

    private PokedexFactory pokedexFactory;
    private PokemonMetaDataProvider metadataProvider;
    private PokemonFactory pokemonFactory;

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
