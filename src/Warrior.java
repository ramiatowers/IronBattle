import java.util.Random;

public class Warrior extends Character implements Attacker{
    private int  strength;
    private int stamina;
    Random r = new Random();


    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, topHP(hp));
        this.stamina = topStamina(stamina);
        this.strength = topStrength(strength);
        System.out.println("Character created! " + this);

    }

//    GETTERS & SETTERS


    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    //         CHECKERS


    public static int topHP(int hp){
        if(hp < 100 ){
            System.out.println("Health can't be lower than 100; Health set up to 100");
            return 100;
        } else if (hp > 200) {
            System.out.println("Health can't be higher than 200; Health set up to 100");
            return 100;
        }else{
            return hp;
        }
    }

    public static int topStamina(int stamina){
        if(stamina < 10){
            System.out.println("Stamina can't be lower than 10; Stamina set up to 10");
            return 10;
        } else if (stamina > 50) {
            System.out.println("Stamina can't be higher than 50; Stamina set up to 10");
            return 10;
        }else{
            return stamina;
        }
    }

    public static int topStrength(int strength){
        if(strength < 1){
            System.out.println("Strength can't be lower than 1; Strength set up to 1");
            return 1;
        } else if (strength > 10) {
            System.out.println("Strength can't be higher than 10; Strength set up to 1");
            return 1;
        }else{
            return strength;
        }
    }

// ATTACKS
    /*


    The damage of a Heavy attack is equal to their strength and every hit will decrease their stamina by 5 points.
    The damage of a Weak attack is half of the strength (truncate decimals). Every Weak attack will recover his stamina by 1.
     */

    @Override
    public void attack(Character target) {

    }

    public void attackTest2(Character target){
        int typeAttack = r.nextInt(2);

        //Comprobar si está vivo o no
        if(target.getHp() <= 0){
            target.setAlive(false);
        }

        //escoger ataque (aleatorio a ver si sale esto)
        switch (typeAttack){
            case 0:
                if(getStamina() >= 5 ){
                    heavyAttack(target);
                }else{
                    weakAttack(target);
                }
                break;
            case 1:
                if(getStamina() >= 2){
                    weakAttack(target);
                }else if(getStamina() <= 0){
                    recover(target);
                }
                break;
            default:
                System.out.println("Aren't you like dead or something");
                break;

        }
    }



    public void heavyAttack(Character opponent){
        int damage = opponent.getHp() - strength;
        opponent.setHp(damage);
        setStamina(getStamina() - 5);
        System.out.println(" >> HEAVY ATTACK! " + opponent.getName() + " took a damage of: " + damage + ". Your stamina is at: " + getStamina());
    }

    public void weakAttack(Character opponent){
        double damage = opponent.getHp() - ((double) strength /2);
        opponent.setHp((int) damage);
        setStamina(getStamina() + 1);
        System.out.println(" >> WEAK ATTACK! " + opponent.getName() + " took a damage of: " + damage + ". Your stamina is at: " + getStamina());


    }

    public void recover(Character opponent){
        int recover = getStamina() + 2;
        setStamina(recover);
        System.out.println(" >> MISSED HIT! +2 Mana. Your Mana is at: " + getStamina());

    }



//    VISUALIZADORES


    @Override
    public String toString() {
        return '\n'+ "Character type: Warrior" + '\n'+
                "-------------------------------" + '\n'+
                "Name: " + getName() + '\n'+
                "Health: " + getHp() + '\n'+
                "Mana: " + strength + '\n'+
                "Intelligence: " + stamina + '\n';
    }
}
