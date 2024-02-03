public class TestAlternative {
    public static void main(String[] args) {
        Circle circle = new Circle(2.5);
        Rectangle rect = new Rectangle(10, 5);

        System.out.println("Area del triangolo: " + rect.calculateArea());
        System.out.println("Perimentro del triangolo: " + rect.calculatePerimeter());
        System.out.println("Area del cerchio: " + circle.calculateArea());
        System.out.println("Perimentro del cerchio: " + circle.calculatePerimeter());
    }
}
