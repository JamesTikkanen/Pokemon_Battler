import java.util.ArrayList;

public class Pokemon {
    private String name;
    private Type type;
    private int maxHp;
    private int currentHp;
    private ArrayList<Attack> attacks = new ArrayList<>();

    public Pokemon() {
        this.attacks = new ArrayList<>();
    }

    public Pokemon(String name, Type type, int maxHp, int currentHp, ArrayList<Attack> attacks) {
        this.name = name;
        this.type = type;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.attacks = attacks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) System.out.println("Name cant be empty");
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public ArrayList<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(ArrayList<Attack> attacks) {
        if (attacks.isEmpty()) System.out.println("No attacks exists");
        this.attacks = attacks;
    }

    @Override
    public String toString() {
        return name + " [" + type + "] " + currentHp + "/" + maxHp + ":HP";
    }
}

