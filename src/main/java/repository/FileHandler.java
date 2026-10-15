package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Attack;
import model.DamageAttack;
import model.Pokemon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static void saveFile(Path path, List<Pokemon> pokedex) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<PokemonData> pokemonDataList = new ArrayList<>();
        for (Pokemon p : pokedex) {
            pokemonDataList.add(toData(p));
        }
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), pokemonDataList);
            System.out.println("Pokédex saved to file");
        } catch (IOException e) {
            System.out.println("* Invalid " + e.getMessage());
        }
    }

    public static List<Pokemon> loadFile(Path path) {
        ObjectMapper mapper = new ObjectMapper();
        if (!Files.exists(path)) {
            System.out.println("* No file found *");
            return new ArrayList<>();
        }
        try {
            PokemonData[] data = mapper.readValue(path.toFile(), PokemonData[].class);
            ArrayList<Pokemon> result = new ArrayList<>();
            for (PokemonData pd : data) {
                result.add(fromData(pd));
            }
            System.out.println("* File loaded *");
            return result;
        } catch (IOException e) {
            System.out.println("* Not possible to load file *\n" + e.getMessage() + " *");
            return new ArrayList<>();
        }
    }

    private static PokemonData toData(Pokemon p) {
        PokemonData pd = new PokemonData();
        pd.setName(p.getName());
        pd.setType(p.getType());
        pd.setMaxHp(p.getMaxHp());
        pd.setCurrentHp(p.getCurrentHp());

        for (Attack a : p.getAttacks()) {
            if (a instanceof DamageAttack da) {
                AttackData ad = new AttackData();
                ad.setName(da.getName());
                ad.setDamage(da.getDamage());
                ad.setAccuracy(da.getAccuracy());
                ad.setType(da.getType());
                pd.getAttacks().add(ad);
            }
        }
        return pd;
    }

    private static Pokemon fromData(PokemonData pd) {
        Pokemon p = new Pokemon(pd.getName(), pd.getType(), pd.getMaxHp(), pd.getCurrentHp());
        for (AttackData ad : pd.getAttacks()){
            p.addAttack(new DamageAttack(ad.getName(), ad.getDamage(), ad.getAccuracy(), ad.getType()));
        }
        return p;
    }
}
