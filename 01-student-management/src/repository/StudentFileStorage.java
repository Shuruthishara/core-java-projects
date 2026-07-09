package repository;

import java.io.*;
import java.util.*;

import model.Student;

public class StudentFileStorage {
    //As workspace is on core-java-projects folder, CWD is core-java-projects folder, not 01-student-management.
    //So 01-student-management should be mentioned. Or you should open 01-student-management as worksapce to set same CWD, 
    //to make this FILE_PATH = "data/students.csv" work. But if done so, git link to the core-java-projects is lost and become untackable. 
    //You have to create 01-student-management as separarte repo to track it.
    private final String FILE_PATH = "01-student-management/data/students.csv";

    public Collection<Student> loadStudentsFromFile(){
        File file = new File(FILE_PATH);
        Collection<Student> studentList = new ArrayList<>();

        // If file doesn't exist, it returns an empty list
        if (file.exists() == false) 
            return studentList;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = fileReader.readLine()) != null) {
                String[] studentRaw = line.split(",");

                Student student = new Student(
                                        studentRaw[0],
                                        studentRaw[1],
                                        Integer.parseInt(studentRaw[2]),
                                        studentRaw[3],
                                        studentRaw[4]
                                        );
                
                studentList.add(student);
            }
        } catch (IOException e) {
            System.out.println("Error loading students data from file.");
        }

        return studentList;
    }

    public void saveStudentsToFile(Collection<Student> students){
        // System.out.println(System.getProperty("user.dir"));
        // System.out.println("File: " + new File(FILE_PATH).getAbsolutePath());
        // System.out.println("Data exists: " + new File("data").exists());

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_PATH))) {

            for (Student student : students) {
                fileWriter.write(student.toCSV());
                fileWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }
}
