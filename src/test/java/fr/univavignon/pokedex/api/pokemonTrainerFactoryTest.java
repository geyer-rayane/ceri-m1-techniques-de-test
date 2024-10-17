package fr.univavignon.pokedex.api;
import org.mockito.Mock;

import fr.univavignon.pokedex.api.*;


public class pokemonTrainerFactoryTest {
   
	@Mock
	private pokemonTrainerFactory pokemonTrainerFactory;

	@Mock
	private IPokedexFactory pokedexFactory;
    
	@Mock
	private IPokedex pokedex;

	@Mock
	private PokemonTrainer pokemonTrainer;

	private String name = "Rayane";
    private Team team = Team.MYSTIC;


@Before
public void setup() {
    pokemonTrainerFactory = mock(pokemonTrainerFactory.class);
    pokedexFactory = mock(IPokedexFactory.class);
    pokedex = mock(IPokedex.class);
    pokemonTrainer = new PokemonTrainer(name,team,pokedex);
}


@Test
public void testCreateTrainer() {
    when(pokemonTrainerFactory.createTrainer(name, team, pokedexFactory)).thenReturn(pokemonTrainer);
    PokemonTrainer newPokemonTrainer = pokemonTrainerFactory.createTrainer(name, team, pokedexFactory);
    assertNotNull(newPokemonTrainer);
    assertEquals(name,newPokemonTrainer.getName());
    assertEquals(team,newPokemonTrainer.getTeam());
    assertEquals(pokedex,newPokemonTrainer.getPokede);

}