import java.util.ArrayList;
import java.util.Arrays;

public class PokeData {

    public ArrayList<Pokemon> seedData(){
        ArrayList<Pokemon> pokeData = new ArrayList<>();

        Pokemon p1 = new Pokemon("PIKACHU", Type.ELECTRIC, 100, 100);
        p1.attacks.add(new Attack("THUNDERBOLT", 60, 80, Type.ELECTRIC));
        p1.attacks.add(new Attack("QUICK ATTACK", 40, 90, Type.NORMAL));

        Pokemon p2 = new Pokemon("CHARMANDER", Type.FIRE, 95, 95);
        p2.attacks.add(new Attack("EMBER", 60, 90, Type.FIRE));
        p2.attacks.add(new Attack("TAIL WHIP", 50, 85, Type.NORMAL));

        Pokemon p3 = new Pokemon("SQUIRTLE", Type.WATER, 105, 105);
        p3.attacks.add(new Attack("WATER GUN", 60, 90, Type.WATER));
        p3.attacks.add(new Attack("TACKLE", 45, 90, Type.NORMAL));

        Pokemon p4 = new Pokemon("BULBASAUR", Type.GRASS, 100, 100);
        p4.attacks.add(new Attack("VINE WHIP", 65, 90, Type.GRASS));
        p4.attacks.add(new Attack("TACKLE", 45, 90, Type.NORMAL));

        Pokemon p5 = new Pokemon("EEVEE", Type.NORMAL, 110, 110);
        p5.attacks.add(new Attack("TACKLE", 40, 90, Type.NORMAL));
        p5.attacks.add(new Attack("QUICK ATTCK", 40, 90, Type.NORMAL));

        Pokemon p6 = new Pokemon("SNORLAX", Type.NORMAL, 200, 200);
        p6.attacks.add(new Attack("BODY SLAM", 85, 75, Type.NORMAL));
        p6.attacks.add(new Attack("TACKLE", 45, 90, Type.NORMAL));

        pokeData.addAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
        return pokeData;
    }

    public void showPokeData() {

    }
}

