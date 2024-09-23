programma.out: clear main.o list.o item.o
	gcc main.o list.o item.o -o programma.out -g

main.o:	list.o list.h item.o item.h main.c
	gcc -c main.c -g

list.o: list.h item.o item.h list.c
	gcc -c list.c -g

item.o: item.h item.c
	gcc -c item.c -g

clear:
	rm -f *.o *.out