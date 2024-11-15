package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

	/**
	 * Creates and returns a PokemonTrainer instance.
	 * 
	 * @param name Name of the created trainer.
	 * @param team Team of the created trainer.
	 * @param pokedexFactory Factory to use for creating associated pokedex instance.
	 * @return Created trainer instance.
	 */
	PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory)
    {
        PokemonTrainer pokemonTrainer = new PokemonTrainer(name,team,pokedexFactory.createPokedex(null, null)) ;
        return pokemonTrainer ;
    }	
}
