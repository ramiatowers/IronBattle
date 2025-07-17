import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Character> personajes = new ArrayList<>();

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENÚ PRINCIPAL ---\n");
            System.out.println("1. Crear personaje");
            System.out.println("2. Ver personajes");
            System.out.println("3. Iniciar batalla");
            System.out.println("4. Salir\n");
            System.out.print("Elige una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> crearPersonaje();
                case "2" -> mostrarPersonajes();
                case "3" -> iniciarBatalla();
                case "4" -> {
                    System.out.println("¡Hasta pronto!");
                    continuar = false;
                }
                default -> System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

    static void crearPersonaje() {
        System.out.print("Nombre del personaje: ");
        String nombre = scanner.nextLine();

        System.out.print("Clase (1 = Warrior, 2 = Wizard): ");
        String tipo = scanner.nextLine();

        Character nuevo = null;

        if (tipo.equals("1")) {
            int hp = getRandom(100, 200);
            int stamina = getRandom(10, 50);
            int strength = getRandom(1, 10);
            nuevo = new Warrior(nombre, hp, stamina, strength);
        } else if (tipo.equals("2")) {
            int hp = getRandom(50, 100);
            int mana = getRandom(10, 50);
            int intelligence = getRandom(1, 50);
            nuevo = new Wizard(nombre, hp, mana, intelligence);
        } else {
            System.out.println("Clase no válida.");
            return;
        }

        personajes.add(nuevo);
        System.out.println("✅ Personaje creado: " + nombre + " (" + nuevo.getClass().getSimpleName() + ")");
    }

    static void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes aún.");
            return;
        }

        for (int i = 0; i < personajes.size(); i++) {
            Character c = personajes.get(i);
            System.out.println(i + " - " + c.getName() + " | HP: " + c.getHp() + " | Tipo: " + c.getClass().getSimpleName());
        }
    }

    static void iniciarBatalla() {
        if (personajes.size() < 2) {
            System.out.println("Necesitas al menos 2 personajes para pelear.");
            return;
        }

        mostrarPersonajes();

        System.out.print("Número del primer personaje: ");
        int i1 = Integer.parseInt(scanner.nextLine());

        System.out.print("Número del segundo personaje: ");
        int i2 = Integer.parseInt(scanner.nextLine());

        if (i1 == i2 || i1 < 0 || i2 < 0 || i1 >= personajes.size() || i2 >= personajes.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Character p1 = personajes.get(i1);
        Character p2 = personajes.get(i2);

        System.out.println("\n🧨 ¡COMIENZA LA BATALLA entre " + p1.getName() + " y " + p2.getName() + "!\n");

        while (p1.isAlive() && p2.isAlive()) {
            ((Attacker) p1).attack(p2);
            ((Attacker) p2).attack(p1);
            System.out.println("-- Estado: " + p1.getName() + " HP: " + p1.getHp() + " | " + p2.getName() + " HP: " + p2.getHp());
            System.out.println();
        }

        if (!p1.isAlive() && !p2.isAlive()) {
            System.out.println("⚠️ Empate. Ambos han muerto. Reiniciando batalla...\n");
            iniciarBatalla();
        } else {
            Character ganador = p1.isAlive() ? p1 : p2;
            System.out.println("🏆 ¡GANADOR: " + ganador.getName() + "!");
        }
    }

    static int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}