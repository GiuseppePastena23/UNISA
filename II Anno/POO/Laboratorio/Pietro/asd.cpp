#include <iostream>		//stdio
using namespace std 	//evita di scrivere std:: ad ogni chiamata di cout e cin

class Triangle {
public:
	double base;
	double altezza;
	
	Triangle (double base, double altezza) {
		this->base = base;
		this->altezza = altezza;
	}
	
	double calcolo () {
		return ((base * altezza) / 2);
	}
}

int main () {
	double base, altezza;
	cout << "Inserisci base" << endl;
	cin >> base;
	cout << "Inserisci altezza" << endl;
	cin >> altezza;
	
	Triangle *t1 = new Triangle (base, altezza);
	cout << "L'area è: " + t1->calcolo() << endl;
	
	return 0;
}