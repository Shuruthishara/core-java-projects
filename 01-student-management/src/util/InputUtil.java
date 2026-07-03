package util;

import java.util.Scanner;

public class InputUtil {
    //To avoid fampus Scanner nextInt()/nextLine() problem.
    // That is, no leftover newline left for Buffer to store.
    //Also, catches when input is text.
    public static int readInt(Scanner scanner, String message) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(message);
            }
        }
    }
}
