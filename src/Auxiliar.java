public class Auxiliar {
// ---------- UTILIDADES



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
