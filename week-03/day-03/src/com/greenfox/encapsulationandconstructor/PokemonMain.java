package com.greenfox.encapsulationandconstructor;

import java.util.ArrayList;
import java.util.List;

public class PokemonMain {
    public static void main(String[] args) {
        List<Pokemon> pokemonOfAsh = initializePokemons();

        // Every pokemon has a name and a type.
        // Certain types are effective against others, e.g. water is effective against fire.

        // Ash has a few pokemon.
        // A wild pokemon appeared!

        Pokemon wildPokemon = new Pokemon("Oddish", "leaf", "water");

        // Which pokemon should Ash use?

       String name = "";
        for(Pokemon pokeName : pokemonOfAsh) {
           if (pokeName.effectiveAgainst.equals(wildPokemon.type)) {
               name = pokeName.name;
        System.out.print("I choose you, " + name);
           }
       }

    }

    private static List<Pokemon> initializePokemons() {
        List<Pokemon> pokemon = new ArrayList<>();

        pokemon.add(new Pokemon("Balbasaur", "leaf", "water"));
        pokemon.add(new Pokemon("Pikatchu", "electric", "water"));
        pokemon.add(new Pokemon("Charizard", "fire", "leaf"));
        pokemon.add(new Pokemon("Balbasaur", "water", "fire"));
        pokemon.add(new Pokemon("Kingler", "water", "fire"));

        return pokemon;
    }
}
