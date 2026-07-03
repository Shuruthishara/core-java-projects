package ui;

import java.util.Collection;
import java.util.Scanner;

import model.Student;
import service.*;
import util.*;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    StudentService studentService = new StudentService();

    public void start() {
        int option = 0; //must
        final int EXIT = 6;

        do {
            ConsoleUtil.separator();
            mainMenu();

            option = InputUtil.readInt(scanner, "Enter a valid option: ");
        
            ConsoleUtil.separator();

            //Enhanced Switch (Java 14+)
            switch (option) {
                case 1 -> addStudentMenu();
                case 2 -> viewAllStudentMenu();
                case 3 -> searchStudentMenu();
                case 4 -> updateStudentMenu();
                case 5 -> deleteStudentMenu();
                case 6 -> System.out.println("Operation Ended. Thank You!");
                default -> System.out.println("Please enter a valid option number.");
            }                     
        } while(option != EXIT);
    }

    private void mainMenu() {
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

    private void addStudentMenu() {
        System.out.println("Enter Student ID:");
        String ID = scanner.nextLine();

        System.out.println("Enter Student name:");
        String name = scanner.nextLine();

        System.out.println("Enter Student age:");
        int age = InputUtil.readInt(scanner, "Enter a valid age: ");

        System.out.println("Enter Student Department:");
        String department = scanner.nextLine();

        System.out.println("Enter Student Email:");
        String email = scanner.nextLine();

        Student student = new Student(ID, name, age, department, email);

        studentService.addStudent(student);
        System.out.println("\nStudent added.".toUpperCase());
        // if(studentService.addStudent(student))
        //     System.out.println("\nStudent added.".toUpperCase());
        // else
        //     System.out.println("\nStudent ID already exists".toUpperCase());
    }

    public void viewAllStudentMenu() {
        Collection<Student> students = studentService.viewAllStudent();

        if (students.isEmpty()) {
            System.out.println("No student record.".toUpperCase());
        } else {
            students.forEach(System.out::println);
            System.out.println();
        }
    }

    public void searchStudentMenu() {
        System.out.println("Enter Student ID to be searched:");
        String searchID = scanner.nextLine();
        
        Student foundStudent = studentService.searchStudent(searchID);

        //The following method is called 'Early Return'; preferrable.
        if (foundStudent == null){
            System.out.println("\nStudent not found.".toUpperCase());
            return;
        }

        System.out.println("\n" + foundStudent);
    }

    public void updateStudentMenu() {
        System.out.println("Enter Student ID to be updated:");
        String searchID = scanner.nextLine();

        Student foundStudent = studentService.searchStudent(searchID);

        if (foundStudent == null){
            System.out.println("\nStudent not found.".toUpperCase());
            return;
        }

        System.out.println("Enter Student name:");
        String name = scanner.nextLine();

        System.out.println("Enter Student age:");
        int age = InputUtil.readInt(scanner, "Enter a valid age: ");

        System.out.println("Enter Student Department:");
        String department = scanner.nextLine();

        System.out.println("Enter Student Email:");
        String email = scanner.nextLine();

        Student student = new Student(searchID, name, age, department, email);

        if(studentService.updateStudent(student))
            System.out.println("\nStudent updated.".toUpperCase());
        else
            System.out.println("\nStudent details not updated".toUpperCase());
    }

    public void deleteStudentMenu() {
        System.out.println("Enter Student ID to be deleted:");
        String searchID = scanner.nextLine();

        Student removedStudent = studentService.deleteStudent(searchID);

        if (removedStudent != null)
            System.out.println("\nStudent deleted.".toUpperCase());
        else
            System.out.println("\nStudent not found.".toUpperCase());
    }
}
