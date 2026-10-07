package ui;

import inputcheck.InputHelper;
import model.Pokemon;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import static utilities.Utilities.*;
import static repository.PokeData.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Pokemon> pokedex = new ArrayList<>();
    public static Path pokedexPath = Path.of("Pokedex.json");

    public static void main(String[] args) {

        Path pokedexPath = Path.of("Pokedex.json");
        if (Files.exists(pokedexPath)){
            System.out.println();
            pokedex = new ArrayList<>(loadFile(pokedexPath));
        } else {
            pokedex = pokeDataSeed();
            System.out.println("* No file found, seed data loaded *");
        }

        while (true) {
            System.out.println("\n---------------------\n-------POKÉDEX-------\n---------------------");
            System.out.println("[0] POKEMON BATTLER");
            System.out.println("[1] SHOW POKEDEX");
            System.out.println("[2] ADD POKEMON");
            System.out.println("[3] ADD ATTACK");
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
                case 0 -> {//meny val för pokemon battler
                    BattleMenu.battleMenu();
                }
                case 1 -> { //Om pokeList är tom går till menyval annars visas pokeList
                    showPokeData(pokedex);
                }
                case 2 -> { //Lägger till pokemon + en attack till pokeList.
                    addPokemon();
                }
                case 3 -> { //Lägger till en attack till en vald pokemon
                    addPokemonAttack(pokedex);
                }
                case 4 -> { //Kan söka efter en pokemon med ett namn
                    searchPokemon(pokedex);
                }
                case 5 -> { //Tar bort en pokemon från pokeList.
                    removePokemon(pokedex);
                }
                case 6 -> { //Sparar pokeList till en JSON fil.
                    saveFile(pokedexPath, pokedex);
                }
                case 7 -> { //Laddar fram en JSON fil om det finns till pokedex
                    loadFile(pokedexPath);
                }
                case 8 -> {//Återställer pokeList till seed data
                    pokedex = pokeDataSeed();
                    System.out.println("* Pokédex restored to seed data *");
                }
            }
        }
    }
}



