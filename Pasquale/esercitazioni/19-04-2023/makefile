main.exe: clean list.o item.o main.o
	gcc list.o item.o main.o -o main.exe -g

main.o: list.o list.h item.o item.h
	gcc -c main.c -g

list.o: item.o item.h list.c
	gcc -c list.c -g

item.o: item.c
	gcc -c item.c -g

clean:
	rm -f *.out *.o