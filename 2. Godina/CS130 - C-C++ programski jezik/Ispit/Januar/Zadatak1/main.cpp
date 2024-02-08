/*
Napisati C++ konzolnu aplikaciju na osnovu sledećeg teksta.

Fakultet ima studente i zaposlene. O studentima čuvamo: ime, prezime, adresa, broj telefona i indeks.
O zaposlenima čuvamo: ime, prezime, adresa, broj telefona kao i id.

Kreirati apstraktnu klasu Osoba koja ima zajedničke podatke za studente i zaposlene i sadrži čisto
virtuelnu funkciju Info().

Klase Student i Zaposleni su izvedene iz klase Osoba.

Kreirati predefinisanu funkciju Info() klase Student koja osim opštih podataka o osobi štampa i
podatak o broju indeksa, dok kod klase Zaposleni funkcija Info() osim opštih podataka o osobi štampa i podatak o ID-u zaposlenog.

U glavnom (main) programu prikazati princip polimorfizma, tj. testirati rad klase Student korišćenjem
pokazivača čiji je tip bazna klasa Osoba (pokazivač na baznu klasu).

Kao parametar pri startovanju programa prosleđuje se ime tekstualne datoteke sa podacima o osobama: u
jednoj liniji je tip osobe (0 – student, 1 – zaposleni) a u sledećoj liniji su podaci o osobi (Student:
ime, prezime, adresa, indeks;  Zaposleni: ime, prezime, adresa,  ID), i tako redom.

Podatke iz tekstualne datoteke sačuvati u dva STL vektora, po jedan za studente i zaposlene.
*/

#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <sstream>

class Osoba
{
protected:
    std::string ime, prezime, adresa, broj_telefona;

public:
    virtual void Info() const = 0;
};

class Student : public Osoba
{
private:
    std::string indeks;

public:
    Student(const std::string &i, const std::string &p, const std::string &a, const std::string &bt, const std::string &idx)
        : indeks(idx)
    {
        ime = i;
        prezime = p;
        adresa = a;
        broj_telefona = bt;
    }
    void Info() const override
    {
        std::cout << "Student: " << ime << " " << prezime << ", Adresa: " << adresa
                  << ", Broj telefona: " << broj_telefona << ", Indeks: " << indeks << std::endl;
    }
};

class Zaposleni : public Osoba
{
private:
    std::string id;

public:
    Zaposleni(const std::string &i, const std::string &p, const std::string &a, const std::string &bt, const std::string &ID)
        : id(ID)
    {
        ime = i;
        prezime = p;
        adresa = a;
        broj_telefona = bt;
    }
    void Info() const override
    {
        std::cout << "Zaposleni: " << ime << " " << prezime << ", Adresa: " << adresa
                  << ", Broj telefona: " << broj_telefona << ", ID: " << id << std::endl;
    }
};

int main(int argc, char **argv)
{
    if (argc != 2)
    {
        std::cout << "Koristi: " << argv[0] << " fajl.txt" << std::endl;
        return 1;
    }
    std::ifstream ulaz(argv[1]);
    if (!ulaz)
    {
        std::cout << "Ne može se otvoriti datoteka!" << std::endl;
        return 1;
    }

    std::vector<Student> studenti;
    std::vector<Zaposleni> zaposleni;

    std::string linija;
    while (getline(ulaz, linija))
    {
        int tip = stoi(linija);
        getline(ulaz, linija);
        std::stringstream ss(linija);
        std::string ime, prezime, adresa, bt, dodatno;
        ss >> ime >> prezime >> adresa >> bt >> dodatno;
        if (tip == 0)
        {
            studenti.emplace_back(ime, prezime, adresa, bt, dodatno);
        }
        else if (tip == 1)
        {
            zaposleni.emplace_back(ime, prezime, adresa, bt, dodatno);
        }
    }

    // Demonstracija polimorfizma
    for (const auto &s : studenti)
    {
        Osoba *os = (Osoba *)&s;
        os->Info();
    }

    for (const auto &z : zaposleni)
    {
        z.Info();
    }

    return 0;
}
