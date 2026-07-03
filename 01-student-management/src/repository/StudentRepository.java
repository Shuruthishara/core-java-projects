package repository;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import model.Student;

public class StudentRepository {
    Map<String, Student> studentList = new TreeMap<>();

    public void save(Student student) {
        studentList.put(student.getStudentID(), student);
    }

    public Collection<Student> findAll() {
        return studentList.values();
    }

    public Student findByID(String ID) {
        return studentList.get(ID);
    }

    public Student deleteByID(String ID) {
        return studentList.remove(ID);
    }
}
