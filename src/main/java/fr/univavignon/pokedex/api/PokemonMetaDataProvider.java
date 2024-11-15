package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokemonMetaDataProvider implements IPokemonMetadataProvider {

    private Map<Integer, PokemonMetadata> metadataMap;

    public PokemonMetaDataProvider() {
        metadataMap = new HashMap<>();
        //Valeurs arbitraires
        metadataMap.put(1, new PokemonMetadata(1, "Bulbasaur", 49, 49, 45));
        metadataMap.put(2, new PokemonMetadata(2, "Ivysaur", 62, 63, 60));
        metadataMap.put(3, new PokemonMetadata(3, "Venusaur", 82, 83, 80));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (metadataMap.containsKey(index)) {
            return metadataMap.get(index);
        } else {
            throw new PokedexException("Invalid Pokemon index");
        }
    }
}