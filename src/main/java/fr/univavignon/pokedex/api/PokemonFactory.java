public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        Pokemon pokemon = new Pokemon(index, "pokemon", 0, 0, 0, cp, hp, dust, candy, 0);
        return pokemon ; // a revoir pour le nom par exemple..
    }
}