#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define STRLEN 30

int main(void)
{
	char str1[STRLEN+1] = "Test1";		//spazio per il terminatore
	printf("Prima stampa: %s\n", str1);
	printf("Stampa con modifica: %.4s\n", str1);		//primi 4 caratteri
	printf("Stampa con puts: ");
	puts(str1);			//inserisce automaticamente il carattere new-line
	
	char str2[STRLEN+1];
	printf("Inserisci la seconda stringa\n");
	scanf("%s", str2);		//non serve & perché viene letto come puntatore -- aggiunge sempre il tappo
	printf("Stringa ottenuta con scanf: %s\n", str2);
	//scanf si ferma agli spazi e non fa nulla riguardo il newline
	//scanf in questo modo non previene il buffer overflow -> corretta in seguito
	//fflush(stdin) non è minimamente la risposta giusta perché serve solo per l'output
	int c, i=0;
	while((c = getchar()) != '\n') {
		c = getchar();		//ripulisce lo stdin
	}
	
	//potrebbe comunque essere richiesto un invio aggiuntivo per proseguire con le azioni
	
	char str3[STRLEN+1];
	printf("Inserisci str3: \n");
	gets(str3);		//non salta spazi e tab, legge fino a newline e inserisce al suo posto il tappo
	printf("Stringa ottenuta con gets e stampata con puts: \n");
	puts(str3);
	printf("Warning: l'uso di gets è proibito\n");
	//anche gets non è in grado di prevenire il buffer overflow
	
	char str4[STRLEN+1];
	printf("Inserisci str4\n");
	scanf("%30s", str4);
	printf("Stringa ottenuta tramite scanf con %Ns: %s\n", str4); //previene overflow, ma si ferma ugualmente agli spazi
	
	while((c = getchar()) != '\n') {
		c = getchar();
	}
	
	char str5[STRLEN+1];
	printf("Inserisci str5\n");
	fgets(str5, STRLEN, stdin);
	printf("Stringa ottenuta con fgets: %s\n", str5);
	//fgets copia anche il carattere newline
	
	printf("Usiamo strlen per stampare la lunghezza delle stringhe, tappo escluso:\n");
	int num1, num2, num3, num4, num5;
	num1 = strlen(str1);
	num2 = strlen(str2);
	num3 = strlen(str3);
	num4 = strlen(str4);
	num5 = strlen(str5);
	printf("#1:%d\t#2:%d\t#3:%d\t#4:%d\t#5:%d\n", num1, num2, num3, num4, num5); 
	strcat(str1, str2); 	//potrebbe andare oltre e causare danni -> comunicare anche la lunghezza massima
	printf("Unendo 1 e 2 con strcat: %s\n", str1);
	strncat(str1, str3, sizeof(str1) - strlen(str1) -1); 	//inserisce da solo il tappo, ma va contato lo spazio
	printf("Aggiungendo str3 con strncat: %s\n", str1);
	
	return 0;
}
