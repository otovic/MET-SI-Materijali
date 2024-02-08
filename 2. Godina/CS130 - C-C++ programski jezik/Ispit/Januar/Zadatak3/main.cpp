/*
Napisati program (C ili C++) kojim se učitavaju 2 stringa str1 i str2.

Odrediti sledeće:

- string s3 koji se dobija spajanjem prva 3 karaktera stringa s1 i poslednja 3
karaktera stringa s2. Ukoliko stringovi poseduju manje od traženog broja karaktera
odštampati objavnu (ASSERT) poruku  (C jezik) ili izbaciti izuzetak ManjeOdTriKarakteraException
(C++ jezik), koji je izveden iz klase std::exception.

- Ispitati da li se u stringovima s1 i s2 javlja string “CS323”, Ukoliko je odgovor
“ne” onda ispitati da li u se u spojenom stringu s3 javlja string “CS323”.

- Iz stringova s1, s2 i s3 izbaciti svako pojavljivanje slova “c”. Uzeti u obzir i
mala i velika slova (Primer:  “Circulation”, Izlaz:  “irulation”).
*/

#include <iostream>
#include <string>
#include <exception>

class ManjeOdTriKarakteraException : public std::exception
{
public:
    const char *what() const noexcept override
    {
        return "String ima manje od tri karaktera!";
    }
};

std::string spajanje(const std::string &s1, const std::string &s2)
{
    if (s1.length() < 3 || s2.length() < 3)
    {
        throw ManjeOdTriKarakteraException();
    }
    return s1.substr(0, 3) + s2.substr(s2.length() - 3);
}

bool sadrziCS323(const std::string &str)
{
    return str.find("CS323") != std::string::npos;
}

std::string izbaciC(const std::string &str)
{
    std::string rezultat;
    for (char c : str)
    {
        if (c != 'c' && c != 'C')
        {
            rezultat.push_back(c);
        }
    }
    return rezultat;
}

int main()
{
    std::string s1, s2;

    std::cin.ignore(); // Preskoči novi red nakon poslednjeg unosa

    std::cout << "Unesite prvi string (s1): ";
    std::getline(std::cin, s1);

    std::cout << "Unesite drugi string (s2): ";
    std::getline(std::cin, s2);

    try
    {
        std::string s3 = spajanje(s1, s2);
        std::cout << "Spojeni string (s3) je: " << s3 << std::endl;

        if (!sadrziCS323(s1) && !sadrziCS323(s2) && sadrziCS323(s3))
        {
            std::cout << "String 'CS323' se ne nalazi ni u s1 ni u s2, ali se nalazi u s3." << std::endl;
        }

        std::cout << "s1 bez slova 'c' i 'C' je: " << izbaciC(s1) << std::endl;
        std::cout << "s2 bez slova 'c' i 'C' je: " << izbaciC(s2) << std::endl;
        std::cout << "s3 bez slova 'c' i 'C' je: " << izbaciC(s3) << std::endl;
    }
    catch (ManjeOdTriKarakteraException &e)
    {
        std::cerr << "Greska: " << e.what() << std::endl;
    }

    return 0;
}
