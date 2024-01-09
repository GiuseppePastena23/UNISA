public class ListaTest {
    public static void main(String[] args) {
        Lista<Integer> intList = new Lista<>();
        intList.addOnTop(1);
        intList.append(2);
        intList.printAllElements(); // Output: 1 2
        intList.removeOnTop();
        intList.printAllElements(); // Output: 2
        intList.removeFromTail();
        intList.printAllElements(); // Output: (empty)
        System.out.println("Size: " + intList.returnSize()); // Output: Size: 0

        Lista<Float> floatList = new Lista<>();
        floatList.addOnTop(1.5f);
        floatList.append(2.5f);
        floatList.printAllElements(); // Output: 1.5 2.5
        floatList.removeOnTop();
        floatList.printAllElements(); // Output: 2.5
        floatList.removeFromTail();
        floatList.printAllElements(); // Output: (empty)
        System.out.println("Size: " + floatList.returnSize()); // Output: Size: 0

        Lista<String> stringList = new Lista<>();
        stringList.addOnTop("Hello");
        stringList.append("World");
        stringList.printAllElements(); // Output: Hello World
        stringList.removeOnTop();
        stringList.printAllElements(); // Output: World
        stringList.removeFromTail();
        stringList.printAllElements(); // Output: (empty)
        System.out.println("Size: " + stringList.returnSize()); // Output: Size: 0

        Lista<Double> doubleList = new Lista<>();
        doubleList.addOnTop(1.5);
        doubleList.append(2.5);
        doubleList.printAllElements(); // Output: 1.5 2.5
        doubleList.removeOnTop();
        doubleList.printAllElements(); // Output: 2.5
        doubleList.removeFromTail();
        doubleList.printAllElements(); // Output: (empty)
        System.out.println("Size: " + doubleList.returnSize()); // Output: Size: 0
    }
}