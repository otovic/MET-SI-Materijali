#include "Roditelj.h"
#include <iostream>

using namespace std;

Roditelj::Roditelj() : imeRoditelja(""), deca(nullptr), brojDece(0) {}

Roditelj::Roditelj(const string& imeRoditelja, int brojDece)
    : imeRoditelja(imeRoditelja), brojDece(brojDece), deca(nullptr) {
    deca = new string[brojDece];
    if (deca == nullptr) {
        cout << "Neuspesno alociranje memorije\n";
    }
}

Roditelj::Roditelj(const Roditelj& other)
    : imeRoditelja(other.imeRoditelja), brojDece(other.brojDece) {
    deca = new string[brojDece];
    for (int i = 0; i < brojDece; ++i) {
        deca[i] = other.deca[i];
    }
}

Roditelj::~Roditelj() {
    delete[] deca;
    cout << "Objekat je unisten" << endl;
}

void Roditelj::setImeRoditelja(const string& imeRoditelja) {
    this->imeRoditelja = imeRoditelja;
}

void Roditelj::setBrojDece(int brojDece) {
    delete[] deca;
    this->brojDece = brojDece;
    deca = new string[brojDece];
}

void Roditelj::setImeDeteta(int index, const string& imeDeteta) {
    if (index >= 0 && index < brojDece && deca != nullptr) {
        deca[index] = imeDeteta;
    }
    else {
        cout << "Nije moguće postaviti ime deteta." << endl;
    }
}

string Roditelj::getImeRoditelja() const {
    return imeRoditelja;
}

int Roditelj::getBrojDece() const {
    return brojDece;
}

string Roditelj::getImeDeteta(int index) const {
    if (index >= 0 && index < brojDece) return deca[index];
    return "";
}
