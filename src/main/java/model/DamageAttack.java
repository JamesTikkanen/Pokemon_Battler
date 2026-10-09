package model;

public class DamageAttack extends Attack {
    private final int damage;

    public DamageAttack(String name, int damage, int accuracy, Type type) {
        super(name, accuracy, type);
        if (damage <= 0 || damage > 100) {
            System.out.println("* Damage can only be 1-100 *");
        }
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    private static double getTypeMultiplier(Type atk, Type def) {
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

    @Override
    public void execute(Pokemon attacker, Pokemon target) {
        int oldHp = target.getCurrentHp();
        target.takeDamage(damage);
        System.out.println(attacker.getName() + " uses " + getName() + " [" + damage + " dmg] on " + target.getName());
        System.out.println(target.getName() + " takes damage: " + oldHp + " hp -> " + target.getCurrentHp() + " hp");
    }

    @Override
    public String toString(){
        return getName() + " [" + getType().getLable() + "] " + damage + ":dmg " + getAccuracy() + ":acc";
    }
}
