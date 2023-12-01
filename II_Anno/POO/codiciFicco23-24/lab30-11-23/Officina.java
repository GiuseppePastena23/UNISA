import java.lang.*;
import java.io.*;
import java.util.*;


public class Officina{

	public ArrayList schede = new ArrayList();

	public void addScheda(Scheda s){
		if(s!=null)
			schede.add(s);
	}

	public void printVeicoli(String fileName){
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			for (int i=0;i<schede.size();++i){
				out.println(((Scheda)schede.get(i).automobile));
			}
			out.close();

		}catch (EOFException e){
			System.err.println("End of Stream");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void printVeicoliInRiparazione(String fileName){
		try {

			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			for (int i=0;i<schede.size();++i){
				Scheda scheda= (Scheda)schede.get(i);
				if (scheda.getState() == Scheda.IN_RIPARAZIONE)
					out.println(((Scheda)schede.get(i).automobile));
			}
			out.close();

		}catch (EOFException e){
			System.err.println("End Of Stream");

		}catch(Exception e){
			e.printStackTrace();
		}

	}


	public void printVeicoliRiparati(String fileName){
		try {

			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			for (int i=0;i<schede.size();++i){
				Scheda scheda= (Scheda)schede.get(i);
				if (scheda.getState() == Scheda.RIPARATO)
					out.println(((Scheda)schede.get(i).automobile));
			}
			out.close();

		}catch (EOFException e){
			System.err.println("End Of Stream");

		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public void printVeicoliConsegnati(String fileName){
		try {

			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			for (int i=0;i<schede.size();++i){
				Scheda scheda= (Scheda)schede.get(i);
				if (scheda.getState() == Scheda.CONSEGNATO)
					out.println(((Scheda)schede.get(i).automobile));
			}
			out.close();

		}catch (EOFException e){
			System.err.println("End Of Stream");

		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public void readVeicoli(String FileName){
		try {
			BufferedReader in = new BufferedReader( new FileReader(FileName));
			String targa= new String();
			String marca = new String();
			String modello = new String();
			String intestatario = new String ();
			while ((targa=in.readLine())!=null){
				marca=in.readLine();
				modello = in.readLine();
				intestatario = in.readLine();
				Auto a = new Auto (targa, marca, modello, intestatario );
				Scheda s = new Scheda (a, "OGGI");
				s.setState(Scheda.IN_RIPARAZIONE);
			}
			in.close();

		}catch (Exception e){e.printStackTrace();}

	}

	public void eliminaConsegnati(){
			int size=schede.size();
			for (int i=0;i<size;++i){
				Scheda scheda= (Scheda)schede.get(i);
				if (scheda.getState() >= Scheda.CONSEGNATO){
					schede.remove(i--);
					--size;
				}

			}
	}

	public void printVeicoliTrattati(String fileName){
		try{
			DataOutputStream out = new DataOutputStream(new BufferedOutputStream( new FileOutputStream(fileName)));
			out.writeInt(((Scheda)schede.get(0)).getAutomobiliTrattate());
			out.close();
		}catch (Exception e){e.printStackTrace();}


	}

	public void readVeicoliTrattati(String fileName){
		try{
			DataInputStream in = new DataInputStream(new BufferedInputStream( new FileInputStream(fileName)));
			((Scheda)schede.get(0)).setAutomobiliTrattate(in.readInt());
			in.close();
		}catch (Exception e){e.printStackTrace();}


	}
}
