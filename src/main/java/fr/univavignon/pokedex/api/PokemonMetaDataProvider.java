package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;



public class PokemonMetaDataProvider implements IPokemonMetadataProvider {

    private Map<Integer, PokemonMetadata> metadataMap;

    public PokemonMetaDataProvider() {
        metadataMap = new HashMap<>();
        metadataMap.put(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        metadataMap.put(3, new PokemonMetadata(133, "Aquali", 186, 168, 260));
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