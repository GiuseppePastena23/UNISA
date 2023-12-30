#include <unistd.h>
#include <stdio.h>

// exec restituisce: -1 errore, niente se tutto ok


int main()
{
    printf("Sopra la panca\n");
    //execl("/bin/echo", "echo", "la", "capra", "campa", NULL);
    execlp("echo", "echo", "la", "capra", "campa", NULL); //non si usa path assoluto per echo
    printf("Prova"); // il programma non arrivera' mai a questa linea perche execl sostituisce il programma
}