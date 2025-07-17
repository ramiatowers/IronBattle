public class Warrior extends Character implements Attacker{
    private int  strength;
    private int stamina;


    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
    }

    @Override
    public void attack(Character target) {

    }
}
