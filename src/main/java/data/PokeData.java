package data;

import model.Attack;
import model.Pokemon;
import model.Type;

import java.util.ArrayList;
import java.util.Arrays;

public class PokeData {

    public static final ArrayList<Pokemon> pokeDataSeed() {
        ArrayList<Pokemon> pokeDataSeed = new ArrayList<>();

        Pokemon p1 = new Pokemon("PIKACHU", Type.ELECTRIC, 100, 100);
        p1.addAttack(new Attack("THUNDERBOLT", 60, 80, Type.ELECTRIC));
        p1.addAttack(new Attack("QUICK ATTACK", 40, 90, Type.NORMAL));

        Pokemon p2 = new Pokemon("CHARMANDER", Type.FIRE, 95, 95);
        p2.addAttack(new Attack("EMBER", 60, 90, Type.FIRE));
        p2.addAttack(new Attack("TAIL WHIP", 50, 85, Type.NORMAL));

        Pokemon p3 = new Pokemon("SQUIRTLE", Type.WATER, 105, 105);
        p3.addAttack(new Attack("WATER GUN", 60, 90, Type.WATER));
        p3.addAttack(new Attack("TACKLE", 45, 90, Type.NORMAL));

        Pokemon p4 = new Pokemon("BULBASAUR", Type.GRASS, 100, 100);
        p4.addAttack(new Attack("VINE WHIP", 65, 90, Type.GRASS));
        p4.addAttack(new Attack("TACKLE", 45, 90, Type.NORMAL));

        Pokemon p5 = new Pokemon("EEVEE", Type.NORMAL, 110, 110);
        p5.addAttack(new Attack("TACKLE", 40, 90, Type.NORMAL));
        p5.addAttack(new Attack("QUICK ATTACK", 40, 90, Type.NORMAL));

        Pokemon p6 = new Pokemon("SNORLAX", Type.NORMAL, 200, 200);
        p6.addAttack(new Attack("BODY SLAM", 85, 75, Type.NORMAL));
        p6.addAttack(new Attack("TACKLE", 45, 90, Type.NORMAL));


        pokeDataSeed.addAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
        return pokeDataSeed;
    }

        //Visar dom pokemons som finns i listan.
    public static void showPokeData(ArrayList<Pokemon> pokeData) {
        if (pokeData == null || pokeData.isEmpty()) {
            System.out.println("* Pokedex is empty *");
            return;
        }
        for (int i = 0; i < pokeData.size(); i++) {
            Pokemon poke = pokeData.get(i);
            System.out.println("\nINDEX [" + i + "] " + poke);
            for (Attack a : poke.getAttack()) {
                System.out.println("  - " + a);
            }
        }
    }
}

