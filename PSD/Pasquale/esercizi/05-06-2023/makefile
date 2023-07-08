programma.out: main.o item.o PQueue.o list.o
	gcc main.o item.o PQueue.o list.o -o programma.out -g

main.o: item.h PQueue.h list.h main.c
	gcc -c main.c -g

#Btree.o: item.h Btree.h Btree.c
#	gcc -c Btree.c -g
#
#BST.o: item.h BST.h BST.c
#	gcc -c BST.c -g
#
PQueue.o: item.h PQueue.h PQueue.c
	gcc -c PQueue.c -g
#
#list.o: item.h list.h list.c
#	gcc -c list.c -g
#
#stack.o: item.h stack.h stack.c
#	gcc -c stack.c -g
#
#queue.o: item.h queue.h queue.c
#	gcc -c queue.c -g

item.o: item.h item.c
	gcc -c item.c -g

clean:
	rm -f *.out *.o
