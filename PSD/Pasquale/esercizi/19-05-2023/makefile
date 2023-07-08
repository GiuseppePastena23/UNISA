programma.out: clean main.o Btree.o item.o
	gcc main.o Btree.o item.o -o programma.out -g

main.o: Btree.h item.h main.c
	gcc -c main.c -g

Btree.o: item.h Btree.h Btree.c
	gcc -c Btree.c -g

item.o: item.h item.c
	gcc -c item.c -g

clean:
	rm -f *.out *.o
