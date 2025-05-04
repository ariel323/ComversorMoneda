package menu;

import conversor.ConversorMoneda;
import util.InputHelper;
import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n=== Conversor de Monedas ===");
            System.out.println("1) Convertir monedas");
            System.out.println("2) Ver tasas de cambio guardadas");
            System.out.println("3) Salir");
            System.out.print("Elige una opción: ");

            int opcion = InputHelper.leerEntero(scanner);

            switch (opcion) {
                case 1 -> {
                    System.out.print("Moneda origen (ej. USD): ");
                    String base = scanner.next().toUpperCase();
                    System.out.print("Moneda destino (ej. EUR): ");
                    String destino = scanner.next().toUpperCase();
                    ConversorMoneda.convertir(base, destino);
                }
                case 2 -> ConversorMoneda.mostrarTasasCache();
                case 3 -> {
                    System.out.println("¡Hasta pronto!");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}
