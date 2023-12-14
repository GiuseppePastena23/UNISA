/*
Write a Java program to create a class called "Dog" with a name and breed attribute. Create two instances of the "Dog" class, set their attributes using the constructor and modify the attributes using the setter methods and print the updated values.
*/

public class Main {
    public static void main(String[] args) {
        Dog cane1 = new Dog("Rex", "Pastore Tedesco");
        Dog cane2 = new Dog("Asdfg", "Cane");
        cane2.setName("Nome");
    }
}

/**
* il mio cane
*/
class Dog {
    String name;
    String race;
    
    public Dog(String name, String race) {
        this.name = name;
        this.race = race;
    }
    
    public String getName() {
        return name;
    }
    public String setName(String name) {
        this.name = name;
    }
    
    public String getRace() {
        return race;
    }
    public String setRace(String race) {
        this.race = race;
    }
}
