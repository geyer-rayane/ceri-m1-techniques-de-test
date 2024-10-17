package fr.univavignon.pokedex.api;

/**
 * Custom exception for pokemon related error.
 *
 * @author fv
 */
 public final class PokemonException extends Exception {

   /** Serialization index. **/
   private static final long serialVersionUID = 1L;

   /**
    * Default constructor.
    *
    * @param message Error message.
    * @see Exception#Exception(String)
    */
   public PokemonException(final String message) {
     super(message);
   }

 }
