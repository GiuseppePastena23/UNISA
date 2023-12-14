import java.lang.*;
import java.io.*;
import java.util.*;

public class Scheda{
 	public final static int IN_RIPARAZIONE=0;
	public final static int RIPARATO = 1;
	public final static int CONSEGNATO = 2;
	public final static int NON_PRESENTE=9;

	private static int numeroScheda=0;
	private Auto automobile=null;
	private int state= NON_PRESENTE;

	private String dataArrivo="NO_DATA";
	private String dataRilascio="NO_DATA";
	private boolean nonRiparata = true;

	private static int numeroAutomobiliOfficina = 0;
	private static int numeroAutomobiliTrattate = 0;

	Scheda(){
		++numeroScheda;
	}

	Scheda(Auto a){
		++numeroScheda;
		if (a!=null) {
			a.copyTo(automobile);
			++numeroAutomobiliOfficina;
			state= IN_RIPARAZIONE;
		}

	}

	Scheda (Auto a, String data){
		this(a);
		dataArrivo= new String (data);
	}

	Scheda (Scheda s){
		this(s.automobile);
		this.dataArrivo=new String (s.dataArrivo);
		this.dataRilascio = new String (s.dataRilascio);
		--numeroAutomobiliOfficina;
	}


	public void ingressoOfficina(String data){
		dataArrivo = new String (data);
		state=IN_RIPARAZIONE;
	}

	public void setAutomobiliOfficina(int autom){ if (autom >=0) numeroAutomobiliOfficina=autom;}

	public int getAutomobiliOfficina(){ return numeroAutomobiliOfficina;}

	public void setAutomobiliTrattate(int autom){ if (autom >=0) numeroAutomobiliTrattate=autom;}

	public int getAutomobiliTrattate(){return numeroAutomobiliTrattate;}

	public void setState(int s){
		switch(s){
			case IN_RIPARAZIONE:
				switch(state){
					case IN_RIPARAZIONE:
						System.out.println("Auto gia' in Riparazione");
						break;
					case RIPARATO:
						state = RIPARATO;
						nonRiparata= false;
						break;
					case CONSEGNATO:
						System.out.println("Auto gia' Consegnata");
						state = CONSEGNATO ;
						break;
					case NON_PRESENTE:
						System.out.println("Auto non entrata in officina");
						break;
					default :
						System.out.println("ERRORE setState");
						break;
				}
				break;

			case RIPARATO:
				switch(state){
					case IN_RIPARAZIONE:
						state=RIPARATO;
						nonRiparata=false;
						break;
					case RIPARATO:
						System.out.println("Auto gia' riparata");
						nonRiparata= false;
						break;
					case CONSEGNATO:
						state = CONSEGNATO ;
						break;
					case NON_PRESENTE:
						System.out.println("Auto non entrata in officina");
						break;
					default :
						System.out.println("ERRORE setState");
						break;

				}
				break;

			case CONSEGNATO:
				switch(state){
					case IN_RIPARAZIONE:
						state=CONSEGNATO;
						++numeroAutomobiliTrattate;
						break;
					case RIPARATO:
						state=CONSEGNATO;
						++numeroAutomobiliTrattate;
						break;
					case CONSEGNATO:
						System.out.println("Auto gia' consegnata");
						break;
					case NON_PRESENTE:
						System.out.println("Auto non entrata in officina");
						break;
					default :
						System.out.println("ERRORE setState");
						break;

				}
				break;

			case NON_PRESENTE:
				switch(state){
					case IN_RIPARAZIONE:
						state = NON_PRESENTE;
						break;
					case RIPARATO:
						state = NON_PRESENTE;
						break;
					case CONSEGNATO:
						state = NON_PRESENTE;
						break;
					case NON_PRESENTE:
						state = NON_PRESENTE;
						break;
					default :
						System.out.println("ERRORE setState");
						break;
				}
				break;

			default:
				System.out.println("ERRORE setState");
				break;
		}

	}


	public void consegna(String data){
		setState(CONSEGNATO);
		dataRilascio = new String (data);
	}

	public String toString(){
		String retval= new String ("SCHEDA : "+numeroScheda);
		retval = retval + automobile+"\n";
		retval = retval + "STATO : "+ state+"\n";
		retval = retval + "DATA ARRIVO : " + dataArrivo + " DATA RILASCIO : " + dataRilascio+"\n";
		if (!nonRiparata)
			retval = retval + " RIPARATA!\n";
		return retval;
	}

	public int getState(){
		return state;
	}

	public int getNumeroAutomobiliOfficina(){
		return numeroAutomobiliOfficina;
	}

	public int getNumeroAutomobiliTrattate(){
		return numeroAutomobiliTrattate;
	}

}
