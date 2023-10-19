package file_biblioteca;
import java.io.*;
import java.util.Scanner;
public class File_biblioteca 
{
	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
    		Scanner in = new Scanner(System.in);      
    		int codice, sc, ncopie;
    		long pos;
    		String titolo,testo,titolo1;
    		char risp;
    		boolean trovato;
		do 
    		{
        		System.out.println("1) Inserisci -  2) Stampa - 3) Prestito - 4) Reso - 0) Fine");
        		sc = in.nextInt();
        		switch(sc)
        		{
            			case 1:
            				RandomAccessFile fbib = new RandomAccessFile("biblioteca.dat", "rw");
            				fbib.seek(fbib.length());
	    				do 
            				{    
            					System.out.println("Codice: ");
            					codice = in.nextInt();
            					System.out.println("Titolo: ");
            					titolo = in.next();
            					System.out.println("Numero copie: ");
            					ncopie = in.nextInt();                    
            					fbib.writeInt(codice);
            					fbib.writeUTF(titolo);
            					fbib.writeInt(ncopie);
            					System.out.println("Altro record [s/n] " );
            					risp = in.next().charAt(0);
            				}while (risp == 's');
					fbib.close();  
            			break;
            
            			case 2: 
            				RandomAccessFile fbib = new RandomAccessFile("biblioteca.dat", "rw");
            				while (fbib.getFilePointer() < fbib.length())
            				{
	    					codice = fbib.readInt();
            					titolo = fbib.readUTF();
            					ncopie = fbib.readInt();
            					System.out.println("Codice = " + codice + " Titolo = " + titolo + " Ncopie = " + ncopie);
            				}
            				fbib.close();                
            			break;
            
            			case 3:
            				RandomAccessFile fbib = new RandomAccessFile("biblioteca.dat", "rw");
            				System.out.println("Inserisci il titolo ");
            				titolo1 = in.next();
            				trovato = false;
            				while (fbib.getFilePointer() < fbib.length())
            				{
            					pos = fbib.getFilePointer();
	    					codice = fbib.readInt();
            					titolo = fbib.readUTF();
            					ncopie = fbib.readInt();
            					if (titolo1.equals(titolo))
            					{
                					if(ncopie > 0)
                					{            
                    						ncopie--;
                    						System.out.println("Prestito effettuato");
                					}
             						fbib.seek(pos);
             						fbib.writeInt(codice);
             						fbib.writeUTF(titolo);
             						fbib.writeInt(ncopie);
           						trovato = true;
						}
            
            				}
            				if (!trovato)
            					System.out.println("Libro non trovato");
            				fbib.close();    
            			break;
            
            			case 4:
                			RandomAccessFile fbib = new RandomAccessFile ("biblioteca.dat", "rw");
                			System.out.println("Inserisci titolo: ");
                			titolo1 = in.next();
                			trovato = false;
                			while(fbib.getFilePointer() < fbib.length())
                			{
                    				pos = fbib.getFilePointer();
                    				codice = fbib.readInt();
                    				titolo = fbib.readUTF();
                    				ncopie = fbib.readInt();
                    				if(titolo1.equals(titolo))
                    				{
                        				ncopie++;
                        				trovato = true;
                        				fbib.seek(pos);
                        				fbib.writeInt(codice);
                        				fbib.writeUTF(titolo);
                        				fbib.writeInt(ncopie);
                        				System.out.println("Libro restituito");
                    				}
                			}
                			if (!trovato)
                    				System.out.println("Libro non trovato");
                			fbib.close();
           			break;
        		}
    		}while (sc != 0);
    	}
    
}