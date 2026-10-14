package model;

import java.util.ArrayList;

public class Pokemon {
    private static int totalCreated = 0;

    private String name;
    private Type type;
    private int maxHp;
    private int currentHp;
    private ArrayList<Attack> attacks = new ArrayList<>();

    public Pokemon(){}

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

    public int getWins() {
        return wins;
    }

    public int getLoss() {
        return loss;
    }

    public void addWins() {
        wins++;
    }

    public void addLoss() {
        loss++;
    }

    public void setStats(int wins, int loss) {
        this.wins = wins;
        this.loss = loss;
    }


    @Override
    public String toString() {
        return name + " [" + type.getLable() + "] " + currentHp + "/" + maxHp + ":❤\uFE0F" +
                "\n| W: " + getWins() + " | L: " + getLoss() + " |";
    }
}

