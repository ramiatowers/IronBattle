public class Main {
    public static void main(String[] args) {
        Wizard Gandalf = new Wizard("Gandalf", 100, 10, 50);
        Wizard Saruman = new Wizard( "Saruman", 100, 10, 50);

//        Gandalf.fireBall(Saruman);
//        System.out.println(Saruman);
//        System.out.println(Gandalf);
//        Auxiliar.potion(Saruman);
//
//        Gandalf.staffHit(Saruman);
//        System.out.println(Saruman);
//        System.out.println(Gandalf);
//
//        Gandalf.recover(Saruman);
//        System.out.println(Saruman);
//        System.out.println(Gandalf);

        Gandalf.attackTest(Saruman);
        Saruman.attackTest(Gandalf);
        System.out.println(Saruman);
        System.out.println(Gandalf);


        Gandalf.attackTest(Saruman);
        Saruman.attackTest(Gandalf);
        System.out.println(Saruman);
        System.out.println(Gandalf);

        Auxiliar.potion(Gandalf);

        Gandalf.attackTest(Saruman);
        Saruman.attackTest(Gandalf);
        System.out.println(Saruman);
        System.out.println(Gandalf);

        Gandalf.attackTest(Saruman);
        Saruman.attackTest(Gandalf);
        System.out.println(Saruman);
        System.out.println(Gandalf);




    }
}