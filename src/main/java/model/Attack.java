package model;

public abstract class Attack {

    private final String name;
    private final Type type;
    private final int accuracy;

    protected Attack(String name, int accuracy, Type type) {
        if (name == null || name.isBlank()) {
            System.out.println("* Name can't be empty *");
        }else if (accuracy <= 0 || accuracy > 100) {
            System.out.println("* Accuracy can only be 1-100 *");
        }
        this.name = name;
        this.type = type;
        this.accuracy = accuracy;
    }

    public abstract void execute(Pokemon attacker, Pokemon target);

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getAccuracy() {
        return accuracy;
    }

    @Override
    public String toString() {
        return name + " [" + type.getLable() + "] " + accuracy + ":acc";
    }
}
