#include <iostream>
#include "Student.h"
#include "Roditelj.h"

using namespace std;

int Zadatak11() {
    Student studenti[2];

    for (int i = 0; i < 2; ++i) {
        string ime, prezime;
        float prosek;

        cout << "Unesite ime, prezime i prosek studenta " << i + 1 << ": ";
        cin >> ime >> prezime >> prosek;

        studenti[i] = Student(ime, prezime, prosek);
    }

    Student najboljiStudent = studenti[0];

    for (int i = 1; i < 2; ++i) {
        if (studenti[i].getProsek() > najboljiStudent.getProsek()) najboljiStudent = studenti[i];
    }

    cout << "Najbolji student je: " << najboljiStudent.getIme() << " "
        << najboljiStudent.getPrezime() << " Prosek: " << najboljiStudent.getProsek() << endl;

    return 0;
}

int Zadatak1() {
    const int MAX_RODITELJA = 2;
    Roditelj* roditelji[MAX_RODITELJA];

    for (int i = 0; i < MAX_RODITELJA; ++i) {
        string imeRoditelja;
        int brojDece;
        cout << "Unesite ime roditelja: ";
        cin >> imeRoditelja;
        cout << "Unesite broj dece za roditelja " << imeRoditelja << ": ";
        cin >> brojDece;

        roditelji[i] = new Roditelj(imeRoditelja, brojDece);

        for (int j = 0; j < brojDece; ++j) {
            string imeDeteta;
            cout << "Unesite ime deteta " << j + 1 << " za roditelja " << imeRoditelja << ": ";
            cin >> imeDeteta;
            roditelji[i]->setImeDeteta(j, imeDeteta);
        }
    }

    int maksBrojDece = 0;
    for (int i = 0; i < MAX_RODITELJA; ++i) {
        int brojDece = roditelji[i]->getBrojDece();
        if (brojDece > maksBrojDece) maksBrojDece = brojDece;
    }

    cout << "Roditelji sa najvecim brojem dece su: ";

    for (int i = 0; i < MAX_RODITELJA; ++i) {
        if (roditelji[i]->getBrojDece() == maksBrojDece) cout << roditelji[i]->getImeRoditelja();
    }

    cout << endl;

    for (int i = 0; i < MAX_RODITELJA; ++i) {
        delete roditelji[i];
    }

    return 0;
}

int main() {
    Zadatak1();
}