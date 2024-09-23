/*Calcola il volume di un generico parallelepipedo*/
//funzione usando gli int e funzione usando i float

#include<stdio.h>
void calcolo_int(int scelta);
void calcolo_float(int scelta);
int main();

int main()
{
	int scelta;
	printf("Questo programma calcola il valore di un parallelepipedo\n");
	printf("Userai numeri interi o con la virgola?\n");
	printf("1: interi\t2: decimali\n");
	scanf("%d", &scelta);
	if(scelta == 1)
	{
		calcolo_int(scelta);
	}
	if(scelta == 2)
	{
		calcolo_float(scelta);
	}
	/*switch(scelta){
		case 1:{
			calcolo_int(scelta);
		}break;
		case 2:{
			calcolo_float(scelta);
		}break;
		default:{
			printf("Input errato\n");
		}
	}*/
	return 0;
}

void calcolo_int(int scelta)
{
	int lunghezza, larghezza, altezza, volume;
	printf("Inserire il valore della lunghezza \n");
	scanf("%d", &lunghezza);
	printf("Inserire il valore della larghezza \n");
	scanf("%d", &larghezza);
	printf("Inserire il valore della altezza \n");
	scanf("%d", &altezza);
	volume = lunghezza * larghezza * altezza;
	printf("Il volume è: %d\n", volume);
}

void calcolo_float(int scelta)
{
	float lunghezza, larghezza, altezza, volume;
	printf("Inserire il valore della lunghezza\n");
	scanf("%f", &lunghezza);
	printf("Inserire il valore della larghezza\n");
	scanf("%f", &larghezza);
	printf("Inserire il valore della altezza\n");
	scanf("%f", &altezza);
	volume = lunghezza * larghezza * altezza;
	printf("Il volume è: %4.2f\n", volume);
}