public class Person {
    protected String name;
    protected int age;
    protected String gender;

    public Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String ToString(){
        return "Name: " + this.name + "\nAge: " + this.age + "\nGender: " +  this.gender;
    }
}