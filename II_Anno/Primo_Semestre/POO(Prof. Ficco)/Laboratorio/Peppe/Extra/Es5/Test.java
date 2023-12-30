import java.util.Random;


public class Test {
    public static void main(String[] args) {
        Random rand = new Random();
        Shape[] shapes = new Shape[10];
        int value = 0;

        for(int i = 0; i < shapes.length; i++)
        {
            value = rand.nextInt(2);
            if(value == 0)
            {
                shapes[i] = new Rectangle(rand.nextDouble(20), rand.nextDouble(20));
            }
            else if(value == 1)
            {
                shapes[i] = new Circle(rand.nextDouble(20));
            }
        }

        System.out.println(ShapeManager.calculateTotalArea(shapes));
        
    }
}
