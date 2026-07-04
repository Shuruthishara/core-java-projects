import repository.StudentRepository;
import service.StudentService;
import ui.*;

public class Main {
    public static void main(String[] args) {
        //This way of declaring here is called Dependency Injection / Constructor Injection.
        StudentRepository repository = new StudentRepository();
        StudentService studentService = new StudentService(repository);
        Menu menu = new Menu(studentService);

        menu.start();
        menu.close();
    }
}