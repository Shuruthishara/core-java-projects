import java.util.*;

public class StudentManagement {
    private Scanner s;

    public StudentManagement (Scanner s) {
        this.s = s;
    }

    Map<String, Student> studentList = new TreeMap<>();

    public void addStudent() {
        System.out.println("Enter Student ID:");
        String ID = s.nextLine();

        System.out.println("Enter Student name:");
        String name = s.nextLine();

        System.out.println("Enter Student age:");
        int age = Integer.parseInt(s.nextLine());

        System.out.println("Enter Student Department:");
        String department = s.nextLine();

        System.out.println("Enter Student Email:");
        String email = s.nextLine();

        Student student = new Student(ID, name, age, department, email);
        studentList.put(ID, student);

        System.out.println("\nStudent added.".toUpperCase());
    }

    public void viewAllStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No student record.".toUpperCase());
        } else {
            for (String studentID : studentList.keySet()) {
                System.out.println("\n" + studentList.get(studentID));
            }
        }
    }

    public Student findStudent(String searchID) {
        return studentList.get(searchID);
    }

    public void searchStudent() {
        System.out.println("Enter Student ID to be searched:");
        String searchID = s.nextLine();
        
        Student foundStudent = findStudent(searchID);

        //The following method is called 'Early Return'; preferrable.
        if (foundStudent == null){
            System.out.println("\nStudent not found.".toUpperCase());
            return;
        }

        System.out.println("\n" + foundStudent);
    }

    public void updateStudent() {
        System.out.println("Enter Student ID to be updated:");
        String searchID = s.nextLine();

        Student foundStudent = findStudent(searchID);

        if (foundStudent == null){
            System.out.println("\nStudent not found.".toUpperCase());
            return;
        }

        System.out.println("Enter Student name:");
        String name = s.nextLine();
        foundStudent.setName(name);

        System.out.println("Enter Student age:");
        int age = Integer.parseInt(s.nextLine());
        foundStudent.setAge(age);

        System.out.println("Enter Student Department:");
        String department = s.nextLine();
        foundStudent.setDepartment(department);

        System.out.println("Enter Student Email:");
        String email = s.nextLine();
        foundStudent.setEmail(email);

        System.out.println("\nStudent details updated.".toUpperCase());
    }
    
    public void deleteStudent() {
        System.out.println("Enter Student ID to be deleted:");
        String searchID = s.nextLine();

        Student removedStudent = studentList.remove(searchID);

        if (removedStudent != null)
            System.out.println("\nStudent deleted.".toUpperCase());
        else
            System.out.println("\nStudent not found.".toUpperCase());
    }
}