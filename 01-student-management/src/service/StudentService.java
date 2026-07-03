package service;

import java.util.*;
import model.Student;
import repository.StudentRepository;

public class StudentService {
    StudentRepository repository = new StudentRepository();

    // public boolean addStudent(Student student) {
    //     if(repository.findByID(student.getStudentID()) != null){
    //         repository.save(student);
    //         return true;
    //     }
    //     return false;
    // }

    public void addStudent(Student student){
        repository.save(student);
    }

    public Collection<Student> viewAllStudent() {
        return repository.findAll();
    }

    public Student searchStudent(String ID) {        
        return repository.findByID(ID);
    }

    public boolean updateStudent(Student student) {
        if(repository.findByID(student.getStudentID()) != null){
            repository.save(student);
            return true;
        }
        return false;
    }
    
    public Student deleteStudent(String ID) {
        return repository.deleteByID(ID);
    }
}