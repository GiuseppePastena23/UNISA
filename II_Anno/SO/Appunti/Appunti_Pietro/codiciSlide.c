Pseudocodici slide SO con commenti e spiegazioni

PROBLEMA PRODUTTORE/CONSUMATORE A MEMORIA LIMITATA
//variabili condivise
#define BUFFER_SIZE 10;
typedef struct {
	...
}item;
item buffer[BUFFER_SIZE];
int in = 0, out = 0;
//Processo produttore
item Processo_produttore
while(1){
	while(((in+1) % BUFFER_SIZE) == out); //non fa nulla
	buffer[in] = nextProduced;
	in = (in+1) % BUFFER_SIZE;
}
//Processo consumatore
item Processo_consumatore
while(1) {
	while(in == out); //non fa nulla
	nextConsumed = buffer[out];
	out = (out+1) % BUFFER_SIZE;
}

PROD/CONS CON N ELEMENTI
//condivisi
#define BUFFER_SIZE 10;
typedef struct {
	...
}item;
item vettore[BUFFER_SIZE];
int inserisci = 0, preleva = 0, contatore = 0;
//produttore
item appena_prodotto;
while(1) {
	while (contatore == BUFFER_SIZE); //non fa nulla
	vettore[inserisci] = appena_prodotto;
	inserisci = (inserisci + 1) % BUFFER_SIZE;
	contatore++;
}
//consumatore
item da_consumare;
while(1) {
	while (contatore == 0); //non fa nulla
	da_consumare = vettore[preleva];
	preleva = (preleva + 1) % BUFFER_SIZE;
	contatore--;
}
Incremento e decremento non devono essere in race condition

PRIMO ALGORITMO PER RISOLVERE LA SEZIONE CRITICA CON DUE PROCESSI
//condivise
int turno = 0;
//processo Pi
do {
	while (turno != i);
	//sezione critica
	turno = j;
	//sezione non critica
}while(true);

SECONDO ALGORITMO PER RISOLVERE LA SEZIONE CRITICA CON DUE PROCESSI
//condivise
boolean pronto[2]; //tutto a false
//processo Pi
do {
	pronto[i] := true;
	while (pronto[j]);
	//sezione critica
	pronto[i] = false;
	//sezione non critica
}while(true);

SOLUZIONE DI PETERSON PER RISOLVERE LA SEZIONE CRITICA CON DUE PROCESSI
//condivise
int turno = 0;
boolean pronto[2]; //tutto a false
//processo Pi
do {
	pronto[i] := true;
	turno = j;
	while (pronto[j] && turno == j);
	//sezione critica
	pronto[i] = false;
	//sezione non critica
} while (true);

ALGORITMO DEL FORNAIO - SINCRONIZZAZIONE DI N PROCESSI
//condivise
boolean scelta[n];	//tutto a false
int numero[n];	//tutto a 0
//algoritmo
do{
	scelta[i] = true;
	numero[i] = max(numero[0],...,numero[n-1]) + 1;
	scelta[i] = false;
	for(j=0; j<n; j++) {
		while(scelta[j]);
		while((numero[j]!=0) && ((numero[j],j)<(numero[i],i)));
	}
	//sezione critica
	numero[i] = 0;
	//sezione non critica
}while(true);

TESTANDSET
boolean TestAndSet(boolean *obiettivo) {
	boolean valore = *obiettivo;
	*obiettivo = true;
	return valore;
}

MUTUA ESCLUSIONE TestAndSet
//condivise
boolean blocco = false;
//Processo Pi
do {
	while(TestAndSet(&blocco));
	//sezione critica
	blocco = false;
	//sezione non critica
}while (true);

SWAP
void Swap(boolean *a, boolean *b) {
	boolean temp = *a;
	*a = *b;
	*b = temp;
}

MUTUA ESCLUSIONE SWAP
//condivise
boolean blocco = false;
//processo Pi
do {
	chiave = true;
	while(chiave == true)
		Swap(&blocco, &chiave);
	//sezione critica
	blocco = false;
	//sezione non critica
}while(true);

MUTUA ESCLUSIONE E ATTESA LIMITATA TestAndSet
//condivise
boolean blocco, attesa[n];
//processo Pi
do {
	attesa[i] = true;
	chiave = true;
	while(attesa[i] && chiave)
		chiave = TestAndSet(&blocco);
	attesa[i] = false;
	//sezione critica
	j = (i+1) % n;
	while((j!=i) && !attesa[j])
		j = (j+1) % n;
	if(j==i)
		blocco = false;
	else
		attesa[j] = false;
	//sezione non critica
}while(true);

OPERAZIONI SEMAFORI
wait(S): {
	while(S <= 0);
	S--;
}
signal(S): {
	S++;
}

MUTUA ESCLUSIONE SEMAFORI
//condivise
semaforo mutex = 1;
//processo Pi
do {
	wait(mutex);
	//sezione critica
	signal(mutex);
	//sezione non critica
}while(1);

DEFINIZIONE SEMAFORO E OPERAZIONI
typedef struct{
	int valore;
	struct processo *L;
}semaforo;

void wait (semaforo *S) {
	S.valore --;
	if (S.valore < 0) {
		//aggiungi questo processo a S.L;
		block();
	}
}

void signal (semaforo *S) {
	S.valore ++;
	if(S.valore <= 0) {
		//togli un processo P da S.L;
		wakeup(P);
	}
}

SEMAFORO CONTATORE CON SEMAFORI BINARI
//condivise
semaforo_binario S1=1, S2=0;
int C = //valore iniziale del semaforo contatore S
//codice
wait:
	wait(S1);
	C--;
	if (C<0) {
		signal(S1);
		wait(S2);
	}
	signal(S1);
signal:
	wait(S1);
	C++;
	if(C <= 0)
		signal(S2);
	else
		signal(S1);

PROD/CONS CON SEMAFORI
//condivise
item vettore[n];
semaforo piene=0, vuote=n, mutex=1;
//produttore
do {
	...
	//produce un elemento in appena_prodotto
	...
	wait(vuote);
	wait(mutex);
	...
	//inserisci in vettore l'elemento in appena_prodotto
	...
	signal(mutex);
	signal(piene);
}while(true);
//consumatore
do {
	wait(piene);
	wait(mutex);
	...
	//rimuovi un elemento da vettore e mettilo in da_consumare
	...
	signal(mutex);
	signal(vuote);
	...
	//consuma l'elemento contenuto in da_consumare
	...
}while(true);

LETTORI E SCRITTORI
//condivise
int numlettori = 0;
semaforo mutex = 1, scrittura = 1;
//scrittore
do{
	wait(scrittura);
	...
	//esegui l'operazione di scrittura
	...
	signal(scrittura);
}while(true);
//lettore
do{
	wait(mutex);
	numlettori++;
	if(numlettori==1)
		wait(scrittura);
	signal(mutex);
	...
	//esegui l'operazione di lettura
	...
	wait(mutex);
	numlettori--;
	if(numlettori==0)
		signal(scrittura);
	signal(mutex);
}while(true);

PROBLEMA DEI CINQUE FILOSOFI
//condivise
semaforo bacchette[5]; //tutto a 1
//filosofo i
do{
	wait(bacchetta[i]);
	wait(bacchetta[(i+1)%5]);
	...
	//mangia
	...
	signal(bacchetta[i]);
	signal(bacchetta[(i+1)%5]);
	...
	//pensa
	...
}while(true);

SINTASSI MONITOR
monitor nome-monitor
{
	dichiarazione di variabili condivise
	
	procedure body P1(...) {
		...
	}
	procedure body Pn(...) {
		...
	}
	{
		codice di inizializzazione
	}
}

CINQUE FILOSOFI CON MONITOR
monitor fc {
	enum (pensa, affamato, mangia) stato[5]; //tre stati possibili
	condition auto[5];
	
	void prende(int i) {
		stato[i] = affamato;
		verifica(i);
		if(stato[i]!=mangia)
			auto[i].wait();
	}
	void posa(int i) {
		stato[i] = pensa;
		//verifica lo stato dei vicini sx e dx:
		verifica((i+4) % 5);
		verifica((i+1) % 5);
	}
	void verifica(int i) {
		if((stato[(i+4)%5]!=mangia)&&(stato[i]==affamato)&&(stato[(i+1)%5]!=mangia)){
			stato[i]=mangia;
			auto[i].signal();
		}
	}
	
	void inizializzazione() {
		for(int i = o; i < 5; i++)
			stato[i] = pensa;
	}
}