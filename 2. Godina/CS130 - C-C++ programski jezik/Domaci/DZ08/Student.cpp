#include "Student.h"
#include <iostream>

using namespace std;

Student::Student() : ime(""), prezime(""), prosek(0.0) {}

Student::Student(const string& ime, const string& prezime, float prosek)
    : ime(ime), prezime(prezime), prosek(prosek) {}

Student::Student(const Student& other) : ime(other.ime), prezime(other.prezime), prosek(other.prosek) {}

Student::~Student() {
    cout << "Objekat je unisten" << endl;
}

void Student::setIme(const string& ime) {
    this->ime = ime;
}

void Student::setPrezime(const string& prezime) {
    this->prezime = prezime;
}

void Student::setProsek(float prosek) {
    this->prosek = prosek;
}

string Student::getIme() const {
    return ime;
}

string Student::getPrezime() const {
    return prezime;
}

float Student::getProsek() const {
    return prosek;
}
