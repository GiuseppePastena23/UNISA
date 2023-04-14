#include <stdio.h>

list insertList (list L, int pos, item val);
list removeList (list L, int pos);

list insertList (list L, int pos, item val)
{
	int i=0;
	list L1, prec = l;
	if(pos == 0)
	{
		return consList(val, L);
	}
	while((i < (pos-1)) && (prec != NULL)){
		prec = prec -> next;
		i++;
	}
	if(prec == NULL)
	{
		return L;
	}
	L1 = consList(val, prec -> next);
	prec -> next = L1;
	return L;
}

list removeList (list L, int pos)
{
	list L1, prec;
	int i;
	if(pos == 0)
	{
		L1 = L;
		L = tailList(L);
		free(L1);
	}
	else{
		i=0;
		prec = L;
		while((i < (pos-1)) && (prec != NULL)){
			prec = prec -> next;
			i++;
		}
		if((prec != NULL) && (prec -> next != NULL))
		{
			L1 = prec -> next;
			prec -> next = L1 -> next;
			free(L1);
		}
	}
	return L;
}