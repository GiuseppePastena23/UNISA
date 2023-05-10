#include "modules/item.h"
#include "modules/list.h"

typedef struct libretto_tag *libretto;
libretto newLibretto(int, char[], char[]);
libretto addEsame(libretto, item);
list dammiEsami(libretto);
item cercaEsame(libretto, char[]);
