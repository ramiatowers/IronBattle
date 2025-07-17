
import java.util.Random;


public class Wizard extends Character implements Attacker {



    private int mana;
    private int intelligence;
    Random r = new Random();



    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, topHP(hp));
        this.mana = topMana(mana);
        this.intelligence = topIntelligence(intelligence);
        System.out.println("Character created! " + toString());

    }


//    GETTERS & SETTERS


    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

//         CHECKERS

    public static int topHP(int hp){
        if(hp < 50 ){
            System.out.println("Health can't be lower than 50; Health set up to 50");
            return 50;
        } else if (hp > 100) {
            System.out.println("Health can't be higher than 100; Health set up to 50");
            return 50;
        }else{
            return hp;
        }
    }

    public static int topMana(int mana){
        if(mana < 10){
            System.out.println("Mana can't be lower than 10; Mana set up to 10");
            return 10;
        } else if (mana > 50) {
            System.out.println("Mana can't be higher than 50; Mana set up to 10");
            return 10;
        }else{
            return mana;
        }
    }

    public static int topIntelligence(int intelligence){
        if(intelligence < 1){
            System.out.println("Intelligence can't be lower than 1; Intelligence set up to 1");
            return 1;
        } else if (intelligence > 50) {
            System.out.println("Intelligence can't be higher than 50; Mana set up to 1");
            return 1;
        }else{
            return intelligence;
        }
    }

    //    MÉTHOD DESDE ATTACKER

   /*
    Wizards are the masters of the arcane their main attribute is intelligence.
    Every round a wizard will try to randomly cast either a Fireball or a Staff hit.

    If a wizard does not have the mana to cast a Fireball he will do a Staff hit instead.

    If a wizard does not have the mana to cast a Staff hit he will not inflict any damage and recover his mana by 2.

  ----------------------------------------------------------

    dos funciones individuales que tengan el otro character como parámetro y eso luego ya para attack()
    OJO que casi te dejas la de recover

    usar variantes ya creadas de intellegence y mana

    FIREBALL  The damage of a Fireball is equal to his intelligence
    and every Fireball will decrease their mana by 5 points.

    STAFF HIT The damage of a staff hit is equal to 2.
    Every staff hit will recover his mana by 1.

    RECOVER If a wizard does not have the mana to cast a Staff hit
    he will not inflict any damage and recover his mana by 2.

    Tengo que quitar hp del oponente (setter y getters)
    Tendría que crear una variable que escoja random entre uno y otro ¿? >> ifelseo ¿? do while¿? switch ¿?

     */

//    PELEA
    @Override
    public void attack(Character target) {

    }


//    public void prova(){
//        boolean prova = r.nextBoolean();
//        String answer;
//        if(prova){
//            answer = "Sí soy";
//        }else{
//            answer = "Wait what";
//        }
//        System.out.println(answer);
//    }
    public void attackTest(Character target){
        int typeAttack = r.nextInt(2);

        //Comprobar si está vivo o no
        if(target.getHp() <= 0){
            target.setAlive(false);
        }

        //escoger ataque (aleatorio a ver si sale esto)
        switch (typeAttack){
            case 0:
                if(getMana() >= 5 ){
                    fireBall(target);
                }else{
                    staffHit(target);
                }
                break;
            case 1:
                if(getMana() >= 2){
                    staffHit(target);
                }else if(getMana() <= 0){
                    recover(target);
                }
                break;
            default:
                System.out.println("Aren't you like dead or something");
                break;
        }


    }

    public void fireBall(Character opponent){
        int damage = opponent.getHp() - intelligence;
        opponent.setHp(damage);
        setMana(getMana() - 5);
        System.out.println(" >> FIREBALL! " + opponent.getName() +  " took a damage of: " + damage + ". Your Mana is at: " + getMana());
    }

    public void staffHit(Character opponent){
        int damage = opponent.getHp() - 2;
        opponent.setHp(damage);
        setMana(getMana() + 1);
        System.out.println(" >> STAFF HIT! " + opponent.getName() +  " took a damage of: " + damage + " +1 Mana. Your Mana is at: " + getMana());
    }

    public void recover(Character opponent){
        int recover = getMana() + 2;
        setMana(recover);
        System.out.println(" >> MISSED HIT! +2 Mana. Your Mana is at: " + getMana());

    }



//    VISUALIZADORES


    @Override
    public String toString() {
        return
                '\n'+ "Character type: Wizard" + '\n'+
                "-------------------------------" + '\n'+
                "Name: " + getName() + '\n'+
                "Health: " + super.getHp() + '\n'+
                "Mana: " + mana + '\n'+
                "Intelligence: " + intelligence  + '\n';
    }
}
