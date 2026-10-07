package utilities;

import inputcheck.InputHelper;
import model.Attack;
import model.Pokemon;
import model.Type;

import java.util.ArrayList;

import static ui.Main.pokedex;
import static ui.Main.scanner;

public class Utilities {

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

    public static void addPokemon() {
        System.out.println("\n---Add a Pokémon.--");
        String name = InputHelper.readString(scanner, "Write Pokémon name: ");
        Type type = InputHelper.readType(scanner);
        int maxHp = InputHelper.readIntHp(scanner, "Write HP 0-200: ");
        int currentHp = maxHp;

        Pokemon newPokemon = new Pokemon(name, type, maxHp, currentHp);

        System.out.println("\n--Add an attack--");
        newPokemon.addAttack(addAttack());
        pokedex.add(newPokemon);
        System.out.println("* Added a new pokemon *");
    }

    public static Attack addAttack() {
        String name = InputHelper.readString(scanner, "Write attack name: ");
        Type type = InputHelper.readType(scanner);
        int damage = InputHelper.readIntDamAcc(scanner, "Write damage 1-100: ");
        int accuracy = InputHelper.readIntDamAcc(scanner, "Write accuracy 1-100: ");
        Attack newAttack = new Attack(name, damage, accuracy, type);
        return newAttack;
    }

    public static void addPokemonAttack(ArrayList<Pokemon> pokedex) {
        showPokeData(pokedex);
        System.out.println("Choose index of the pokemon to add an attack to");
        while (true) {
            int index = InputHelper.readInt(scanner, "Write choice: ");
            if (index < 0 || index >= pokedex.size()) {
                System.out.println("* Invalid index *");
                continue;
            }
            Pokemon target = pokedex.get(index);
            if (target.getAttack().size() >= 4) {
                System.out.println("* Can't add more than 4 attacks *");
                return;
            }
            target.addAttack(addAttack());
            return;
        }
    }

    public static void searchPokemon(ArrayList<Pokemon> pokedex) {
        String search = InputHelper.readString(scanner, "Enter name to search: ");
        for (Pokemon p : pokedex) {
            if (p.getName().equalsIgnoreCase(search)) {
                System.out.println("Pokémon " + p.getName() + " found");
                return;
            }
        }
        System.out.println("No Pokémon found with the name: " + search);
    }

    public static void removePokemon(ArrayList<Pokemon> pokedex) {
        showPokeData(pokedex);
        while (true) {
            int iRemove = InputHelper.readInt(scanner, "Write index of the Pokémon to remove: ");
            if (iRemove < 0 || iRemove >= pokedex.size()) {
                System.out.println("* Invalid index *");
                continue;
            }
            pokedex.remove(iRemove);
            System.out.println("Pokemon removed from pokédex");
            return;
        }
    }
    public static void pokeBattleStats(){
        //hashmap för vinster och förluster per pokemon i pokedex
    }
}
