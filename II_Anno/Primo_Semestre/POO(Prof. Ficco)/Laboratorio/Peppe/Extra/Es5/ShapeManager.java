public class ShapeManager {
    public static double calculateTotalArea(Shape[] shapes){
        double totalArea = 0;
        
        for(Shape shape : shapes){
            totalArea = shape.calculateArea();
        }

        return totalArea;
    }
    
}
