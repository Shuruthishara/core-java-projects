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

    private Collection<Student> sortBy(Comparator<Student> comparator) {
        return repository.getAll().stream()
                                  .sorted(comparator)
                                  .toList();
    }

    public Collection<Student> sortByID() {
        return sortBy(Comparator.comparing(Student::getStudentID));
    }

    public Collection<Student> sortByName() {
        return sortBy(Comparator.comparing(Student::getName));
    }

    public Collection<Student> sortByDepartment() {
        return sortBy(Comparator.comparing(Student::getDepartment));
    }

    public Collection<Student> sortByAge() {
        return sortBy(Comparator.comparingInt(Student::getAge)); //Method Reference
    }

    //.sorted(omparator.comparingInt(Student::getAge))
    //.sorted(Comparator.comparing(student -> student.getAge()))
    //.sorted((a, b) -> a.getAge() - b.getAge())
    //.sorted((a, b) -> Integer.compare(a.getAge(), b.getAge()))
    //Comparator<Student> comp = (a, b) -> Integer.compare(a.getAge(), b.getAge());
    //All are same

}