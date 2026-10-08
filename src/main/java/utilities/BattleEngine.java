package utilities;

import model.Attack;
import model.Pokemon;

import java.util.ArrayList;
import java.util.Random;

import static inputcheck.InputHelper.readInt;
import static repository.PokeData.wildPokeData;
import static ui.Main.pokedex;
import static ui.Main.scanner;
import static utilities.Utilities.showPokeData;

public class BattleEngine {
    public static Random random = new Random();

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

            ArrayList<Pokemon> wild = wildPokeData();
            bool = false;
        }
    }

    public static void battle(Pokemon player, Pokemon enemy) {
        System.out.println("\n|---------------------|\n" + player.getName() + " VS " + enemy.getName() + "\n");
        while (!player.isFainted() || !enemy.isFainted())
            chooseAttack(player);

    }

    public static Attack chooseAttack(Pokemon player) {

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
    public static Pokemon coinToss(Pokemon player, Pokemon enemy){
        int coin = random.nextInt(0,1);
        switch(coin){
            case 0 -> {return player;}
            case 1 -> {return enemy;}
        } return null;
    }
}
