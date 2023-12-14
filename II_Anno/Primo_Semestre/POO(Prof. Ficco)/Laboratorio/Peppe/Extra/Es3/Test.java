public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog("Harry", 5);
        Cat cat = new Cat("Jess", 4);

        System.out.println("\nCAT\n\n" + "Name: "  + cat.name + "\nAge: " + cat.age);
        System.out.println("\nDOG\n\n" + "Name: "  + dog.name + "\nAge: " + dog.age);
    }
}
