package repository;

import model.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Skapade denna klass för att kunna ladda json filer. vilket jag ej lyckades göra med med dom andra.
 * Enda lätta lösningen som jag hittade.
 */
public class PokemonData {
    public String name;
    public Type type;
    public int maxHp;
    public int currentHp;
    private List<AttackData> attacks = new ArrayList<>();

    public PokemonData() {
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

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public List<AttackData> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<AttackData> attacks) {
        this.attacks = attacks;
    }
}
