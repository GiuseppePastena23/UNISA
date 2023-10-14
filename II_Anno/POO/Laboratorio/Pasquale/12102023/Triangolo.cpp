#include <iostream>
using namespace std;

class Triangle {
public:
    double base;
    double altezza;

    Triangle(double base, double altezza) {
        this->base = base;
        this->altezza = altezza;
    }

    double calcolaArea() {
        return (base * altezza) / 2;
    }
};

int main() {
    double base, altezza;
    cout << "Inserisci base" << endl;
    cin >> base;
    cout << "Inserisci altezza" << endl;
    cin >> altezza;

    Triangle *my_triangle = new Triangle(base, altezza);
    cout << "L'area e': " << my_triangle->calcolaArea() << endl;

    return 0; 
}