package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class IPokedexWithClassTest {

    private IPokedex pokedex;
    private PokemonMetaDataProvider metaDataProvider;
    private PokedexFactory pokedexFactory;
    private PokemonFactory pokemonFactory;
    private Pokemon bulbizarre;
    private Pokemon aquali;

    @Before
    public void setUp() {
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.00);
        
        metaDataProvider = new PokemonMetaDataProvider();
        pokedexFactory = new PokedexFactory(); 
        pokemonFactory = new PokemonFactory();

        pokedex = pokedexFactory.createPokedex(metaDataProvider, pokemonFactory);
        pokedex.addPokemon(aquali);
        pokedex.addPokemon(bulbizarre);
    }

    @Test
    public void testSize() {
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        int index1 = pokedex.addPokemon(bulbizarre);
        int index2 = pokedex.addPokemon(aquali);

        assertEquals(0, index1);
        assertEquals(1, index2);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);

        Pokemon pokemon1 = pokedex.getPokemon(0);
        Pokemon pokemon2 = pokedex.getPokemon(1);

        assertEquals(bulbizarre, pokemon1);
        assertEquals(aquali, pokemon2);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonInvalidId() throws PokedexException {
        pokedex.getPokemon(100);
    }

    @Test
    public void testGetPokemons() {
        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);

        List<Pokemon> result = pokedex.getPokemons();

        assertEquals(2, result.size());
        assertEquals(bulbizarre, result.get(0));
        assertEquals(aquali, result.get(1));
    }

    @Test
    public void testGetPokemonsSorted() {
        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);
        Comparator<Pokemon> cpComparator = Comparator.comparingInt(Pokemon::getCp);
        List<Pokemon> sortedPokemons = pokedex.getPokemons(cpComparator);
        assertEquals(aquali, sortedPokemons.get(0)); // Aquali a un CP plus élevé
        assertEquals(bulbizarre, sortedPokemons.get(1));
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = pokedex.getPokemonMetadata(0);
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        pokedex.getPokemonMetadata(999); // Index invalide
    }
}
