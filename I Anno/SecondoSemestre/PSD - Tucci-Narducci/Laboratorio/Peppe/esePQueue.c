#include "Pqueue.h"

void incrementKey(PQueue Q, int K, int newK)
{
    PQueue copy = newPQ();
    int temp;

    while(!emptyPQ(Q))
    {
        temp = getMax(Q);
        deleteMax(Q);
        if(temp == K)
        {
            temp = newK;
        }
        
        insert(copy, temp);
    }

    Q = copy;
}

PQueue copiaPQ(PQueue q1)
{
    PQueue result = newPQ();
    int temp;

    while(!emptyPQ(q1))
    {
        temp = getMax(q1);
        deleteMax(q1);
        insert(result, temp);
    }
    
    return result;
}

PQueue merge(PQueue q1, PQueue q2)
{
    PQueue merge = newPQ();
    PQueue tempQ1 = copiaPQ(q1);
    PQueue tempQ2 = copiaPQ(q2);
    int temp;

    while(!emptyPQ(tempQ1))
    {
        temp = getMax(tempQ1);
        deleteMax(tempQ1);
        insert(q1, temp);
        insert(merge, temp);
    }

    while(!emptyPQ(tempQ2))
    {
        temp = getMax(tempQ2);
        deleteMax(tempQ2);
        insert(q2, temp);
        insert(merge, temp);
    }

    return merge;
}

void sequenza(char *stringa)
{
    PQueue aggiunti = newPQ();
    PQueue rimossi = newPQ();
    int temp;

    for(int i = 0; stringa[i] != '\0'; i++)
    {
        if(stringa[i] == '*')
        {
            temp = getMax(aggiunti);
            insert(rimossi, temp);
            deleteMax(aggiunti);
        }
        else
        {
            insert(aggiunti, stringa[i]);
        }
    }

    while (!emptyPQ(rimossi))
    {
        printf("%c", getMax(rimossi));
        deleteMax(rimossi);
    }
}

