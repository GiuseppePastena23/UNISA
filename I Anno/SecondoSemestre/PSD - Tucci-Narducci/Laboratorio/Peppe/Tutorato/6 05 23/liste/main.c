#include "item.h"
#include "list.h"

item max_duplication(list L)
{
    int duplicati = 0;
    int res = 0;
    item rItem;

    for(int i = 0; i < sizeList(L); i++)
    {
        for(int j = 1; j < sizeList(L); j++)
        {
            if(eq(getItem(L, i),getItem(L, i)))
                {
                    duplicati++;
                }
            if(res < duplicati)
            {
                res = duplicati;
                rItem = getItem(L, i);
            }
        }
    }

    return rItem;
}