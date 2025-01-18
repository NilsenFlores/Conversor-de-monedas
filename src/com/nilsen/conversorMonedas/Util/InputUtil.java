package com.nilsen.conversorMonedas.Util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {
    public static int leerOpcion() {
        int option = 0;
        var scanner = new Scanner(System.in);
        try {
            option = scanner.nextInt();
            scanner.nextLine();
            return option;
        } catch (
                InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Solo se admiten numeros enteros");
            return option;

        }
    }
}
