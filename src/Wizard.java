public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + " (Wizard) lanza hechizo a " + target.getName() + " con poder " + intelligence);
        target.setHp(target.getHp() - intelligence);
        if (target.getHp() <= 0) {
            target.setAlive(false);
            target.setHp(0);
            System.out.println(target.getName() + " ha muerto.");
        }
    }
}