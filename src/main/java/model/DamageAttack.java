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
