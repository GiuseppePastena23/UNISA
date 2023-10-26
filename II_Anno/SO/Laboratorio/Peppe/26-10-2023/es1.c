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
        if(WIFEXITED(status)) // determina se la terminazione e' stata volontaria o involontaria
        {
            printf("Terminazione volontaria di %d con stato %d\n",pid, WEXITSTATUS(status)); // prende lo stato di terminazione
        }
        else if(WIFSIGNALED(status))
        {
            printf("Terminazione involontaria di %d per segnale %d\n",pid, (char)status);
        }

    }
}

