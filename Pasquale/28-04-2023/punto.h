typedef struct punto* Punto;
Punto creaPunto(double x, double y); // Costruttore della struttura PUNTO
Punto inputPunto();
double getAscissa(Punto p); // getter dell'ascissa
double getOrdinata(Punto p); // getter dell'ordinata
void stampaPunto(Punto p); // stampa i campi di Punto
double distanza(Punto p1, Punto p2); // Calcola la distanza