#include <stdio.h>
#include "ADT/LISTA/lista_intest.h"

list intreccia(list A, list B);
void rimuovi_minimo(list L);
item minList(list L);
item secondo_minimo(list L);
item skip_minList(list L, int pos);

/*ANALISI DI INTRECCIA
SPECIFICA SEMANTICA E SINTATTICA:
intreccia (lista, lista) -> lista
intreccia (list A, list B) = list C
precondizioni: A = <a1, a2, ..., an> e B = <b1, b2, ..., bm>, con n = m
postcondizioni: dati A e B, C = <a1, b1, a2, b2, ..., an, bm>
PROGETTAZIONE:
1. Dateu 2 liste A e B, controllo che abbiano la stessa lnghezza e salvo il valore in una variabile
2. Creo una nuova lista C, inizialmente vuota
3. Scorro la lista per i che va da m-1 a 0, inserendo prima l'elemento i-esimo di B e poi quello di A in testa a C
4. Restituisco C
*/

list intreccia(list A, list B) {
	int i, m;
	list C = newList();
	if((C == NULL) || ((m = sizeList(A)) != sizeList(B)))
		return C;
	for(i = (m - 1); i >=0; i--) {
		insertList(C, 0, getItem(B, i));
		insertList(C, 0, getItem(A, i));
	}
	return C;
}

/*ANALISI DI RIMUOVI_MINIMO
SPECIFICA SEMANTICA E SINTATTICA
rimuovi_minimo (lista) -> void
rimuovi_minimo (list L)
precondizioni: nessuna
postcondizioni: Ad L viene tolta ogni occorrenza del valore minimo
PROGETTAZIONE:
1. Se L è vuota, termina
2. Trovo il valore minimo e lo salvo nella variabile min (richiede raffinamento: nuova funzione)
3. Scorro la lista per i che va da 0 a size: se ai, i-esimo elemento di L, è uguale a min, rimuovo ai
*/

void rimuovi_minimo(list L) {
	if(emptyList(L))
		return;
	item min = minList(L);
	int i, size = sizeList(L);
	for(i = 0; i < size; i++) {
		if(eq(getItem(L, i), min)) {
			removeList(L, i);
			i--;
			size--;
		}
	}
}

/*ANALISI DI MINLIST
SPECIFICA SEMANTICA E SINTATTICA
minlist (lista) -> item
minlist (lista L) = item min
precondizioni: L non vuota
postcondizioni: se L = <a1, a2, ..., an>, allora min < ai, con 1 <= i <= n
PROGETTAZIONE:
1. Pongo min uguale al primo item di L
2. Per i che va da 1 a size, se ai è minore di min, allora assegno ai a min
3. Restituisco min
*/

item minList(list L) {
	item min = getItem(L, 0), val;
	int i, size = sizeList(L);
	for(i = 0; i < size; i++) {
		val = getItem(L, i);
		if(val < min)
			min = val;
	}
	return min;
}

/*ANALISI DI SECONDO_MINIMO
SPECIFICA SEMANTICA E SINTATTICA
secondo_minimo (lista) -> item
secondo_minimo (list L) -> item sec
precondizioni: L contiene almeno un item
postcondizioni: se L = <a1, a2, ..., an>, e min < ai, con 1 <= i <= n, allora sec è maggiore di min e sec < ai, con 1 <= i <= n
PROGETTAZIONE:
1. Trovo il valore minimo e lo salvo nella variabile min (richiede raffinamento: nuova funzione)
2. Trovo la posizione di min e la salvo in una variabile pos (non ci sono valori ripetuti)
3. Cerco il valore minimo saltando la posizione di min e lo salvo nella variabile sec (richiede raffinamento: nuova funzione)
4. Restituisco sec
*/

item secondo_minimo(list L) {
	item min = minList(L), sec;
	int pos = posItem(L, min);
	sec = skip_minList(L, pos);
	return sec;
}

/*ANALISI DI SKIP_MINLIST
SPECIFICA SEMANTICA E SINTATTICA
skip_minList (lista, intero) -> item
skip_minList (list L, int pos) = item sec
precondizioni: L contiene almeno un item
postcondizioni: se L = <a1, a2, ..., an>, allora min <ai, con 1 <= i < pos e pos < i <= n
PROGETTAZIONE:
1. Pongo sec uguale al primo item di L
2. Per i che va da 1 a pos, se ai è minore di sec, assegno ai a sec
3. Per i che va da (pos + 1) a size, se ai è minore di sec, assegno ai a sec
4. Restituisco sec;
*/
item skip_minList(list L, int pos) {
	item sec = getItem(L, 0), val;
	int i, size = sizeList(L);
	for(i = 0; i < pos; i++) {
		val = getItem(L, i);
		if(val < sec)
			sec = val;
	}
	for(i = (pos + 1); i < size; i++) {
		val = getItem(L, i);
		if(val < sec)
			sec = val;
	}
	return sec;
}