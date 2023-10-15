/*
Write a Java program to create a class called "Person" with a name and age attribute.
Create two instances of the "Person" class, set their attributes using the constructor,
and print their name and age.
*/

public class Main {
    public static void main(String[] args) {
        Person persona1 = new Person("Mario", (short) 19);
        Person persona2 = new Person("Giovanni", (short) 20);
        System.out.println(persona1);
        System.out.println(persona2);
    }
}

class Person {
    String name;
    short age;
    
    public Person(String name, short age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public short getAge() {
        return age;
    }
    
    @Override
    public String toString() {
        return "Nome: " + name + "\tAge: " + age;
    }
    
}
