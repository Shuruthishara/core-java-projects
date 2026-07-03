package ui;

import java.util.Scanner;
import repository.*;
import util.*;

public class Menu {
    public void start() {
        try (Scanner scanner = new Scanner(System.in)){
            StudentManagement studentManagement = new StudentManagement(scanner);
            int option = 0; //must
            final int EXIT = 6;

            do {
                ConsoleUtil.separator();
                displayMenu();

                option = InputUtil.readInt(scanner, "Enter a valid option: ");
            
                ConsoleUtil.separator();

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

    private void displayMenu() {
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
}
