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

        Pokemon p1 = new Pokemon("Pikachu", Type.ELECTRIC, 140, 140);
        p1.addAttack(new Attack("Thunderbolt", 60, 80, Type.ELECTRIC));
        p1.addAttack(new Attack("Quick attack", 40, 90, Type.NORMAL));

        Pokemon p2 = new Pokemon("Charmander", Type.FIRE, 140, 140);
        p2.addAttack(new Attack("Ember", 60, 90, Type.FIRE));
        p2.addAttack(new Attack("Tail whip", 50, 85, Type.NORMAL));

        Pokemon p3 = new Pokemon("Squirtle", Type.WATER, 140, 140);
        p3.addAttack(new Attack("Water gun", 60, 90, Type.WATER));
        p3.addAttack(new Attack("Tackle", 45, 90, Type.NORMAL));

        Pokemon p4 = new Pokemon("Bulbasaur", Type.GRASS, 140, 140);
        p4.addAttack(new Attack("Vine whip", 65, 90, Type.GRASS));
        p4.addAttack(new Attack("Tackle", 45, 90, Type.NORMAL));

        Pokemon p5 = new Pokemon("Eevee", Type.NORMAL, 150, 150);
        p5.addAttack(new Attack("Tackle", 40, 90, Type.NORMAL));
        p5.addAttack(new Attack("Qucik attack", 40, 90, Type.NORMAL));

        Pokemon p6 = new Pokemon("Snorlax", Type.NORMAL, 200, 200);
        p6.addAttack(new Attack("Body slam", 85, 75, Type.NORMAL));
        p6.addAttack(new Attack("Tackle", 45, 90, Type.NORMAL));


        pokeDataSeed.addAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
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

    public static final ArrayList<Pokemon> wildPokemon(){
        ArrayList<Pokemon> wildPokeList = new ArrayList<>();
        Pokemon w1 = new Pokemon("Rattata",Type.NORMAL,130,130);
        w1.addAttack(new Attack("Bite",45,80,Type.NORMAL));
        w1.addAttack(new Attack("Tail whip",35,80,Type.NORMAL));

        Pokemon w2 = new Pokemon("Wulpix",Type.FIRE,140,140);
        w2.addAttack(new Attack("Fire burst",60,75,Type.FIRE));
        w2.addAttack(new Attack("Slash",45,85,Type.NORMAL));

        Pokemon w3 = new Pokemon("Oddish",Type.GRASS,130,130);
        w3.addAttack(new Attack("Vine whip",50,75,Type.GRASS));
        w3.addAttack(new Attack("Slam",40,80,Type.NORMAL));

        Pokemon w4 = new Pokemon("Psyduck",Type.WATER,140,140);
        w4.addAttack(new Attack("Water beam",50,80,Type.WATER));
        w4.addAttack(new Attack("Bite",40,80,Type.NORMAL));

        Pokemon w5 = new Pokemon("ElectaBuzz",Type.NORMAL,160,160);
        w5.addAttack(new Attack("Thunder strike",60,85,Type.ELECTRIC));
        w5.addAttack(new Attack("Slash",40,90,Type.NORMAL));

        wildPokeList.addAll(Arrays.asList(w1,w2,w3,w4,w5));
        return wildPokeList;
    }
}

