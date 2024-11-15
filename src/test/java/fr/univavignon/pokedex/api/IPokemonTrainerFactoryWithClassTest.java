package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IPokemonTrainerFactoryWithClassTest {

    private IPokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();
    private String trainerName = "Rayane";
    private Team trainerTeam = Team.MYSTIC;
    private IPokedexFactory pokedexFactoryInstance = new PokedexFactory();
    private PokemonMetaDataProvider pokemonMetadataProvider = new PokemonMetaDataProvider();
    private PokemonFactory pokemonFactoryInstance = new PokemonFactory();
    private IPokedex pokedexInstance = new Pokedex(pokemonMetadataProvider, pokemonFactoryInstance);

    @Test
    public void testCreateTrainer() {
        PokemonTrainer createdTrainer = trainerFactory.createTrainer(trainerName, trainerTeam, pokedexFactoryInstance);

        assertNotNull(createdTrainer);
        assertEquals(trainerName, createdTrainer.getName());
        assertEquals(trainerTeam, createdTrainer.getTeam());
        assertEquals(pokedexInstance.getClass(), createdTrainer.getPokedex().getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTrainerWithNullName() {
        trainerFactory.createTrainer(null, trainerTeam, pokedexFactoryInstance);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTrainerWithEmptyName() {
        trainerFactory.createTrainer("", trainerTeam, pokedexFactoryInstance);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTrainerWithNullTeam() {
        trainerFactory.createTrainer(trainerName, null, pokedexFactoryInstance);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTrainerWithNullPokedexFactory() {
        trainerFactory.createTrainer(trainerName, trainerTeam, null);
    }
}
