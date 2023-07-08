#include <stdio.h>
#include <stdlib.h>

#include "libretto.h"
#include "modules/item.h"


int main(int argc, char const *argv[])
{
    libretto lib = newLibretto(1234, "Smusi", "Pietro");
    addEsame(lib, new_item("MD", 18, "01022023"));
    addEsame(lib, new_item("P1", 20, "05102023"));
    addEsame(lib, new_item("AdE", 23, "415263"));

    item cercato = cercaEsame(lib, "P1");
    if (cercato != NULL)
        output_item(cercato);
    else printf("esame non trovato\n");
    
    return 0;
}
