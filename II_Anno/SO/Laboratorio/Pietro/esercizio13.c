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

#define BUFFSIZE 1024

int main (int argc, char **argv) {
	char mybuf[BUFFSIZE], *p;
	int in_fd, out_fd, n;
	
	in_fd = open(argv[1], O_RDONLY);
	out_fd = open(argv[2], O_WRONLY | O_EXCL | O_CREAT, 0600);
	
	while((n = read(in_fd, mybuf, BUFFSIZE)) > 0) {
		for(p = mybuf; p - mybuf < n; p++) {
			if(islower(*p))
				*p = toupper(*p);
			else if(isupper(*p))
				*p = tolower(*p);
		}
		write(out_fd, mybuf, n);
	}
	close(in_fd);
	close(out_fd);
	exit(0);
}