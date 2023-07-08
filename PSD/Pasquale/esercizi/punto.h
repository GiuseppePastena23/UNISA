typedef struct punto_tag *punto;
punto new_punto(double x, double y);
punto input_punto();
double getAscissa(punto p);
double getOrdinato(punto p);
void stampapunto(punto p);
double distanza(punto p1, punto p2);