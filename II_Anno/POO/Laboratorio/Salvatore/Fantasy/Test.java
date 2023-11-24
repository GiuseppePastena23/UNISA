import Game.Personaggio;
import Game.Cavaliere;
import Game.Orco;
import java.util.ArrayList;

public class Test
{
	public static void main(String args[])
	{
		ArrayList<Personaggio> personaggi = new ArrayList<>();	
        personaggi.add(new Cavaliere("Soldato", 100, 0));
        personaggi.add(new Orco("Bruto", 200, 2));	

        System.out.println(personaggi.get(0));
        System.out.println(personaggi.get(1));
	}
}
