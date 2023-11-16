import java.util.Random;
import java.util.ArrayList;
import Fantasy.*;

public class TestFantasy {
	private static int counter = 0;
	public static void main (String[] args) {
		Random pgs = new Random(1);
		ArrayList pgList = new ArrayList();
		for(int i = 0; i < 10; i++) {
			if(pgs.nextInt() == 0)
				pgList.add(new Cavaliere());
			else
				pgList.add(new Orco());
			counter++;
		}
	}
//	System.out.println(((Personaggio) pgList.get(0)).posizione((Personaggio)pgList.get(1)));
	
	//((Personaggio) pgList.get(0)).colpisci((Personaggio)pgList.get(1));
}