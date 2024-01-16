import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class EsempioStream {
	public static void main(String[] args) {
		
		//1: filtraggio
		System.out.println("Prima parte:");
		List <String> frutti = Arrays.asList("Arancia", "Banana", "Mango", "Mela", "Uva");	//crea la lista tramite gli elementi forniti dall'array
		frutti.stream()
			.filter(frutto -> frutto.startsWith("M"))
			.forEach(System.out::println);	//method reference che sostituisce (frutto) -> System.out.println(frutti)
		
		//2: trasformazione degli elementi tramite map
		System.out.println("\nSeconda parte:");
		List <String> parole = Arrays.asList("Java", "Stream", "Esempio");
		List <String> maiuscole = parole.stream()
			.map(String::toUpperCase)
			.collect(Collectors.toList());
		System.out.println(maiuscole);
		
		//3: reduce
		System.out.println("\nTerza parte:");
		int[] numeri = {1, 2, 3, 4, 5};
		int somma = Arrays.stream(numeri)	//IntStream
			.reduce(0, (a, b) -> a + b);	//0 valore iniziale, espressione lambda che specifica come accumulare gli elementi
		System.out.println("Somma: " + somma);
		
		//4: parallel
		System.out.println("\nQuarta parte:");
		int[] altriNumeri = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		long count = Arrays.stream(altriNumeri)
			.parallel()		//rende lo stream parallelo
			.filter(n -> n % 2 == 0)
			.count();
		System.out.println("Ci sono " + count + " numeri pari");
		
		//5: quadrati senza duplicati
		System.out.println("\nQuinta parte:");
		List <Integer> numeriDisordinati = Arrays.asList(1, 2, 5, 6, 8, 4, 2, 9, 10, 0, 1, 4, 5, 3, 7, 4, 6, 2, 11);
		List <Integer> quadratiDistinti = numeriDisordinati.stream()
			.distinct()		//per rimuovere dalla lista i duplicati
			.map(j -> j * j)
			.sorted()
			.collect(Collectors.toList());
		System.out.println("Quadrati distinti: " + quadratiDistinti);
	}
}