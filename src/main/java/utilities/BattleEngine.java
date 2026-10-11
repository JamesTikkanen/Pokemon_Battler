package utilities;

import model.Attack;
import model.Pokemon;

import java.util.Random;

import static inputcheck.InputHelper.readInt;
import static repository.PokeData.wildPokeData;
import static repository.StatsFile.saveStatsFile;
import static ui.Main.pokedex;
import static ui.Main.scanner;
import static utilities.Utilities.showPokeData;

public class BattleEngine {
    private static Random random = new Random();

    public static void wildBattle() {
        Pokemon player = choosePokemon();
        int wildRandom = random.nextInt(0, wildPokeData().size());
        Pokemon enemy = wildPokeData().get(wildRandom);
        battle(player, enemy);

    }

    public static void pokedexBattle() {
        Pokemon player = choosePokemon();
        System.out.println("\n------Choose Enemy------ ");
        Pokemon enemy = choosePokemon();
        battle(player, enemy);
    }

    private static Pokemon choosePokemon() {
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
            if (player.getAttack().isEmpty()) {
                System.out.println("* " + player.getName() + " has no attacks *");
                continue;
            }
            break;
        }
        return player;
    }

    private static void battle(Pokemon player, Pokemon enemy) {
        while (true) {
            System.out.println("\n|---------------------|\n" + player.getName() + " VS " + enemy.getName() + "\n");
            boolean playerTurn = coinToss(player, enemy) == player;
            System.out.println((playerTurn ? player.getName() : enemy.getName()) + " starts!");

            while (!player.isFainted() && !enemy.isFainted()) {
                System.out.println("\n___________________________________________________\n" + player + "\n" + enemy + "\n");

                if (playerTurn) {
                    useAttack(player, chooseAttack(player), enemy);
                } else {
                    Attack a = enemy.getAttack().get(random.nextInt(0, enemy.getAttack().size()));
                    useAttack(enemy, a, player);
                }
                for (int i = 0; i < 3; i++) {
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
                player.addLoss();
                saveStatsFile(pokedex);
                break;
            } else if (enemy.isFainted()) {
                System.out.println("\n😁 You won!");
                player.addWins();
                saveStatsFile(pokedex);
                break;
            }
        }
    }

    private static Attack chooseAttack(Pokemon player) {
        System.out.println("Choose attack to use");
        int i = 0;
        for (Attack a : player.getAttack()) {
            System.out.println("[" + i + "] " + a);
            i++;
        }
        while (true) {
            int attackChoice = readInt(scanner, "Write choice: ");
            if (attackChoice < 0 || attackChoice >= player.getAttack().size()) {
                System.out.println("* Invalid index *");
                continue;
            }
            return player.getAttack().get(attackChoice);
        }
    }

    private static void useAttack(Pokemon attacker, Attack attack, Pokemon target) {
        if (random.nextInt(0, 101) > attack.getAccuracy()) {
            System.out.println(attacker.getName() + " uses " + attack.getName() + "... missed attack!");
            return;
        }
        attack.execute(attacker, target);
    }

    private static Pokemon coinToss(Pokemon player, Pokemon enemy) {
        return random.nextInt(0, 2) == 0 ? player : enemy;
    }
}
