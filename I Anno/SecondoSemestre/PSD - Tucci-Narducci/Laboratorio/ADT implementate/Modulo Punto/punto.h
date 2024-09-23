//Struttura che contiene i dati necessari a rappresentare un punto: le sue coordinate
typedef struct punto *Punto;

/*SPECIFICA SINTATTICA E SEMANTICA
creaPunto(double, double) -> Punto
creaPunto(x, y) -> p
precondizioni: nessuna
postcondizioni: il punto ottenuto ha ascissa x ed ordinata y*/
Punto creaPunto(double x, double y);

/*SPECIFICA SINTATTICA E SEMANTICA
inputPunto() -> Punto
inputPunto() -> p
precondizioni: nessuna
postcondizioni: il punto ottenuto ha ascissa x ed ordinata y*/
Punto inputPunto();

/*SPECIFICA SINTATTICA E SEMANTICA
getAscissa(Punto) -> double
getAscissa(p) -> x
precondizioni: il Punto deve essere correttamente allocato
postcondizioni: x contiene l'ascissa del Punto p*/
double getAscissa(Punto p);

/*SPECIFICA SINTATTICA E SEMANTICA
getOrdinata(Punto) -> double
getOrdinata(p) -> y
precondizioni: il Punto deve essere correttamente allocato
postcondizioni: y contiene l'ordinata del Punto p*/
double getOrdinata(Punto p);

/*SPECIFICA SINTATTICA E SEMANTICA
stampaPunto(Punto) -> void
stampaPunto(p) -> void
precondizioni: il Punto deve essere correttamente allocato
postcondizioni: nessuna*/
void stampaPunto(Punto p);

/*SPECIFICA SINTATTICA E SEMANTICA
distanza(Punto, Punto) -> double
distanza(p1, p2) -> d
precondizioni: i Punti devono essere correttamente allocati
postcondizioni: d indica la distanza tra i due Punti e viene calcolata con il teorema di Pitagora*/
double distanza(Punto p1, Punto p2);