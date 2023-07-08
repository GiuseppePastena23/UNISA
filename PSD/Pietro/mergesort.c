/* Il mergesort è stato inventato da Von Neumann nel 1945 che consiste nel dividere il vettore in parti,
ordinarle e fonderle assieme; nel fare ciò richiede spazio ausiliario.
Il suo codice è ricorsivo: il vettore viene diviso in sottovettore destro e sinistro
e le divisioni finiscono quando l'estremo inferiore coincide o supera l'estremo superiore
Notare che la divisione è solo logica */

#include <stdio.h>
#define MAX 10

void mergesort(int A[], int p, int r);
void merge(int A[], int p, int q, int r);

void mergesort(int A[], int p, int r) {
	int q;
	if(p < r) {
		q = (p + r) / 2;
		mergesort(A, p, q);			//chiamata ricorsiva sulla metà di destra
		mergesort(A, (q + 1), r);	//chiamata ricorsiva sulla metà di sinistra
		merge(A, p, q, r);			//funzione che si occupa di "fondere" le due metà 
	}
	return;
}

void merge(int A[], int p, int q, int r) {
	int B[MAX], i = p, j = q + 1, k = p;		//vettore d'appoggio ipoteticamente grande quanto A
	while((i <= q) && (j <= r)) {				//il ciclo si interrompe quando una delle due metà termina
		if(A[i] < A[j]) {
			B[k++] = A[i++];
		}
		else {
			B[k++] = A[j++];
		}
	}
	while(i <= q) {			//il vettore dx è terminato, quindi per le copie non serve effettuare controlli
		B[k++] = A[i++];
	}
	while(j <= r) {			//mutualmente esclusivo con il ciclo precedente
		B[k++] = A[j++];
	}
	for(k = p; k <= r; k++) {		//ciclo per ricopiare gli elementi ordinati dal vettore d'appoggio in A
		A[k] = B[k];
	}
	return;
}