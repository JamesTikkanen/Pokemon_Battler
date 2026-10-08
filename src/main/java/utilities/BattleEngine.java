package utilities;

import model.Attack;
import model.Pokemon;

import java.util.Random;

import static inputcheck.InputHelper.readInt;
import static repository.PokeData.wildPokeData;
import static ui.Main.pokedex;
import static ui.Main.scanner;
import static utilities.Utilities.showPokeData;

public class BattleEngine {
    private static final Random random = new Random();

    public static void wildBattle() {
        boolean bool = true;
        showPokeData(pokedex);

        while (bool) {
            int pokeChoice = readInt(scanner, "Choose index of the pokemon for battle\nWrite choice: ");
            if (pokeChoice < 0 || pokeChoice >= pokedex.size()) {
                System.out.println("* Invalid choice *");
                continue;
            }
            Pokemon player = pokedex.get(pokeChoice);
            if (player.isFainted()) {
                System.out.println("* " + player.getName() + " is fainted *");
                continue;
            }

            int wildRandom = random.nextInt(0, wildPokeData().size());
            Pokemon enemy = wildPokeData().get(wildRandom);

            battle(player, enemy);
        }
    }

    public static void battle(Pokemon player, Pokemon enemy) {
        System.out.println("\n|---------------------|\n" + player.getName() + " VS " + enemy.getName() + "\n");
        chooseAttack(player);

    }

    public static void chooseAttack(Pokemon player) {
        System.out.println("Choose attack to use");
        int i = 0;
        for (Attack a : player.getAttack()) {
            System.out.println("[" + i + "]");
            System.out.println("-" + a);
            i++;
        }
    }
}
