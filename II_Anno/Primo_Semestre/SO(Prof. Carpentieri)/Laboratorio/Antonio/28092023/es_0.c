#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main (void)
{
    printf("\n\n");

    printf("Il pid del processo: %d\n", getpid());
    printf("Il pid del padre del processo: %d\n", getppid());

    printf("\nFine programma.\n\n");
}