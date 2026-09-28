import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Path pokedexPath = Path.of("Pokedex.json");
        if (Files.exists(pokedexPath)) {
            System.out.println();

        } else {
            //PokeData.seedData();
            System.out.println("\n*NO FILE FOUND. SEED DATA LOADED.");
        }

        while (true) {
            System.out.println("\n*******POKEMON*******\n*******BATTLER*******");
            System.out.println("[0] POKEMON BATTLE");
            System.out.println("[1] SHOW POKEDEX");
            System.out.println("[2] ADD POKEMON");
            System.out.println("[3] EDIT POKEMON");
            System.out.println("[4] REMOVE POKEMON");
            System.out.println("[5] SAVE TO FILE");
            System.out.println("[6] LOAD FILE");
            System.out.println("[7] RESET TO SEED");
            System.out.println("[8] EXIT PROGRAM");
            int input = InputHelper.readInt(scanner, "[*] ENTER CHOISE: ");
            if (input < 0 || input > 8) {
                System.out.println("*INCORRECT CHOICE. ONLY (1-8)\n");
                continue;
            } else if (input == 8) {
                if (input == 8) {
                    System.out.println("CLOSING PROGRAM...");
                    break;
                }
            }
            switch (input) {
                case 0 -> {//Pokemon battler
                }
                case 1 -> { //Om pokeList är tom går till menyval annars visas pokeList
                }
                case 2 -> { //Lägger till pokemon + en attack till pokeList.
                }
                case 3 -> { //Kan ändra Namn, hp, type och ta bort eller lägga till Attack.
                }
                case 4 -> { //Tar bort en pokemon från pokeList.
                }
                case 5 -> { //Sparar pokeList till en JSON fil.
                }
                case 6 -> { //Laddar fram en JSON fil om det finns till pokeList
                }
                case 7 -> { //Återställer pokeList till seedData
                }
            }
        }
    }
}

