/*Programma che simula una piccola shell che ciclicamente deve 
stampare un prompt: %
leggere il comando inserito dall'utente dopo il prompt
creare un nuovo figlio, che dovrà eseguire il comando utente
aspettare la terminazione del figlio
Per facilitare: i comandi da eseguire non avranno argomenti*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#define MAXLEN 512		//lunghezza massima di un comando

char * prompt() {
	char * str = malloc(MAXLEN * sizeof(char));
	printf("%% ");
	scanf("%s", str);
	printf("\n");
	return str;
}

int main() {
	char * command;
	while (1) {
		command = prompt();
		pid_t figlio = fork();
		if (figlio < 0) {
			fprintf(stderr, "Errore");
			exit(-1);
		}
		else if (figlio == 0) {
			if(execlp(command, NULL) == -1)
				fprintf(stderr, "Errore");
		}
		else {
			wait(NULL);
		}
		free(command);
	}
	return 0;
}