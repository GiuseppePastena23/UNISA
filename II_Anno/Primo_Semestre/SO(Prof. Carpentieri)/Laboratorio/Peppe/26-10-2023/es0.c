//
// Created by peppe on 10/26/23.
//
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(void)
{
    int pid, status;
    pid = fork();

    if(pid == 0)
    {
        printf("figlio: sto per terminare\n");
        exit(2);
    }
    else
    {
        pid = wait(&status);
        printf("Termina il figlio con pid %d\n", pid);
        if((char) status == 0) // controlla se gli 8 bit meno significativi sono 0(terminazione volontaria) o 1(terminazione involntaria
        {
            printf("Terminazione volontaria con stato %d\n", status>>8); // shift rimuovendo gli 8 bit meno significativi per prendere lo stato di terminazione
        }
        else
        {
            printf("Terminazione involontaria per segnale %d\n", (char)status);
        }

    }
}

