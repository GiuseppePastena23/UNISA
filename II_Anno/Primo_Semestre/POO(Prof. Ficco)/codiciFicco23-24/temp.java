//Esempi di funzioni lambda

//espressione che prende in input due interi e restituisce la somma
(int x, int y) -> x + y

//espressione che prende in input una stringa e restituisce la sua lunghezza
s -> s.length()

//espressione senza argomenti che restituisce il valore 50
() -> 50

//espressione che prende in input una stringa e non restituisce nulla
(String s) -> { System.out.println("Benvenuto ");
			   System.out.println(s); }