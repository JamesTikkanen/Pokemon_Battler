package model;

import java.util.ArrayList;

public class Pokemon {
    private static int totalCreated = 0;

    private String name;
    private Type type;
    private int maxHp;
    private int currentHp;
    private ArrayList<Attack> attacks = new ArrayList<>();

    public Pokemon() {
    }

    public Pokemon(String name, Type type, int maxHp, int currentHp) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("* Name can't be empty *");
        }
        if (maxHp <= 0 || maxHp > 200) {
            throw new IllegalArgumentException("* HP can only be 1-200 *");
        }
        if (type == null) {
            throw new IllegalArgumentException("* Type can't be null *");
        }
        if (currentHp < 0 || currentHp > maxHp) {
            throw new IllegalArgumentException("* Current hp must be between 0-200 *");
        }
        this.name = name;
        this.type = type;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getMaxHp() {
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

    public ArrayList<Attack> getAttacks() {
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

    public boolean isFainted() {
        return this.currentHp == 0;
    }


    private int wins;
    private int loss;

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return loss;
    }

    public void addWins() {
        wins++;
    }

    public void addLosses() {
        loss++;
    }

    public void setStats(int wins, int loss) {
        this.wins = wins;
        this.loss = loss;
    }


    @Override
    public String toString() {
        return name + " [" + type.getLable() + "] " + currentHp + "/" + maxHp + ":❤\uFE0F" +
                "\n W: " + getWins() + " | L: " + getLosses() + " ";
    }

}

