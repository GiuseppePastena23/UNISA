package core.university;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
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
    
    public void saveOnFile(String fname) {
        try (PrintWriter o = new PrintWriter(fname)){
            o.write(toString());
            o.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for (Student student : students) {
            s.append(student);
        }
        return s.toString();
    }
}
