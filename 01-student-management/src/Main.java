import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)){
            StudentManagement studentManagement = new StudentManagement(s);
            int option = 0; //must
            final int EXIT = 6;

            do {
                separator();
                displayMenu();

                //To avoid fampus Scanner nextInt()/nextLine() problem.
                // That is, no leftover newline left for Buffer to store.
                //Also, catches when input is text.
                try {
                    option = Integer.parseInt(s.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("\nOption Invalid.");
                    continue;
                }
            
                separator();

                //Enhanced Switch (Java 14+)
                switch (option) {
                    case 1 -> studentManagement.addStudent();
                    case 2 -> studentManagement.viewAllStudent();
                    case 3 -> studentManagement.searchStudent();
                    case 4 -> studentManagement.updateStudent();
                    case 5 -> studentManagement.deleteStudent();
                    case 6 -> System.out.println("Operation Ended. Thank You!");
                    default -> System.out.println("Please enter a valid number.");
                }                     
            } while(option != EXIT);
        }
    }

    public static void displayMenu() {
        System.out.println("""
                    ======== Student Management ========
        
                    1. Add Student
                    2. View All Students
                    3. Search Student
                    4. Update Student
                    5. Delete Student
                    6. Exit
        
                    Choose an option:
                        """);
    }

    public static void separator() {
       System.out.println("\n---------------------------------\n");
    }
}