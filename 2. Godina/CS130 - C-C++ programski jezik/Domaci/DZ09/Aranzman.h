#ifndef ARANZMAN_H
#define ARANZMAN_H

#include <iostream>
#include <string>

using namespace std;

class Aranzman {
private:
    string imeAgencije;
    string imeHotela;
    string mesto;
    int brojNocenja;
    double cenaAranzmana;
    static int brojObjekata;

public:
    Aranzman();
    Aranzman(string agencija, string hotel, string mesto, int nocenja, double cena);
    ~Aranzman();
    static int getBrojObjekata();

    string getImeAgencije();
    string getImeHotela();
    string getMesto();
    int getBrojNocenja();
    double getCenaAranzmana();

    void setImeAgencije(string agencija);
    void setImeHotela(string hotel);
    void setMesto(string mesto);
    void setBrojNocenja(int nocenja);
    void setCenaAranzmana(double cena);

    double Prosek();

    friend ostream& operator<<(ostream& os, const Aranzman& aranzman);
    friend istream& operator>>(istream& is, Aranzman& aranzman);

    bool operator<(const Aranzman& other) const;
    bool operator>(const Aranzman& other) const;
    bool operator==(const Aranzman& other) const;
};

#endif