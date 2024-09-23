CC = gcc
CFLAGS = -Wall -Wextra -pedantic -g
OBJ = main.o Btree.o stack.o item.o

all: clear programma.out

programma.out: $(OBJ)
	$(CC) $(CFLAGS) $^ -o $@

%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

clear:
	rm -f $(OBJ) programma.out
