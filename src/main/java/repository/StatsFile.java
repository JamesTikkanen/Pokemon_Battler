package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Pokemon;
import model.Stats;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StatsFile {
    private static final Path statsPath = Path.of("Stats.json");
    private static ObjectMapper mapper = new ObjectMapper();

    public static void saveStatsFile(List<Pokemon> pokedex) {
        ArrayList<Stats> list = new ArrayList<>();
        for (Pokemon p : pokedex) {
            list.add(new Stats(p.getName(), p.getWins(), p.getLoss()));
        }
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(statsPath.toFile(), list);
        } catch (IOException e) {
            System.out.println("* Fel " + e.getMessage());
        }
    }

    public static void loadStatsFile(List<Pokemon> pokedex) {
        if (!Files.exists(statsPath)) {
            System.out.println("* No stats file found *");
            return;
        }
        try {
            Stats[] list = mapper.readValue(statsPath.toFile(), Stats[].class);
            for (Stats s : list) {
                for (Pokemon p : pokedex) {
                    if (p.getName().equalsIgnoreCase(s.getName())){
                        p.setStats(s.getWins(), s.getLosses());
                    }
                }
            }
            System.out.println("File loaded successfully");

        } catch (IOException e) {
            System.out.println("*NOT POSSIBLE TO LOAD\n" + e.getMessage());
        }
    }
}
