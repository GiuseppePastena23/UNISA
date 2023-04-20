#include <stdio.h>
#include <stdlib.h>
#include "list.h"
#include "item.h"

int main(int argc, char const *argv[]) {
    list nuova = newList();
    insertList(nuova, 0, 1);
    insertList(nuova, 0, 2);
    insertList(nuova, 0, 3);

    outputList(nuova);

    return 0;
}
