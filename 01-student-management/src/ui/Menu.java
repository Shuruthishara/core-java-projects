package ui;

import java.util.Collection;
import java.util.Scanner;

import model.Student;
import service.*;
import util.*;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    
    //This way of declaring here is called Dependency Injection / Constructor Injection.
    private final StudentService studentService;

    public Menu(StudentService studentService){
        this.studentService = studentService;
    }

    public void start() {
        int option = 0; //must
        final int EXIT = 6;

        do {
            ConsoleUtil.separator();
            mainMenu();

            option = ValidationUtil.readInt(scanner, "Enter a valid option: ");
        
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
        
                    Choose an option:""");
    }

    private Student readStudent(String ID) {
        
        System.out.println("Enter Student name:");
        String name = scanner.nextLine();

        System.out.println("Enter Student age:");
        int age = ValidationUtil.readAge(scanner, "Age must be between 2 and 100.");

        System.out.println("Enter Student Department:");
        String department = scanner.nextLine();

        System.out.println("Enter Student Email:");
        String email = ValidationUtil.readEmail(scanner, "Enter a valid email: ");

        return new Student(ID, name, age, department, email);
    }

    private void addStudentMenu() {
        System.out.println("Enter Student ID:");
        String ID = scanner.nextLine();

        Student student = readStudent(ID);

        if(studentService.addStudent(student))
            System.out.println("\nStudent added.".toUpperCase());
        else
            System.out.println("\nStudent ID already exists".toUpperCase());
    }

    private void viewAllStudentMenu() {
        Collection<Student> students = studentService.getAllStudent();

        if (students.isEmpty()) {
            System.out.println("No student record.".toUpperCase());
        } else {
            for (Student student : students)
                System.out.println(student + "\n");
        }
    }

    private void searchStudentMenu() {
        System.out.println("Enter Student ID to be searched:");
        String searchID = scanner.nextLine();
        
        Student foundStudent = studentService.findStudentByID(searchID);

        //The following method is called 'Early Return'; preferrable.
        if (foundStudent == null){
            System.out.println("\nStudent not found.".toUpperCase());
            return;
        }

        System.out.println("\n" + foundStudent);
    }

    private void updateStudentMenu() {
        System.out.println("Enter Student ID to be updated:");
        String searchID = scanner.nextLine();

        Student updatedStudent = readStudent(searchID);

        if(studentService.updateStudent(updatedStudent))
            System.out.println("\nStudent updated.".toUpperCase());
        else
            System.out.println("\nStudent not found".toUpperCase());
    }

    private void deleteStudentMenu() {
        System.out.println("Enter Student ID to be deleted:");
        String searchID = scanner.nextLine();

        Student removedStudent = studentService.deleteStudent(searchID);

        if (removedStudent != null)
            System.out.println("\nStudent deleted.".toUpperCase());
        else
            System.out.println("\nStudent not found.".toUpperCase());
    }

    public void close() {
        scanner.close();
    }
}
