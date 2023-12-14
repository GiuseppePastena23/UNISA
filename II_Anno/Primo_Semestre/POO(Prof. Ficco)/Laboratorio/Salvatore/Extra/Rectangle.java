public class Rectangle
{
	private float height = 0;
	private float base = 0;
	
	Rectangle(float height, float base)
	{
		this.height = height;
		this.base = base;
	}
	
	public float get_height()
	{
		return height;
	}
	
	public float get_base()
	{
		return base;
	}
	
	public void set_height(float height)
	{
		this.height = height;
	}

	public void set_base(float base)
	{
		this.base = base;
	}
	
	public float get_area()
	{
		return ((height*base));
	}
	
	public float get_perimeter()
	{
		return((height*2) + (base*2));
	}
	
	public static void main(String[] args)
	{
		Rectangle rectangle = new Rectangle(3, 6);
		System.out.println("Perimeter = " + rectangle.get_perimeter() + "\nArea = " + rectangle.get_area() + "\n");
		rectangle.set_height(10);
		rectangle.set_base(20);
		System.out.println("Perimeter = " + rectangle.get_perimeter() + "\nArea = " + rectangle.get_area() + "\n");		
	}
}
