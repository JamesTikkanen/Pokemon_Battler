package model;

public abstract class Attack {

    private final String name;
    private final Type type;
    private final int accuracy;

    /**
     * Basklass
     * Innehåller det alla attacker delar (namn, typ, accuracy)
     * damage är i DamageAttack en subklass
     */
    protected Attack(String name, int accuracy, Type type) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("* Name can't be empty *");
        }
        if (accuracy <= 0 || accuracy > 100) {
            throw new IllegalArgumentException("* Accuracy can only be 1-100 *");
        }
        this.name = name;
        this.type = type;
        this.accuracy = accuracy;
    }
    //utför attack som DamageAttack override över
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
    //Text som visar attack
    @Override
    public String toString() {
        return name + " [" + type.getLable() + "] " + accuracy + ":acc";
    }
}
