#include <iostream>
#include "Aranzman.h"

using namespace std;

int main()
{
    Aranzman a1("Bulbasaur", "Metropolitan", "Babusnica", 5, 10000.0);
    Aranzman a2("Carizard", "Singidunum", "Pantelej", 7, 15000.0);
    Aranzman a3("Psyduck", "ITAcademy", "Pirot", 10, 70000.0);
    Aranzman a4("Togapi", "ITAcademy", "Svilajnac", 3, 50000.0);

	cout << "Prosek cena po nocenju u agenciji " << a1.getImeAgencije() << " u mestu " << a1.getMesto() << " je " << a1.Prosek() << endl;
    cout << "Prosek cena po nocenju u agenciji " << a2.getImeAgencije() << " u mestu " << a2.getMesto() << " je " << a2.Prosek() << endl;
    cout << "Prosek cena po nocenju u agenciji " << a3.getImeAgencije() << " u mestu " << a3.getMesto() << " je " << a3.Prosek() << endl;
    cout << "Prosek cena po nocenju u agenciji " << a4.getImeAgencije() << " u mestu " << a4.getMesto() << " je " << a4.Prosek() << endl; 
    
    cout << "Broj kreiranih objekata: " << Aranzman::getBrojObjekata() << endl;

    return 0;
}
