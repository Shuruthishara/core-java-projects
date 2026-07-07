package repository;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import model.Student;

public class StudentRepository {
    //This way of declaring here is called Dependency Injection / Constructor Injection.
    private final StudentFileStorage studentFileStorage;
    Map<String, Student> studentMap = new TreeMap<>();


    public StudentRepository(StudentFileStorage studentFileStorage) {
        this.studentFileStorage = studentFileStorage;

        //Loading existing file data to local TreeMap 
        Collection<Student> students = studentFileStorage.loadStudentsFromFile();

        for (Student student : students)
            studentMap.put(student.getStudentID(), student);
    }

    public void save(Student student) {
        studentMap.put(student.getStudentID(), student);
        studentFileStorage.saveStudentsToFile(studentMap.values());
    }

    public Collection<Student> getAll() {
        return studentMap.values();
    }

    public boolean existsByID(String ID) {
        return studentMap.containsKey(ID);
    }

    public Student findByID(String ID) {
        return studentMap.get(ID);
    }

    public Student deleteByID(String ID) {
        Student removedStudent = studentMap.remove(ID);
        studentFileStorage.saveStudentsToFile(studentMap.values());
        return removedStudent;
    }
}
