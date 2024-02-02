package es3;

public class Main {
    public static void main(String[] args) {
        int width = 10;
        Drawable d = () -> System.out.println("Drawing " + width);
        d.draw();
    }
}
