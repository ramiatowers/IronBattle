public class Auxiliar {
// ---------- UTILIDADES
/*
 hp random between 100-200 to warriors and 50-100 for wizards
 */
public static int topHP(int hp){
    if(hp < 100){
        System.out.println("Health can't be lower than 100; Health set up to 100");
        return 100;
    } else if (hp > 200) {
        System.out.println("Health can't be higher than 200; Health set up to 100");
        return 100;
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


// ---------- EXTRAS

public static int potion(Character c){
    int potion = c.getHp() + 5;
    c.setHp(potion);
    System.out.println('\n' + "------- Potion used! +5 in Health! -----------" + '\n');
    return c.getHp();
}


// ---------- EMBELLECEDOR
public static void textColor(String str){
    String yellow = "\u001B[33m";
    String reset = "\u001B[0m";
    System.out.println(yellow + str + reset);
}

}
