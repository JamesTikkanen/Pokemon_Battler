package model;

public abstract class Attack {

    private final String name;
    private final Type type;
    //private final int damage;
    private final int accuracy;

    protected Attack(String name, int damage, int accuracy, Type type) {
        if (name == null || name.isBlank()) {
            System.out.println("* Name can't be empty *");
        }else if (accuracy <= 0 || accuracy > 100) {
            System.out.println("* Accuracy can only be 1-100 *");
        }
        this.name = name;
        this.type = type;
        //this.damage = damage;
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }
    /*
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("* Name can't be empty *");
            return;
        }
        this.name = name;
    }*/

    public Type getType() {
        return type;
    }

    public int getAccuracy() {
        return accuracy;
    }
/*
    public void setAccuracy(int accuracy) {
        if (accuracy < 1 || accuracy > 100) {
            System.out.println("* Accuracy must be between 1-100 *");
            return;
        }
        this.accuracy = accuracy;
    }*/

    @Override
    public String toString() {
        return name + " [" + type.getLable() + "] " + ":dmg " + accuracy + ":acc";
    }
}
