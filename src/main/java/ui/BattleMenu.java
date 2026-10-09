package ui;

import inputcheck.InputHelper;
import model.Type;
import utilities.BattleEngine;

import static ui.Main.scanner;
import static utilities.BattleEngine.pokedexBattle;
import static utilities.BattleEngine.wildBattle;

public class BattleMenu {
    public static void battleMenu() {

        while (true) {
            System.out.println("\n--------POKÉMON--------\n--------BATTLER--------\n");
            System.out.println("[1] BATTLE WILD POKEMON");
            System.out.println("[2] BATTLE POKÉDEX");
            System.out.println("[3] BATTLE HISTORY");
            System.out.println("[4] EXIT POKÉMON BATTLER");
            int choice = InputHelper.readInt(scanner, "Write choice: ");
            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice");
                continue;
            }
            switch (choice) {
                case 1 -> {//Slås mot en slumpvald vild pokemon
                    wildBattle();
                }
                case 2 -> { //Slås mot en pokemon i pokedex
                    pokedexBattle();
                }
                case 3 -> { //Visar vinster och förluster

                }
                case 4 -> { //Kan ändra Namn, hp, type och ta bort eller lägga till model.Attack.
                    System.out.println("Returning to Pokédex");
                    return;
                }
            }
        }
    }
}
