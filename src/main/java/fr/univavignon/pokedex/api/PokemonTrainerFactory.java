package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        // Validate input arguments
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Trainer name cannot be null or empty.");
        }
        if (team == null) {
            throw new IllegalArgumentException("Trainer team cannot be null.");
        }
        if (pokedexFactory == null) {
            throw new IllegalArgumentException("PokedexFactory cannot be null.");
        }
        IPokemonMetadataProvider metadataProvider = new PokemonMetaDataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory(); 
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        return new PokemonTrainer(name, team, pokedex);
    }
}

