import java.io.*;
import java.util.*;
import java.lang.*;

public class Auto{

	private String targa;
	private String marca;
	private String modello;
	private String intestatario;

	Auto(){ targa=new String ("NO TARGA");
		marca = new String ("NO MARCA");
		modello = new String ("NO MODELLO");
		intestatario = new String ("SCONOSCIUTO");
	}

	Auto(String t, String ma, String mo){
		targa = new String(t);
		marca = new String(ma);
		modello = new String (mo);
	}

	Auto(String t, String ma, String mo, String i){
		targa = new String(t);
		marca = new String(ma);
		modello = new String (mo);
		intestatario = new String (i);
	}

	Auto(Auto a){
		this.targa= new String (a.targa);
		this.marca = new String (a.marca);
		this.modello = new String (a.modello);
		this.intestatario = new String (a.intestatario);
	}


	public String toString (){
		//return  new String ("AUTO: "+marca+" - "+modello+" TARGA"+targa+ " *** Intestata a: "+ intestatario);
		return  new String (marca+"\n"+modello+"\n"+targa+"\n"+ intestatario+"\n");

	}

	public String  getTarga(){
		return new String (targa);
	}

	public String getMarca (){
		return new String (marca);
	}

	public String getModello(){
		return new String (modello);
	}

	public String getIntestatario(){
		return new String(intestatario);
	}

	public void setTarga(String t){
		targa = new String (t);
	}

	public void setMarca (String m){
		marca = new String (m);
	}

	public void setModello(String m){
		modello = new String (m);
	}

	public void setIntestatario (String i){
		intestatario=new String(i);
	}

	public void copyTo(Auto aut){
		aut= new Auto (this);
	}

}
