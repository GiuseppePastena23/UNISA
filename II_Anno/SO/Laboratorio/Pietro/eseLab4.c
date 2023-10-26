/*Scrivere un programma C che prende come input da linea di comando
due nomi di file F1 ed F2 e scrive in F2 il contenuto di F1,
invertendo maiuscole e minuscole*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

//int islower(char c)
//int isupper(char c)
//int tolower(char c)
//int toupper(char c)


int main (void) {
	FILE *fp1;
	FILE *fp2;
	char ch, result;
	fp1 = fopen("file1", "r");
	fp2 = fopen("file2", "a");
	if((fp1 == NULL) || (fp2 == NULL)) {
		printf("Errore in apertura dei file\n");
		exit(-1);
	}
	ch = fgetc(fp1);
	while (ch != EOF) {
		if(islower(ch) == 0) {	//is not a lowercase
			result = tolower(ch);
		}
		else {
			result = toupper(ch);
		}
		fputc(result, fp2);
		ch = fgetc(fp1);
	}
	fclose(fp1);
	fclose(fp2);
	return 0;
}