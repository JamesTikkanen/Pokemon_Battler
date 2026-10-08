package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Attack;
import model.Pokemon;
import model.Type;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ui.Main.pokedexPath;

public class PokeData {
    public static final ArrayList<Pokemon> pokeDataSeed() {
        ArrayList<Pokemon> pokeDataSeed = new ArrayList<>();

        Pokemon pikachu = new Pokemon("Pikachu", Type.ELECTRIC, 140, 140);
        pikachu.addAttack(new Attack("Thunderbolt", 60, 80, Type.ELECTRIC));
        pikachu.addAttack(new Attack("Quick attack", 40, 90, Type.NORMAL));

        Pokemon charmander = new Pokemon("Charmander", Type.FIRE, 140, 140);
        charmander.addAttack(new Attack("Ember", 60, 90, Type.FIRE));
        charmander.addAttack(new Attack("Tail whip", 50, 85, Type.NORMAL));

        Pokemon squirtle = new Pokemon("Squirtle", Type.WATER, 140, 140);
        squirtle.addAttack(new Attack("Water gun", 60, 90, Type.WATER));
        squirtle.addAttack(new Attack("Tackle", 45, 90, Type.NORMAL));

        Pokemon bulbasaur = new Pokemon("Bulbasaur", Type.GRASS, 140, 140);
        bulbasaur.addAttack(new Attack("Vine whip", 65, 90, Type.GRASS));
        bulbasaur.addAttack(new Attack("Tackle", 45, 90, Type.NORMAL));

        Pokemon eevee = new Pokemon("Eevee", Type.NORMAL, 150, 150);
        eevee.addAttack(new Attack("Tackle", 40, 90, Type.NORMAL));
        eevee.addAttack(new Attack("Qucik attack", 40, 90, Type.NORMAL));

        Pokemon snorlax = new Pokemon("Snorlax", Type.NORMAL, 200, 200);
        snorlax.addAttack(new Attack("Body slam", 85, 75, Type.NORMAL));
        snorlax.addAttack(new Attack("Tackle", 45, 90, Type.NORMAL));


        pokeDataSeed.addAll(Arrays.asList(pikachu, charmander, squirtle, bulbasaur, eevee, snorlax));
        return pokeDataSeed;
    }

    public static void saveFile(Path path, List<Pokemon> pokedex) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(pokedexPath.toFile(), pokedex);
            System.out.println("Pokédex saved to file");
        } catch (IOException e) {
            System.out.println("Fel " + e.getMessage());
        }
    }

    public static List<Pokemon> loadFile(Path pokedexPath) {
        ObjectMapper mapper = new ObjectMapper();
        if (!Files.exists(pokedexPath)) {
            System.out.println("* No file found *");
            return new ArrayList<>();
        }
        try {
            Pokemon[] list = mapper.readValue(pokedexPath.toFile(), Pokemon[].class);
            System.out.println("File loaded successfully");
            return new ArrayList<>(List.of(list));
        } catch (IOException e) {
            System.out.println("*NOT POSSIBLE TO LOAD\n" + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static final ArrayList<Pokemon> wildPokeData(){
        ArrayList<Pokemon> wildPokeList = new ArrayList<>();
        Pokemon rattata = new Pokemon("Rattata",Type.NORMAL,130,130);
        rattata.addAttack(new Attack("Bite",45,80,Type.NORMAL));
        rattata.addAttack(new Attack("Tail whip",35,80,Type.NORMAL));

        Pokemon wulpix = new Pokemon("Wulpix",Type.FIRE,140,140);
        wulpix.addAttack(new Attack("Fire burst",60,75,Type.FIRE));
        wulpix.addAttack(new Attack("Slash",45,85,Type.NORMAL));

        Pokemon oddish = new Pokemon("Oddish",Type.GRASS,130,130);
        oddish.addAttack(new Attack("Vine whip",50,75,Type.GRASS));
        oddish.addAttack(new Attack("Slam",40,80,Type.NORMAL));

        Pokemon psyduck = new Pokemon("Psyduck",Type.WATER,140,140);
        psyduck.addAttack(new Attack("Water beam",50,80,Type.WATER));
        psyduck.addAttack(new Attack("Bite",40,80,Type.NORMAL));

        Pokemon electabuzz = new Pokemon("Electabuzz",Type.NORMAL,160,160);
        electabuzz.addAttack(new Attack("Thunder strike",60,85,Type.ELECTRIC));
        electabuzz.addAttack(new Attack("Slash",40,90,Type.NORMAL));

        wildPokeList.addAll(Arrays.asList(rattata,wulpix,oddish,psyduck,electabuzz));
        return wildPokeList;
    }
}

