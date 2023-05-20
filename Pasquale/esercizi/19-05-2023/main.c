#include <stdio.h>
#include <stdlib.h>
#include "item.h"
#include "Btree.h"

item minimo(Btree tree)
{
    if (figlioSX(tree) == NULL && figlioDX(tree) == NULL)
    {
        return getItem(tree);
    }
    else
    {
        item actual = getItem(tree);
        item minSX = minimo(figlioSX(tree));
        item minDX = minimo(figlioDX(tree));
        item minTree = actual < minSX ? actual : minSX;
        return minTree < minDX ? minTree : minDX;
    }
}

int massimo(Btree tree)
{
    if (figlioSX(tree) == NULL && figlioDX(tree) == NULL)
    {
        return getItem(tree);
    }
    else
    {
        item actual = getItem(tree);
        item maxSX = massimo(figlioSX(tree));
        item maxDX = massimo(figlioDX(tree));
        item maxTree = actual > maxSX ? actual : maxSX;
        return maxTree > maxDX ? maxTree : maxDX;
    }
}

int conta_foglie(Btree tree)
{
    if (figlioSX(tree) == NULL && figlioDX(tree) == NULL)
    {
        return 1;
    }

    else
    {
        return conta_foglie(figlioSX(tree)) + conta_foglie(figlioDX(tree));
    }
}

Btree arrayToBtree(item values[], int start, int end)
{
    if (start > end)
    {
        return NULL;
    }

    int mid = (start + end) / 2;
    item el = values[mid];
    Btree t1 = arrayToBtree(values, start, mid - 1);
    Btree t2 = arrayToBtree(values, mid + 1, end);
    return consBtree(el, t1, t2);
}

int main(int argc, char const *argv[])
{
    int array[50], size, tmp;
    FILE *f = fopen("valori.txt", "r");
    for (size = 0; fscanf(f, "%d", &tmp) != EOF; size++)
    {
        array[size] = tmp;
    }

    Btree alberello = arrayToBtree(array, 0, size - 1);
    printf("%d\n", minimo(alberello));
    printf("%d\n", massimo(alberello));

    return 0;
}
