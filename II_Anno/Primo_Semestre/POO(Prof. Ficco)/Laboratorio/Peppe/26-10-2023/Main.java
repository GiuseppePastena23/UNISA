import figure.*;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Triangolo_esteso triangolo = new Triangolo_esteso(10, 5, 4, 5);
		
		System.out.println(String.valueOf(triangolo.perimetro()));
	}
}

