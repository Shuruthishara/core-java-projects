public class Student {
    private String studentID;
    private String name;
    private int age;
    private String department;
    private String email;

    Student(String studentID, String name, int age, String department, String email) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.department = department;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID +
               "\nName: " + name +
               "\nAge: " + age +
               "\nDepartment: " + department +
               "\nEmail: " + email;
    }

    public String getStudentID() {
        return this.studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
