package core.university;
import java.io.*;

public class Student implements Serializable{
    private int age;
    private String name;
    private String surname;
    private Category cat;

    public Student(String name, String surname, int age, Category cat){
        if(name.isBlank() || surname.isBlank()){
            throw new CampiVuotiException("Campi vuoti!");
        }
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.cat = cat;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Surname: " + surname + ", Age: " + age + ", Category: " + cat + "\n";
    }
}