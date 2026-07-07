package service;

import java.util.*;

import model.Student;
import repository.StudentRepository;

public class StudentService {
    //This way of declaring here is called Dependency Injection / Constructor Injection.
    private final StudentRepository repository;

    public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    public boolean addStudent(Student student) {
        if(repository.existsByID(student.getStudentID()))
            return false;

        repository.save(student);
        return true;
    }

    public Collection<Student> getAllStudent() {
        return repository.getAll();
    }

    public Student findStudentByID(String ID) {        
        return repository.findByID(ID);
    }

    public boolean updateStudent(Student student) {
        if(!repository.existsByID(student.getStudentID()))
            return false;

        repository.save(student);
        return true;
    }
    
    public Student deleteStudent(String ID) {
        return repository.deleteByID(ID);
    }
}