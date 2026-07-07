package util;

import java.util.Scanner;

public class ValidationUtil {
    //To avoid famous Scanner nextInt()/nextLine() problem.
    //That is, no leftover newline left for Buffer to store.
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

    public static int readAge(Scanner scanner, String message) {
        int age = readInt(scanner, "Enter a valid age: ");

        while (true) {
            if (age >= 2 && age <= 100)
                return age;
            
            System.out.println(message);
        }
    }

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+._-]+@[A-Za-z.-]+\\.[A-Za-z]{2,}$";

    public static String readEmail(Scanner scanner, String message) {
        while (true) {
            String email = scanner.nextLine();

            if(email.matches(EMAIL_REGEX))
                return email;
        
            System.out.println(message);
        }
    }
}
