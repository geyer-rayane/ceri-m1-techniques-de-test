package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class IPokemonMetadataProviderTest {
/* 
    @Mock
    private IPokemonMetadataProvider metadataProvider;

    private PokemonMetadata pokemonMetadata;

    @BeforeEach
    public void setUp() {
        metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        if (!(0 <= pokemonMetadata.getIndex() && pokemonMetadata.getIndex() <= 150)) {
            throw new PokedexException("Invalid ID. ID must be between 0 and 150");
        }

        when(metadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadata);
        PokemonMetadata result = metadataProvider.getPokemonMetadata(0);
        assertEquals(pokemonMetadata, result);
    }
		*/
}
