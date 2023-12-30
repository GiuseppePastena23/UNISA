//Programma di esempio per le Stringhe

class TestStringa {
	public static void main (String[] args) {
		String a = new String("Nel mezzo del cammin ");	//Due stringhe puntate da due riferimenti diversi
		String e = new String("Nel mezzo del cammin ");
		
		String b = "di nostra vita";	//c e d puntano alla stessa stringa puntata da b
		String c = "di nostra vita";
		String d = "di nostra vita";
		
		a = a + b;
		b = a + b;
		
		System.out.println(a);
		System.out.println(a.substring(3));
		System.out.println(a.length());
		System.out.println(b);
	}
}