import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class EsercitoManager 
{
	private Vector<Soldato> soldati;

	public EsercitoManager()
	{
		this.soldati = new Vector<Soldato>();
	}

	public Vector<Soldato> getSoldati() {
		return soldati;
	}

	public void setSoldati(Vector<Soldato> soldati) {
		this.soldati = soldati;
	}

	public void saveSoldati(String fileName)
	{
		PrintWriter out = null;

		try
		{
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

			for(Soldato s : this.soldati) out.println(s);

			out.close();
		}
		catch(EOFException e)
		{
			System.out.println("Fine stream");
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.close();
		}
	}


	public void readSoldati(String fileName)
	{
		BufferedReader in = null;
		String line = "";

		try
		{
			in = new BufferedReader(new FileReader(fileName));

			while((line = in.readLine()) != null)
			{

				if(line.contains("SoldatoScelto"))
				{
					line = line.replace("SoldatoScelto [","");
					line = line.replace("Soldato [","");
					line = line.replace("]]","");
					
					StringTokenizer st = new StringTokenizer(line, ",");
					
					String spec = st.nextToken();
					int numMiss = Integer.parseInt(st.nextToken());
					String nome = st.nextToken();
					int grado = Integer.parseInt(st.nextToken());
					
					SoldatoScelto s = new SoldatoScelto(nome,grado,spec,numMiss);
					System.out.println(s);
					
				}
				else
				{
					line = line.replace("Soldato [","");
					line = line.replace("]","");
					
					StringTokenizer st = new StringTokenizer(line, ",");

					String nome = st.nextToken();
					int grado = Integer.parseInt(st.nextToken());
					
					Soldato s = new Soldato(nome,grado);
					System.out.println(s);
				}
			}

			in.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
