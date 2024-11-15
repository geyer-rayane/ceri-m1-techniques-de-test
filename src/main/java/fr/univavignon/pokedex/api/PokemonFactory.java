package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;

public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        try {
            PokemonMetaDataProvider metadataProvider = new PokemonMetaDataProvider();
            PokemonMetadata pokemonMetadata = metadataProvider.getPokemonMetadata(index);
            double iv = (pokemonMetadata.getAttack() + pokemonMetadata.getDefense() + pokemonMetadata.getStamina()) / 45;
            Pokemon pokemon = new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getStamina(), cp, hp, dust, candy, 0);
            return pokemon;
        } catch (PokedexException e) {
            throw new PokedexException("Failed to create Pokemon: " + e.getMessage());
        }
    }
}
