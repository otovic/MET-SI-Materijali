#include "Aranzman.h"

using namespace std;

int Aranzman::brojObjekata = 0;

Aranzman::Aranzman() {
    brojObjekata++;
}

Aranzman::Aranzman(string agencija, string hotel, string mesto, int nocenja, double cena) {
    imeAgencije = agencija;
    imeHotela = hotel;
    this->mesto = mesto;
    brojNocenja = nocenja;
    cenaAranzmana = cena;
    brojObjekata++;
}

Aranzman::~Aranzman() {
    brojObjekata--;
}

int Aranzman::getBrojObjekata() {
    return brojObjekata;
}

string Aranzman::getImeAgencije() {
    return imeAgencije;
}

string Aranzman::getImeHotela() {
    return imeHotela;
}

string Aranzman::getMesto() {
    return mesto;
}

int Aranzman::getBrojNocenja() {
    return brojNocenja;
}

double Aranzman::getCenaAranzmana() {
    return cenaAranzmana;
}

void Aranzman::setImeAgencije(string agencija) {
    imeAgencije = agencija;
}

void Aranzman::setImeHotela(string hotel) {
    imeHotela = hotel;
}

void Aranzman::setMesto(string mesto) {
    this->mesto = mesto;
}

void Aranzman::setBrojNocenja(int nocenja) {
    brojNocenja = nocenja;
}

void Aranzman::setCenaAranzmana(double cena) {
    cenaAranzmana = cena;
}

double Aranzman::Prosek() {
    return cenaAranzmana / brojNocenja;
}

ostream& operator<<(ostream& os, const Aranzman& aranzman) {
    os << "Agencija: " << aranzman.imeAgencije << ", Hotel: " << aranzman.imeHotela << ", Mesto: " << aranzman.mesto
        << ", Broj nocenja: " << aranzman.brojNocenja << ", Cena: " << aranzman.cenaAranzmana;
    return os;
}

istream& operator>>(istream& is, Aranzman& aranzman) {
    cout << "Unesite ime agencije: ";
    is >> aranzman.imeAgencije;
    cout << "Unesite ime hotela: ";
    is >> aranzman.imeHotela;
    cout << "Unesite mesto: ";
    is >> aranzman.mesto;
    cout << "Unesite broj nocenja: ";
    is >> aranzman.brojNocenja;
    cout << "Unesite cenu aranzmana: ";
    is >> aranzman.cenaAranzmana;
    return is;
}

bool Aranzman::operator<(const Aranzman& other) const {
    return cenaAranzmana < other.cenaAranzmana;
}

bool Aranzman::operator>(const Aranzman& other) const {
    return cenaAranzmana > other.cenaAranzmana;
}

bool Aranzman::operator==(const Aranzman& other) const {
    return cenaAranzmana == other.cenaAranzmana;
}