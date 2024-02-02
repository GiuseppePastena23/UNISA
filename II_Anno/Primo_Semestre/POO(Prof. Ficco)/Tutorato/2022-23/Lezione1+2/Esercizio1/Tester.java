import java.util.*;


public class Tester {

	public static void main(String[] args) {
		
			Esame e1 = new Esame("POO",18,9);
			Esame e2 = new Esame("DB",17,9);
			Esame e3 = new Esame("Reti",30,6);
			
			Studente s1 = new Studente("1","Carlo","Rossi");
			Studente s2 = new Studente("2","Paolo","Bianchi");
			StudenteDSA s3 = new StudenteDSA("3","Tommaso","Neri","Diabete grave");
			StudenteDSA s4 = new StudenteDSA("4","Marco","Neri","Diabete lieve");
			
			s1.insertEsame(e1);
			s1.insertEsame(e3);
			
			s2.insertEsame(e2);
			s2.insertEsame(e2);
			s2.insertEsame(e3);
			
			s3.insertEsame(e1);
			s3.insertEsame(e2);
			
			ArrayList<Studente> list = new ArrayList<Studente>();
			list.add(s1);
			list.add(s2);
			list.add(s3);
			list.add(s4);
			
			StudentiManager m = new StudentiManager();
			m.setStudenti(list);
			
			//Rimuovere un for dall'implementazione del metodo
			
			System.out.println("Studenti con l'esame: " + e2);
			ArrayList<Studente> studList1 = (ArrayList<Studente>) m.getStudentiByEsame(e2);
			for(Studente s : studList1) System.out.println(s);
			
			System.out.println("\n\n");
			
			System.out.println("Studenti con l'esame: " + e3);
			ArrayList<Studente> studList2 = (ArrayList<Studente>) m.getStudentiByEsame(e3);
			for(Studente s : studList2) System.out.println(s);
			
			System.out.println("\n\nStudenti DSA");
			m.printInfoDSA();
			
			System.out.println("\n\nStudenti DSA con caratteristica comune");
			ArrayList<StudenteDSA> studList3 = (ArrayList<StudenteDSA>) m.getStudentiByPat("Diabete");
			for(Studente s : studList3) System.out.println(s);
			
			System.out.println("\n\nStudenti DSA con caratteristica comune");
			ArrayList<StudenteDSA> studList4 = (ArrayList<StudenteDSA>) m.getStudentiByPat("debole");
			for(Studente s : studList4) System.out.println(s);
			
			System.out.println("\n\nStudenti DSA con caratteristica comune");
			ArrayList<StudenteDSA> studList5 = (ArrayList<StudenteDSA>) m.getStudentiByPat("lieve");
			for(Studente s : studList5) System.out.println(s);
			
			if(m.addEsame(e3, s4)) System.out.println("\n\nEsame Registrato");
			else System.out.println("\n\nEsame NON Registrato");
			
			if(m.addEsame(e3, s4)) System.out.println("\n\nEsame Registrato");
			else System.out.println("\n\nEsame NON Registrato");
			
			System.out.println("\n\nSalvo gli Studenti");
			m.storeDSA("Studenti.txt");
			
			System.out.println("\n\nSalvo gli Studenti DSA");
			m.storeDSA("StudentiDSA.txt");
	}

}
