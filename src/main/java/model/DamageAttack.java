package model;

public class DamageAttack extends Attack {
    private final int damage;

    /**
     * Denna klass är de som gör skada
     */
    public DamageAttack(String name, int damage, int accuracy, Type type) {
        super(name, accuracy, type);
        if (damage <= 0 || damage > 100) {
            throw new IllegalArgumentException("* Damage can only be 1-100 *");
        }
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
    //Påverkar effektiviteten på skadan
    public static double getTypeMultiplier(Type atk, Type def) {
        if (atk == Type.FIRE && def == Type.GRASS) return 2.0;
        if (atk == Type.WATER && def == Type.FIRE) return 2.0;
        if (atk == Type.GRASS && def == Type.WATER) return 2.0;
        if (atk == Type.ELECTRIC && def == Type.WATER) return 2.0;

        if (atk == Type.GRASS && def == Type.FIRE) return 0.5;
        if (atk == Type.FIRE && def == Type.WATER) return 0.5;
        if (atk == Type.WATER && def == Type.GRASS) return 0.5;
        if (atk == Type.ELECTRIC && def == Type.GRASS) return 0.5;

        return 1.0;
    }
    //Går över execute i Attack klassen och gör själva skadan mot hp
    @Override
    public void execute(Pokemon attacker, Pokemon target) {
        double mult = getTypeMultiplier(getType(), target.getType());
        double converter = Math.round(damage * mult);
        int finalDamage = (int) converter;

        int oldHp = target.getCurrentHp();
        target.takeDamage(finalDamage);

        System.out.println(attacker.getName() + " uses " + getName() + " [" + damage + " dmg] on " + target.getName());
        if(mult>1) System.out.println("It's super effective! 2x damage! ");
        else if(mult<1) System.out.println("It's not effective... 0.5x damage! ");
        System.out.println(target.getName() + " takes damage: " + oldHp + " hp -> " + target.getCurrentHp() + " hp");
    }
    //Text för attack
    @Override
    public String toString(){
        return getName() + " [" + getType().getLable() + "] " + damage + ":dmg " + getAccuracy() + ":acc";
    }
}
