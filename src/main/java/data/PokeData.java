package data;

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

        Pokemon p1 = new Pokemon("Pikachu", Type.ELECTRIC, 100, 100);
        p1.addAttack(new Attack("Thunderbolt", 60, 80, Type.ELECTRIC));
        p1.addAttack(new Attack("Quick attack", 40, 90, Type.NORMAL));

        Pokemon p2 = new Pokemon("Charmander", Type.FIRE, 95, 95);
        p2.addAttack(new Attack("Ember", 60, 90, Type.FIRE));
        p2.addAttack(new Attack("Tail whip", 50, 85, Type.NORMAL));

        Pokemon p3 = new Pokemon("Squirtle", Type.WATER, 105, 105);
        p3.addAttack(new Attack("Water gun", 60, 90, Type.WATER));
        p3.addAttack(new Attack("Tackle", 45, 90, Type.NORMAL));

        Pokemon p4 = new Pokemon("Bulbasaur", Type.GRASS, 100, 100);
        p4.addAttack(new Attack("Vine whip", 65, 90, Type.GRASS));
        p4.addAttack(new Attack("Tackle", 45, 90, Type.NORMAL));

        Pokemon p5 = new Pokemon("Eevee", Type.NORMAL, 110, 110);
        p5.addAttack(new Attack("Tackle", 40, 90, Type.NORMAL));
        p5.addAttack(new Attack("Qucik attack", 40, 90, Type.NORMAL));

        Pokemon p6 = new Pokemon("Snorlax", Type.NORMAL, 200, 200);
        p6.addAttack(new Attack("Body slam", 85, 75, Type.NORMAL));
        p6.addAttack(new Attack("Tackle", 45, 90, Type.NORMAL));


        pokeDataSeed.addAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
        return pokeDataSeed;
    }

    //Visar dom pokemons som finns i listan.
    public static void showPokeData(ArrayList<Pokemon> pokeData) {
        if (pokeData == null || pokeData.isEmpty()) {
            System.out.println("* Pokedex is empty *");
            return;
        }
        for (int i = 0; i < pokeData.size(); i++) {
            Pokemon poke = pokeData.get(i);
            System.out.println("\nINDEX [" + i + "] " + poke);
            for (Attack a : poke.getAttack()) {
                System.out.println("  - " + a);
            }
        }
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
}

