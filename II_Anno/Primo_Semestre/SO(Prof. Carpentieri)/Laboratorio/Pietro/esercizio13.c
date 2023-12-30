/*Scrivere un programma C che prende come input da linea di comando
due nomi di file F1 ed F2 e scrive in F2 il contenuto di F1,
invertendo maiuscole e minuscole*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <ctype.h>
#include <sys/types.h>
#include <limits.h>
#include <fcntl.h>

int main (int argc, char **argv) {
	char buffer;
	int in_fd, out_fd;
	
	if(argc != 3) {
		printf("Errore: numero di file non corretto\n");
		exit(-1);
	}
	
	in_fd = open(argv[1], O_RDONLY);
	out_fd = open(argv[2], O_WRONLY | O_EXCL | O_CREAT, 0644);	//0: file - 6: owner con rw - 4: group e world solo lettura
	
	if((in_fd == -1) || (out_fd == -1)) {
        printf("Errore: apertura file\n");
        exit(-2);
    }
	
    while(read(in_fd, &buffer, sizeof(buffer)) > 0) {
        buffer = (islower(buffer)) ? toupper(buffer) : tolower(buffer);
        if(write(out_fd, &buffer, sizeof(buffer)) == -1) {
            printf("Errore: scrittura\n");
            exit(-3);
        }
    }
	
	close(in_fd);
	close(out_fd);
	return 0;
}