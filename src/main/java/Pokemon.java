import java.util.ArrayList;

public class Pokemon {
    private String name;
    private Type type;
    private int maxHp;
    private int currentHp;
    private ArrayList<Attack> attacks = new ArrayList<>();

    public Pokemon() {
    }

    public Pokemon(String name, Type type, int maxHp, int currentHp) {
        this.name = name;
        this.type = type;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("* Name cant be empty *");
            return;
        }
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getMaxHp() {
        if (maxHp < 1 || maxHp > 200) {
            System.out.println("* Must be between 1-200 *");
        }
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = maxHp;
    }

    public ArrayList<Attack> getAttack() {
        return attacks;
    }

    public void setAttacks(ArrayList<Attack> attacks) {
        if (attacks == null || attacks.isEmpty()) {
            System.out.println("* No attacks exists *");
            return;
        } else if (attacks.size() > 4) {
            System.out.println("* Can't have more than 4 attacks *");
            return;
        }
        this.attacks = attacks;
    }

    public void addAttack(Attack attack) {
        this.attacks.add(attack);
    }

    @Override
    public String toString() {
        return name + " [" + type + "] " + currentHp + "/" + maxHp + ":HP";
    }

}

