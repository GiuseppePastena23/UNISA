CC = gcc
CFLAGS = -Wall -Wextra -g

# Nome del programma di output
TARGET = programma.out

# Elenco dei file oggetto
OBJS = main.o Btree.o item.o queue.o list.o

# Regola per generare il programma di output
$(TARGET): clean $(OBJS)
	$(CC) $(CFLAGS) -o $(TARGET) $(OBJS)

# Regola per il file oggetto main.o
main.o: main.c Btree.h item.h queue.h list.h
	$(CC) $(CFLAGS) -c main.c

# Regola per il file oggetto Btree.o
Btree.o: Btree.c Btree.h item.h
	$(CC) $(CFLAGS) -c Btree.c

# Regola per il file oggetto item.o
item.o: item.c item.h
	$(CC) $(CFLAGS) -c item.c

# Regola per il file oggetto queue.o
queue.o: queue.c queue.h item.h
	$(CC) $(CFLAGS) -c queue.c

# Regola per il file oggetto list.o
list.o: list.c list.h item.h
	$(CC) $(CFLAGS) -c list.c

# Pulizia dei file oggetto e del programma di output
clean:
	rm -f $(OBJS) $(TARGET)
