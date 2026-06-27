import java.util.*;

public class StudentManagement {
    Scanner s = new Scanner(System.in);

    List<Student> studentList = new ArrayList<>();

    public void addStudent() {
        System.out.println("Enter Student ID:");
        String ID = s.nextLine();

        System.out.println("Enter Student name:");
        String name = s.nextLine();

        System.out.println("Enter Student age:");
        String age = s.nextLine();

        System.out.println("Enter Student Department:");
        String department = s.nextLine();

        System.out.println("Enter Student Email:");
        String email = s.nextLine();

        Student student = new Student(ID, name, age, department, email);
        studentList.add(student);
    }

    public void viewAllStudent() {
        if (studentList.size() == 0) {
            System.out.println("No student record.");
        } else {
            for (Student stu : studentList) {
                System.out.println("Student ID: " + stu.getStudentID());
                System.out.println("Name: " + stu.getName());
                System.out.println("Age: " + stu.getAge());
                System.out.println("Department: " + stu.getDepartment());
                System.out.println("Email: " + stu.getEmail());
            }
        }
    }

    public void searchStudent() {
        System.out.println("Enter Student ID:");
        String searchID = s.nextLine();
        boolean found = false;

        for (Student stu : studentList) {
            if(searchID.equals(stu.getStudentID())) {
                found = true;

                System.out.println("Student ID: " + stu.getStudentID());
                System.out.println("Name: " + stu.getName());
                System.out.println("Age: " + stu.getAge());
                System.out.println("Department: " + stu.getDepartment());
                System.out.println("Email: " + stu.getEmail());

                break;
            } 
        }

        if(!found)
            System.out.println("Student not found!");
    }

    public void updateStudent() {
        System.out.println("Enter Student ID to be updated:");
        String searchID = s.nextLine();
        boolean found = false;

        for (Student stu : studentList) {
            if(searchID.equals(stu.getStudentID())) {
                found = true;

                System.out.println("Enter Student name:");
                String name = s.nextLine();
                stu.setName(name);

                System.out.println("Enter Student age:");
                String age = s.nextLine();
                stu.setAge(age);

                System.out.println("Enter Student Department:");
                String department = s.nextLine();
                stu.setDepartment(department);

                System.out.println("Enter Student Email:");
                String email = s.nextLine();
                stu.setEmail(email);

                System.out.println("Student Details updated");

                break;
            } 
        }

        if(!found)
            System.out.println("Student not found!");
    }
    
    public void deleteStudent() {
        System.out.println("Enter Student ID to be deleted:");
        String searchID = s.nextLine();
        boolean found = false;

        for (int i = 0; i < studentList.size(); i++) {
            if(searchID.equals(studentList.get(i).getStudentID())) {
                found = true;

                studentList.remove(i);
                System.out.println("Student Details deleted");
                break;
            } 
        }

        if(!found)
            System.out.println("Student not found!");
    }
}