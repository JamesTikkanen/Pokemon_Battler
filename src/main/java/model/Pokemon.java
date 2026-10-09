package model;

import java.util.ArrayList;

public class Pokemon {
    private static int totalCreated = 0;

    private final String name;
    private final Type type;
    private final int maxHp;
    private int currentHp;
    private ArrayList<Attack> attacks = new ArrayList<>();

    public Pokemon(String name, Type type, int maxHp, int currentHp) {
        if (name == null || name.isBlank()) {
            System.out.println("* Name can't be empty *");
        } else if (maxHp <= 0 || maxHp > 200) {
            System.out.println("* HP can only be 1-200 *");
        }
        this.name = name;
        this.type = type;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        totalCreated++;
    }

    public static int getTotalCreated() {
        return totalCreated;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getMaxHp() {
        if (maxHp < 0 || maxHp > 200) {
            System.out.println("* Must be between 1-200 *");
        }
        return maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int hp) {
        if (hp < 0) currentHp = 0;
        else if (hp > maxHp) currentHp = maxHp;
        else
            this.currentHp = hp;
    }

    public ArrayList<Attack> getAttack() {
        return attacks;
    }
    /*
    public void setAttack(ArrayList<Attack> attacks) {
        if (attacks == null || attacks.isEmpty()) {
            System.out.println("* No attacks exists *");
            return;
        } else if (attacks.size() > 4) {
            System.out.println("* Can't have more than 4 attacks *");
            return;
        } else if (attacks.size() < 1) {
            System.out.println("* Can't be less than 1 attack *");
        }
        this.attacks = attacks;
    }*/

    public void addAttack(Attack attack) {
        if (attacks.size() >= 4) {
            System.out.println("* Can't be more than 4 attacks *");
            return;
        }
        this.attacks.add(attack);
    }

    public void takeDamage(int amount) {
        if (amount < 0) {
            System.out.println("* Can't be less than 0 *");
            return;
        }
        this.currentHp = Math.max(0, this.currentHp - amount);
    }

    public void heal(int amount) {
        if (amount < 0) {
            System.out.println("* Can't be less than 0 *");
            return;
        }
        this.currentHp = Math.min(maxHp, this.currentHp + amount);
    }

    public Boolean isFainted() {
        return this.currentHp == 0;
    }

    private int wins;
    private int loss;

    public int getWins(){ return wins; }
    public int getLoss(){ return loss;}
    public void addWins(){ wins++; }
    public void addLoss(){ loss++; }

    @Override
    public String toString() {
        return name + " [" + type.getLable() + "] " + currentHp + "/" + maxHp + ":HP" +
                "\n| W: " + getWins() + " | L: " + getLoss() + " |";
    }
}

