package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    public static int leerEntero(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            return -1;
        }
    }
}
