package core.university;

import java.util.*;

public class StudentManager {

    private List<Student> students;

    public StudentManager(){
        students = new ArrayList<>();
    }

    public void addStudent(Student s){
        students.add(s);
    }

    public List<Student> getStudents(){
        return students;
    }
    
}
