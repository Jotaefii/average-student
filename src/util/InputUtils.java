package util;

import java.util.Scanner;

public class InputUtils {

    public static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);

            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                sc.nextLine();
                return value;
            }
            System.out.println("Entrada inválida! Digite apenas números.");
            sc.next();
        }
    }

    public static double readDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);

            if (sc.hasNextDouble()) {
                double value = sc.nextDouble();
                sc.nextLine();
                return value;
            }
            System.out.println("Entrada inválida! Digite apenas números.");
            sc.next();
        }
    }

    public static String readName(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String nome = sc.nextLine();

            if (!nome.isBlank() && nome.matches("[a-zA-ZÀ-ÿ ]+")) {
                return nome;
            }
            System.out.println("Nome inválido! Digite apenas letras");
        }
    }

    public static String readNumbers(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String value = sc.nextLine();

            if (!value.isBlank() && value.matches("\\d+")) {
                return value;
            }
            System.out.println("Inválido! Digite apenas números.");
        }
    }
}
