package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Pokemon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static ui.Main.pokedexPath;

public class FileHandler {
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
