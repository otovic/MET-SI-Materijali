/*
Kreirati C++ konzolnu aplikaciju koja podržava rad jednog supermaketa.

Neophodno je napraviti sledeće klase:

- Artikal; Svaki artikal ima naziv, cenu, šifru proizvoda i naziv proizvođača. Artikal je apstraktna klasa.

- Prehrambeni proizvod; Svaki prehrambeni prozvod je artikal. Za svaki prehrambeni prozvod čuvamo još i rok trajanja.

- Dnevna štampa; Dnevna štampa je u ponudi kao i ostali artikli. Za nju čuvamo još i datum izdavanja.

U glavnom programu prikazati princip polimorfizma, tj. testirati rad klasa Prehrambeni proizvod  i
Dnevna štampa korišćenjem pokazivača čiji je tip bazna klasa Artikal (pokazivač na baznu klasu).

Kreirati dva STL vektora, po jedan za prehrambene proizvode i dnevnu štampu.

Sa tastature uneti podatke za n < 5 prehrambenih proizvoda, i m < 5 časopisa dnevne štampe i spakovati
ih u odgovarajuće vektore. Nakon unosa elemenata, potrebno je sačuvati elemente oba vektora u tekstualni
fajl na disku (“Artikli.txt”): u jednoj liniji je tip artikla (0 – prehrambeni proizvod, 1 – dnevna štampa)
a u sledećoj liniji su podaci o artiklu (prehrambeni proizvod: naziv, cena, šifra, naziv proizvođača, rok
trajanja; dnevna štampa: naziv, cena, šifra, naziv proizvođača, datum izdavanja), i tako redom...
*/
#include <iostream>
#include <vector>
#include <fstream>
#include <string>

class Artikal
{
protected:
    std::string naziv;
    double cena;
    std::string sifra;
    std::string proizvodjac;

public:
    Artikal(std::string n, double c, std::string s, std::string p)
        : naziv(n), cena(c), sifra(s), proizvodjac(p) {}

    virtual ~Artikal() {}

    std::string getNaziv() const { return naziv; }
    double getCena() const { return cena; }
    std::string getSifra() const { return sifra; }
    std::string getProizvodjac() const { return proizvodjac; }

    virtual void ispisi() const = 0;
};

class PrehrambeniProizvod : public Artikal
{
    std::string rokTrajanja;

public:
    PrehrambeniProizvod(std::string n, double c, std::string s, std::string p, std::string r)
        : Artikal(n, c, s, p), rokTrajanja(r) {}

    std::string getRokTrajanja() const { return rokTrajanja; }

    void ispisi() const override
    {
        std::cout << "Prehrambeni proizvod: " << getNaziv() << ", " << getCena() << ", " << getSifra() << ", "
                  << getProizvodjac() << ", " << getRokTrajanja() << "\n";
    }
};

class DnevnaStampa : public Artikal
{
    std::string datumIzdavanja;

public:
    DnevnaStampa(std::string n, double c, std::string s, std::string p, std::string d)
        : Artikal(n, c, s, p), datumIzdavanja(d) {}

    std::string getDatumIzdavanja() const { return datumIzdavanja; }

    void ispisi() const override
    {
        std::cout << "Dnevna stampa: " << getNaziv() << ", " << getCena() << ", " << getSifra() << ", "
                  << getProizvodjac() << ", " << getDatumIzdavanja() << "\n";
    }
};

int main()
{
    std::vector<Artikal *> artikli;
    std::vector<PrehrambeniProizvod> prehrambeniProizvodi;
    std::vector<DnevnaStampa> stampa;

    // Sample Usage:
    PrehrambeniProizvod pp("Milk", 100.0, "001", "DairyCo", "12-12-2023");
    DnevnaStampa ds("Daily News", 50.0, "002", "NewsCo", "11-11-2022");

    artikli.push_back(&pp);
    artikli.push_back(&ds);

    for (const auto &artikal : artikli)
    {
        std::cout << "Naziv: " << artikal->getNaziv()
                  << ", Cena: " << artikal->getCena()
                  << ", Sifra: " << artikal->getSifra()
                  << ", Proizvodjac: " << artikal->getProizvodjac()
                  << std::endl;
        artikal->ispisi();
    }

    // Add to the specific vectors
    prehrambeniProizvodi.push_back(pp);
    stampa.push_back(ds);

    // Further logic for saving to a file would go here...
    // Saving to a file
    std::ofstream outFile("Artikli.txt");
    if (!outFile)
    {
        std::cerr << "Error opening file for writing!" << std::endl;
        return 1; // Exit with an error code
    }

    for (const auto &proizvod : prehrambeniProizvodi)
    {
        outFile << "0" << std::endl; // 0 for prehrambeni proizvod
        outFile << proizvod.getNaziv() << ", "
                << proizvod.getCena() << ", "
                << proizvod.getSifra() << ", "
                << proizvod.getProizvodjac() << ", "
                << proizvod.getRokTrajanja() << std::endl;
    }

    for (const auto &casopis : stampa)
    {
        outFile << "1" << std::endl; // 1 for dnevna štampa
        outFile << casopis.getNaziv() << ", "
                << casopis.getCena() << ", "
                << casopis.getSifra() << ", "
                << casopis.getProizvodjac() << ", "
                << casopis.getDatumIzdavanja() << std::endl;
    }

    outFile.close();

    return 0;
}
