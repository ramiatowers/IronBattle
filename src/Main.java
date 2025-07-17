import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENÚ PRINCIPAL ---\n");
            System.out.println("1. Crear personaje");
            System.out.println("2. Atacar");
            System.out.println("3. Ver estado");
            System.out.println("4. Salir\n");
            System.out.print("Elige una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println(">> Aquí se llamaría a la lógica para crear un personaje.");
                    break;
                case "2":
                    System.out.println(">> Aquí se llamaría a la lógica de ataque entre personajes.");
                    break;
                case "3":
                    System.out.println(">> Aquí se mostraría el estado de los personajes.");
                    break;
                case "4":
                    System.out.println("¡Hasta pronto!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
}