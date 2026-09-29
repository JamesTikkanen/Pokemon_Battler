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
            //PokeData.seedData();
            System.out.println("\n*NO FILE FOUND. SEED DATA LOADED.");
        }*/
        pokedex = PokeData.pokeDataSeed();
        while (true) {
            System.out.println("\n*******POKEMON*******\n*******BATTLER*******");
            System.out.println("[0] POKEMON BATTLE");
            System.out.println("[1] SHOW POKEDEX");
            System.out.println("[2] ADD POKEMON");
            System.out.println("[3] EDIT POKEMON");
            System.out.println("[4] SEARCH POKEMON");
            System.out.println("[5] REMOVE POKEMON");
            System.out.println("[6] SAVE TO FILE");
            System.out.println("[7] LOAD FILE");
            System.out.println("[8] RESET TO SEED");
            System.out.println("[9] EXIT PROGRAM");
            int input = InputHelper.readInt(scanner, "[*] ENTER CHOICE: ");
            if (input < 0 || input > 9) {
                System.out.println("* Incorrect choice, only 0-9 *\n");
                continue;
            } else if (input == 9) {
                System.out.println("CLOSING PROGRAM...");
                break;
            }
            switch (input) {
                case 0 -> {//Pokemon battler
                }
                case 1 -> { //Om pokeList är tom går till menyval annars visas pokeList
                    PokeData.showPokeData(pokedex);
                }
                case 2 -> { //Lägger till pokemon + en attack till pokeList.
                    addPokemon();
                }
                case 3 -> { //Kan ändra Namn, hp, type och ta bort eller lägga till Attack.
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
        System.out.println("-Add a Pokémon");
        String name = InputHelper.readString(scanner, "Write name: ");
        Type type = InputHelper.readType(scanner);
        int maxHp = InputHelper.readIntHp(scanner, "Write HP 1-200: ");
        int currentHp = maxHp;

        Pokemon newPokemon = new Pokemon(name, type, maxHp, currentHp);

        System.out.println("\n-Add an attack");
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
}


