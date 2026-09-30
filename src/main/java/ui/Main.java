package ui;

import data.PokeData;
import inputcheck.InputHelper;
import model.Attack;
import model.Pokemon;
import model.Type;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Pokemon> pokedex = new ArrayList<>();

    public static void main(String[] args) {

        /*Path pokedexPath = Path.of("Pokedex.json");
        if (Files.exists(pokedexPath)) {
            System.out.println();
        } else {
            //data.PokeData.seedData();
            System.out.println("\n*NO FILE FOUND. SEED DATA LOADED.");
        }*/

        pokedex = PokeData.pokeDataSeed();

        while (true) {
            System.out.println("\n---------------------\n-------POKÉDEX-------\n---------------------");
            System.out.println("[0] POKEMON BATTLER");
            System.out.println("[1] SHOW POKEDEX");
            System.out.println("[2] ADD POKEMON");
            System.out.println("[3] EDIT POKEMON");
            System.out.println("[4] SEARCH POKEMON");
            System.out.println("[5] REMOVE POKEMON");
            System.out.println("[6] SAVE TO FILE");
            System.out.println("[7] LOAD FILE");
            System.out.println("[8] RESET TO SEED");
            System.out.println("[9] EXIT PROGRAM");
            int input = InputHelper.readInt(scanner, "Write choice: ");
            if (input < 0 || input > 9) {
                System.out.println("* Incorrect choice, only 0-9 *\n");
                continue;
            } else if (input == 9) {
                System.out.println("CLOSING PROGRAM...");
                break;
            }
            switch (input) {
                case 0 -> {//model.Pokemon battler
                    BattleMenu.battleMenu();
                }
                case 1 -> { //Om pokeList är tom går till menyval annars visas pokeList
                    PokeData.showPokeData(pokedex);
                }
                case 2 -> { //Lägger till pokemon + en attack till pokeList.
                    addPokemon();
                }
                case 3 -> { //Kan ändra Namn, hp, type och ta bort eller lägga till model.Attack.
                    editPokemon(pokedex);
                }
                case 4 -> { //Kan söka efter en pokemon med ett namn
                }
                case 5 -> { //Tar bort en pokemon från pokeList.
                }
                case 6 -> { //Sparar pokeList till en JSON fil.
                }
                case 7 -> { //Laddar fram en JSON fil om det finns till pokeList
                }
                case 8 -> {//Återställer pokeList till seedData
                    pokedex = PokeData.pokeDataSeed();
                    System.out.println("* Pokédex restored to seed data *");
                }
            }
        }
    }

    public static void addPokemon() {
        System.out.println("--Add a Pokémon--");
        String name = InputHelper.readString(scanner, "Write name: ");
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
        String name = InputHelper.readString(scanner, "Write name: ");
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
        PokeData.showPokeData(pokedex);
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
        System.out.println("Edit: Name | model.Type | HP | model.Attack\nPress 'Q' to exit");
        String choice = InputHelper.readString(scanner, "Write choice: ").toUpperCase();
        switch (choice) {
            case "NAME" -> {
                editPoke.setName(InputHelper.readString(scanner, "Write new name: "));
                System.out.println("Edit added to Pokémon");
            }
            case "TYPE" -> {
                editPoke.setType(InputHelper.readType(scanner));
                System.out.println("Edit added to Pokémon");
            }
            case "HP" -> {
                int hp = InputHelper.readIntHp(scanner, "Write new HP 1-200: ");
                editPoke.setMaxHp(hp);
                editPoke.setCurrentHp(hp);
                System.out.println("Edit added to Pokémon");
            }
            case "ATTACK" -> {
                editAttack(editPoke);
            }
            case "Q" -> {
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
}



