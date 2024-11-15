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
