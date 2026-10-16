package utilities;

import model.Attack;
import model.Pokemon;

import java.util.ArrayList;
import java.util.Random;

import static inputcheck.InputHelper.readInt;
import static repository.PokemonSeedData.wildPokeData;
import static repository.StatsFile.saveStatsFile;
import static ui.Main.pokedex;
import static ui.Main.scanner;
import static utilities.Utilities.showPokeData;

public class BattleEngine {
    private static final Random random = new Random();

    /**
     * Stridsmotorn som styr alla stridslogik
     */

    public static void wildBattle() { //Strid mot en slumpad vild pokemon.
        if(!notFainted(pokedex))return;
        Pokemon player = choosePokemon();
        int wildRandom = random.nextInt(0, wildPokeData().size()); //slumpar en fiende index
        Pokemon enemy = wildPokeData().get(wildRandom); //Ger ut den vilda med samma index
        battle(player, enemy);
    }

    public static void pokedexBattle() { //Strid mot en pokemon i sin egna pokedex.
        if(!notFainted(pokedex))return;
        Pokemon player = choosePokemon();
        Pokemon enemy;
        while (true) {
            System.out.println("\n------Choose Enemy------ ");
            enemy = choosePokemon();
            if (player == enemy) {
                System.out.println("* Can't fight yourself *");
                continue;
            }
            break;
        }
        battle(player, enemy);
    }

    private static Pokemon choosePokemon() { //Visar pokedex som användare får välja mellan med undantag
        showPokeData(pokedex);
        Pokemon player;
        while (true) {
            int pokeChoice = readInt(scanner, "\nChoose index of the pokemon for battle\nWrite choice: ");
            if (pokeChoice < 0 || pokeChoice >= pokedex.size()) {
                System.out.println("* Invalid choice *");
                continue;
            }
            player = pokedex.get(pokeChoice);
            if (player.isFainted()) {
                System.out.println("* " + player.getName() + " is fainted *");
                continue;
            }
            if (player.getAttacks().isEmpty()) {
                System.out.println("* " + player.getName() + " has no attacks *");
                continue;
            }
            break;
        }
        return player;
    }

    /**
     * Själva striden som sker mellan spelare och fiende.
     * Fortsätter till hp går till 0.
     * Uppdaterar vinst/förlust statistiken efter varje strid
     */
    private static void battle(Pokemon player, Pokemon enemy) {
        System.out.println("\n|---------------------|\n" + player.getName() + " VS " + enemy.getName() + "\n");
        boolean playerTurn = coinToss(player, enemy) == player;
        System.out.println((playerTurn ? player.getName() : enemy.getName()) + " starts!");

        while (!player.isFainted() && !enemy.isFainted()) {
            System.out.println("\n___________________________________________________\n" + player + "\n" + enemy + "\n");

            if (playerTurn) {
                useAttack(player, chooseAttack(player), enemy);
            } else {
                System.out.println("------");
                Attack a = enemy.getAttacks().get(random.nextInt(0, enemy.getAttacks().size()));
                useAttack(enemy, a, player);
                System.out.println("------");
            }
            for (int i = 0; i < 2; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("* Counter interrupted *");
                }
            }
            playerTurn = !playerTurn;
        }
        if (player.isFainted()) {
            System.out.println("\n🤕 You lost!");
            player.addLosses();
            saveStatsFile(pokedex);
        } else if (enemy.isFainted()) {
            System.out.println("\n😁 You won!");
            player.addWins();
            saveStatsFile(pokedex);
        }
    }

    private static Attack chooseAttack(Pokemon player) { //Användaren får välja en attack
        System.out.println("Choose attack to use");
        int i = 0;
        for (Attack a : player.getAttacks()) {
            System.out.println("⚔\uFE0F[" + i + "] " + a);
            i++;
        }
        while (true) {
            int attackChoice = readInt(scanner, "Write choice: ");
            if (attackChoice < 0 || attackChoice >= player.getAttacks().size()) {
                System.out.println("* Invalid index *");
                continue;
            }
            return player.getAttacks().get(attackChoice);
        }
    }

    private static void useAttack(Pokemon attacker, Attack attack, Pokemon target) {//Om attack träffar blir det skada
        if (random.nextInt(0, 100) > attack.getAccuracy()) {//Om man har otur missar man
            System.out.println(attacker.getName() + " uses " + attack.getName() + "... missed attack!");
            return;
        }//⚔️❤️
        attack.execute(attacker, target);
    }

    private static Pokemon coinToss(Pokemon player, Pokemon enemy) {//Början av alla strider slumpas det 50/50
        System.out.println("A coin toss to see who starts");
        return random.nextInt(0, 2) == 0 ? player : enemy;
    }


    private static boolean notFainted(ArrayList<Pokemon> pokedex) {//Kollar om det finns pokemon att strida med annars felmeddelande
        if (pokedex.isEmpty()) {
            System.out.println("* No Pokémons exists in Pokédex *");
            return false;
        }
        int faint = 0;
        for (Pokemon p : pokedex) {
            if (p.isFainted()) {
                faint++;
            }
        }
        if (faint == pokedex.size()) {
            System.out.println("* All of the Pokémons has fainted *");
            return false;
        }
        return true;
    }
}
