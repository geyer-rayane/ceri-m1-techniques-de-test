package fr.univavignon.pokedex.api;
import org.junit.Test;
import org.junit.Before;

public class IPokemonFactoryTest {
	
	public IPokemonFactory intFactory ; 
	public Pokemon pokemon ;
	
	@Before
	public void setup()
	{
		pokemon = intFactory.createPokemon(0, 0, 0, 0, 0) ;
 
	}

	@Test
	public void idNumberVerification()
	{
		//assertEquals(pokemon.getIndex()) ;
	}
	

}
