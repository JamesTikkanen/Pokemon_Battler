package repository;

import model.Type;
/**
 * Skapade denna klass för att kunna ladda json filer. vilket jag ej lyckades göra med med dom andra.
 * Enda lätta lösningen som jag hittade.
 */
public class AttackData {
    private String name;
    private Type type;
    private int accuracy;
    private int damage;

    public AttackData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
