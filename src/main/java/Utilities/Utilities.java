package Utilities;

import data.PokeData;
import inputcheck.InputHelper;
import model.Attack;
import model.Pokemon;
import model.Type;

import java.util.ArrayList;

import static data.PokeData.showPokeData;
import static ui.Main.pokedex;
import static ui.Main.scanner;

public class Utilities {
    public static void addPokemon() {
        System.out.println("\n---Add a Pokémon.--");
        String name = InputHelper.readString(scanner, "Write Pokémon name: ");
        Type type = InputHelper.readType(scanner);
        int maxHp = InputHelper.readIntHp(scanner, "Write HP 1-200: ");
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

    public static void editPokemon(ArrayList<Pokemon> pokedex) {
        if (pokedex.isEmpty()) {
            System.out.println("* Pokédex is empty *");
            return;
        }
        System.out.println("\n--Edit a Pokémon--\n");
        showPokeData(pokedex);
        System.out.println("\nChoose index of the Pokémon to edit");
        int index;
        while (true) {
            index = InputHelper.readInt(scanner, "Write choice: ");
            if (index < 0 || index >= pokedex.size()) {
                System.out.println("* Invalid index *");
                continue;
            }
            break;
        }
        Pokemon editPoke = pokedex.get(index);
        System.out.println("\n-------EDIT-------");
        System.out.println("[1] EDIT NAME");
        System.out.println("[2] EDIT TYPE");
        System.out.println("[3] EDIT HP");
        System.out.println("[4] EDIT ATTACK");
        System.out.println("[5] EXIT EDIT MENU");

        int choice = InputHelper.readInt(scanner, "Write choice: ");
        switch (choice) {
            case 1 -> {
                editPoke.setName(InputHelper.readString(scanner, "Write new name: "));
                System.out.println("Name added to Pokémon");
            }
            case 2 -> {
                editPoke.setType(InputHelper.readType(scanner));
                System.out.println("Type added to Pokémon");
            }
            case 3 -> {
                int hp = InputHelper.readIntHp(scanner, "Write new HP 1-200: ");
                editPoke.setMaxHp(hp);
                editPoke.setCurrentHp(hp);
                System.out.println("HP added to Pokémon");
            }
            case 4 -> {
                editAttack(editPoke);
            }
            case 5 -> {
                System.out.println("Returning to start");
                return;
            }
            default -> System.out.println("* Invalid choice *");
        }
    }

    public static void editAttack(Pokemon editPoke) {
        System.out.println("[1] ADD ATTACK\n[2] REMOVE ATTACK\n[3] EXIT TO POKÉDEX");
        int choice = InputHelper.readInt(scanner, "Write choice: ");
        switch (choice) {
            case 1 -> {
                if (editPoke.getAttack().size() >= 4) {
                    System.out.println("* 4 attacks already exists *");
                    editAttack(editPoke);
                }
                editPoke.addAttack(addAttack());
                System.out.println("Attack added");
            }
            case 2 -> {
                System.out.println();
                if (editPoke.getAttack().size() <= 1) {
                    System.out.println("* Only 1 attack exists, can't delete * ");
                    return;
                }
                int i = 0;
                for (Attack a : editPoke.getAttack()) {
                    System.out.println("Index[" + i + "] \n" + a);
                    i++;
                }
                while (true) {
                    int iRemove = InputHelper.readInt(scanner, "Write index: ");
                    if (iRemove < 0 || iRemove >= editPoke.getAttack().size()) {
                        System.out.println("* Invalid choice *");
                        continue;
                    }
                    editPoke.getAttack().remove(iRemove);
                    System.out.println("Attack removed");
                    return;
                }
            }
            case 3 -> {
                break;
            }
            default -> {
                System.out.println("* Invalid choice *");
                editAttack(editPoke);
            }
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
    public static void removePokemon(ArrayList<Pokemon> pokedex){
        showPokeData(pokedex);
        while(true) {
            int iRemove = InputHelper.readInt(scanner, "Write index of the Pokémon to remove: ");
            if(iRemove < 0 || iRemove >= pokedex.size()){
                System.out.println("* Invalid index *");
                continue;
            }
            pokedex.remove(iRemove);
            System.out.println("Pokemon removed from pokédex");
            return;
        }
    }
}
