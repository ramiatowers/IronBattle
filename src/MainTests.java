public class MainTests {
    public static void main(String[] args) {
        Warrior Aragorn = new Warrior("Aragorn", 500,500,500);
        Wizard Gandalf = new Wizard("Gandalf", 500, 500,500);

        Aragorn.attackTest2(Gandalf);
        Gandalf.attackTest(Aragorn);
    }
}
