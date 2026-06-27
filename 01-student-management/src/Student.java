public class Student {
    private String studentID;
    private String name;
    private String age;
    private String department;
    private String email;

    Student(String studentID, String name, String age, String department, String email) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.department = department;
        this.email = email;
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

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
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
