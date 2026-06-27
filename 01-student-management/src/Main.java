import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int option;
        StudentManagement studentManagement = new StudentManagement();

        do {
            System.out.println();
            System.out.println("---------------------------------");
            System.out.println();
            System.out.println("======== Student Management ========");
            System.out.println();
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println();
            System.out.println("Choose an option:");
            System.out.println();

            option = s.nextInt();
           
            System.out.println();
            System.out.println("---------------------------------");
            System.out.println();

            switch (option) {
                case 1: 
                    studentManagement.addStudent();
                    break;
                case 2:
                    studentManagement.viewAllStudent();
                    break;
                case 3:
                    studentManagement.searchStudent();
                    break;
                case 4:
                    studentManagement.updateStudent();
                    break;
                case 5:
                    studentManagement.deleteStudent();
                    break;
                default:  
                    if (option != 6)
                        System.out.println("Enter valid option:");
            }
                     
        } while(option != 6);
        
        if (option == 6)
            System.out.println("Operattion Ended. Thank You!");

        s.close();
    }
}