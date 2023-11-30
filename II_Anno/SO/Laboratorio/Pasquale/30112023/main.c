/*
Scrivere un programma c che prenda
come input da linea di comando due nomi
di file F1 ed F2 e che scriva in F2 il
contenuto di F1 invertendo maiuscole e 
minuscole
*/

#include <stdio.h>
#include <ctype.h>

#include <stdlib.h>
#include <string.h>

// OPEN
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

// CLOSE, READ, WRITE
#include <unistd.h>


int main()
{
    char F1[255], F2[255];
    printf("Insersci il nome di F1: ");
    scanf("%s", F1);
    printf("Insersci il nome di F2: ");
    scanf("%s", F2);

    int fd1 = open(F1, O_RDONLY);
    int fd2 = open(F2, O_WRONLY);
    if (fd1 == -1 || fd2 == -1) {
        printf("Errore nell'apertura dei file\n");
        exit(EXIT_FAILURE);
    }


    char buff;
    while (read(fd1, &buff, 1) > 0) {
        buff = (islower(buff)) ? toupper(buff) : tolower(buff);
        if (write(fd2, &buff, 1) == -1) {
            printf("Errore durante la scrittura\n");
            exit(EXIT_FAILURE);
        }
    }

    close(fd1);
    close(fd2);
    return 0;
}
