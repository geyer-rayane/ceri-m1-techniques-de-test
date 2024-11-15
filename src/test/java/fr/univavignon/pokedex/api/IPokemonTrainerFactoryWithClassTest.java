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

public class IPokemonTrainerFactoryWithClassTest {
    
    private IPokemonTrainerFactory pokemonTrainerFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;
    private PokemonTrainer pokemonTrainer;

    private String name = "Rayane";
    private Team team = Team.MYSTIC;

    @Before
    public void setup() {
        pokedexFactory = new PokedexFactoryImpl();
        pokedex = pokedexFactory.createPokedex();
        pokemonTrainerFactory = new PokemonTrainerFactoryImpl();
        pokemonTrainer = new PokemonTrainer(name, team, pokedex);
    }

    @Test
    public void testCreateTrainer() {
        PokemonTrainer newPokemonTrainer = pokemonTrainerFactory.createTrainer(name, team, pokedexFactory);
        assertNotNull(newPokemonTrainer);
        assertEquals(name, newPokemonTrainer.getName());
        assertEquals(team, newPokemonTrainer.getTeam());
        assertSame(pokedex, newPokemonTrainer.getPokedex());
    }
}
