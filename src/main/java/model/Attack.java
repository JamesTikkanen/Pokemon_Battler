package model;

public class Attack {

    private String name;
    private Type type;
    private int damage;
    private int accuracy;

    public Attack() {
    }

    public Attack(String name, int damage, int accuracy, Type type) {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("* Name can't be empty *");
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage < 1 || damage > 100) {
            System.out.println("* Damage must be between 1-100 *");
            return;
        }
        this.damage = damage;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        if (accuracy < 1 || accuracy > 100) {
            System.out.println("* Accuracy must be between 1-100 *");
            return;
        }
        this.accuracy = accuracy;
    }

    @Override
    public String toString() {
        return name + " [" + type + "] " + damage + ":dmg " + accuracy + ":acc";
    }
}
