public class Warrior extends Character implements Attacker {
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + " (Warrior) ataca a " + target.getName() + " con fuerza " + strength);
        target.setHp(target.getHp() - strength);
        if (target.getHp() <= 0) {
            target.setAlive(false);
            target.setHp(0);
            System.out.println(target.getName() + " ha muerto.");
        }
    }
}
