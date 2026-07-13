package ui;

import java.util.Collection;
import java.util.Map;
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
        int mainMenuOption; 

        ConsoleUtil.separator();

        while (true) {
            mainMenu();

            mainMenuOption = ValidationUtil.readInt(scanner, "Enter a valid option: ");
        
            ConsoleUtil.separator();

            //Enhanced Switch (Java 14+)
            switch (mainMenuOption) {
                case 1 -> addStudentMenu();
                case 2 -> viewAllStudentMenu();
                case 3 -> searchStudentMenu();
                case 4 -> sortStudentMenu();
                case 5 -> updateStudentMenu();
                case 6 -> deleteStudentMenu();
                case 7 -> statisticsMenu();
                case 8 -> {
                    System.out.println("Operation Ended. Thank You!");
                    ConsoleUtil.separator();
                    return;
                }
                default -> System.out.println("Please enter a valid option number.");
            }                     
        }
    }

    private void mainMenu() {
        System.out.println("""
                    ======== Student Management ========
        
                    1. Add Student
                    2. View All Student
                    3. Search Student
                    4. Sort Student
                    5. Update Student
                    6. Delete Student
                    7. Statistics
                    8. Exit
        
                    Choose an option:""");
    }

    private void displaySortMenu() {
        System.out.println("""
                    ======== Sort Students By ========
        
                    1. ID
                    2. Name
                    3. Age
                    4. Department
                    5. Back
        
                    Choose an option:""");
    }

    private void displaySearchMenu() {
        System.out.println("""
                    ======== Search Students By ========
        
                    1. ID
                    2. Name
                    3. Age
                    4. Department
                    5. Back
        
                    Choose an option:""");
    }

    private void displayStatisticsMenu() {
        System.out.println("""
                    ======== Statistics Menu ========
        
                    1. Total no. of Students
                    2. Average Age
                    3. Youngest Student
                    4. Oldest Student
                    5. Department-wise Students' Count
                    6. Back
        
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

        if(studentService.addStudent(student)) {
            System.out.println("\nStudent added.".toUpperCase());
            ConsoleUtil.separator();
        } else {
            System.out.println("\nStudent ID already exists".toUpperCase());
            ConsoleUtil.separator();
        }
    }

    private void viewAllStudentMenu() {
        Collection<Student> students = studentService.getAllStudent();

        if (students.isEmpty()) {
            System.out.println("No student record found.".toUpperCase());
            ConsoleUtil.separator();
        } else {
            for (Student student : students)
                System.out.println(student + "\n");
            ConsoleUtil.separator();
        }
    }

    private void searchStudentMenu() {
        int searchMenuOption;

        if (studentService.getAllStudent().isEmpty()) {
            System.out.println("No student record found.".toUpperCase());
            return;
        }

        while (true) {
            displaySearchMenu();

            searchMenuOption = ValidationUtil.readInt(scanner, "Enter a valid option: ");
        
            ConsoleUtil.separator();

            //Enhanced Switch (Java 14+)
            switch (searchMenuOption) {
                case 1 -> searchByIDMenu();
                case 2 -> searchByNameMenu();
                case 3 -> searchByAgeMenu();
                case 4 -> searchByDepartmentMenu();
                case 5 -> {
                    return; //for return, braces are needed. As case expects expresiion or block, whereas return is a statement.
                }
                default -> System.out.println("Please enter a valid option number.");
            }                     
        }
    }

    private void displayFoundStudents(String title, Collection<Student> foundStudents) {
        if(foundStudents.size() == 0) {
            System.out.println("\nStudent not found.".toUpperCase());
            ConsoleUtil.separator();
            return;
        }

        ConsoleUtil.separator();

        System.out.println("======== Student(s) Grouped By \'" + title + "\' ========\n");

        foundStudents.forEach(student -> System.out.println(student + "\n"));
        ConsoleUtil.separator();
    }

    private void searchByIDMenu() {
        System.out.println("Enter Student ID to be searched:");
        displayFoundStudents("ID", studentService.searchByID(scanner.nextLine()));
    }

    private void searchByNameMenu() {
        System.out.println("Enter Student Name to be searched:");
        displayFoundStudents("Name", studentService.searchByName(scanner.nextLine()));
    }

    private void searchByAgeMenu() {
        System.out.println("Enter Student Age to be searched:");
        displayFoundStudents("Age", studentService.searchByAge(ValidationUtil.readAge(scanner, "Age must be between 2 and 100.")));
    }

    private void searchByDepartmentMenu() {
        System.out.println("Enter Student Department to be searched:");
        displayFoundStudents("Department", studentService.searchByDepartment(scanner.nextLine()));
    }

    private void sortStudentMenu() {
        int sortMenuOption;

        if (studentService.getAllStudent().isEmpty()) {
            System.out.println("No student record found.".toUpperCase());
            return;
        }

        while (true) {
            displaySortMenu();

            sortMenuOption = ValidationUtil.readInt(scanner, "Enter a valid option: ");
        
            ConsoleUtil.separator();

            //Enhanced Switch (Java 14+)
            switch (sortMenuOption) {
                case 1 -> sortByIDMenu();
                case 2 -> sortByNameMenu();
                case 3 -> sortByAgeMenu();
                case 4 -> sortByDepartmentMenu();
                case 5 -> {
                    return; //for return, braces are needed. As case expects expresiion or block, whereas return is a statement.
                }
                default -> System.out.println("Please enter a valid option number.");
            }                     
        }
    }

    private void displaySortedStudents(String title, Collection<Student> sortedStudents) {
        System.out.println("======== Students Sorted By \'" + title + "\' ========\n");

        sortedStudents.forEach(student -> System.out.println(student + "\n"));
        ConsoleUtil.separator();
    }

    private void sortByIDMenu() {
        displaySortedStudents("ID", studentService.sortByID());
    }

    private void sortByNameMenu() {
        displaySortedStudents("Name", studentService.sortByName());
    }

    private void sortByAgeMenu() {
        displaySortedStudents("Age", studentService.sortByAge());
    }

    private void sortByDepartmentMenu() {
        displaySortedStudents("Department", studentService.sortByDepartment());
    }

    private void updateStudentMenu() {
        System.out.println("Enter Student ID to be updated:");
        String searchID = scanner.nextLine();

        Student updatedStudent = readStudent(searchID);

        if(studentService.updateStudent(updatedStudent)) {
            System.out.println("\nStudent updated.".toUpperCase());
            ConsoleUtil.separator();
        } else {
            System.out.println("\nStudent not found".toUpperCase());
            ConsoleUtil.separator();
        }
    }

    private void deleteStudentMenu() {
        System.out.println("Enter Student ID to be deleted:");
        String searchID = scanner.nextLine();

        Student removedStudent = studentService.deleteStudent(searchID);

        if (removedStudent != null) {
            System.out.println("\nStudent deleted.".toUpperCase());
            ConsoleUtil.separator();
        } else {
            System.out.println("\nStudent not found.".toUpperCase());
            ConsoleUtil.separator();
        }
    }

    private void statisticsMenu() {
        int statisticsMenuOption;

        if (studentService.getAllStudent().isEmpty()) {
            System.out.println("No student record found.".toUpperCase());
            return;
        }

        while (true) {
            displayStatisticsMenu();

            statisticsMenuOption = ValidationUtil.readInt(scanner, "Enter a valid option: ");
        
            ConsoleUtil.separator();

            //Enhanced Switch (Java 14+)
            switch (statisticsMenuOption) {
                case 1 -> totalNumberOfStudentsMenu();
                case 2 -> averageAgeMenu();
                case 3 -> youngestStudentsMenu();
                case 4 -> oldestStudentsMenu();
                case 5 -> departmentWiseCountMenu();
                case 6 -> {
                    return; //for return, braces are needed. As case expects expresiion or block, whereas return is a statement.
                }
                default -> System.out.println("Please enter a valid option number.");
            }                     
        }
    }

    private void totalNumberOfStudentsMenu() {
        System.out.println("Total no. of Students: " + studentService.getAllStudent().size());
        ConsoleUtil.separator();
    }

    private void averageAgeMenu() {
        System.out.println("Students' average age: " + studentService.getAverageAge());
        ConsoleUtil.separator();
    }

    private void youngestStudentsMenu() {
        System.out.println("======== Youngest Student(s) ========\n");

        for (Student student : studentService.getYoungestStudents())
            System.out.println(student + "\n");

        ConsoleUtil.separator();
    }

    private void oldestStudentsMenu() {
        System.out.println("======== Oldest Student(s) ========\n");
        
        for (Student student : studentService.getOldestStudents())
            System.out.println(student + "\n");

        ConsoleUtil.separator();
    }

    private void departmentWiseCountMenu() {
        System.out.println("======== Department-wise Students' Count ======== \n");

        for (Map.Entry<String, Long> entry : studentService.getDepartmentWiseCount().entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());

        ConsoleUtil.separator();
    }

    public void close() {
        scanner.close();
    }
}
