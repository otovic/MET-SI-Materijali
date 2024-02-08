/*
Učitati jednu liniju teksta sa tastature i spakovati je u
string str1. Uraditi sledeće:

- Kreirati stringove s2 i s3 iz stringa str1 tako što deo stringa
str1 do pojave prvog znaka pitanja  “?” prelazi u string s2, a deo nakon
upitnika prelazi u string s3. Ukoliko string ne poseduje upitnik odštampati
objavnu (ASSERT) poruku (C jezik) ili izbaciti izuzetak tipa StringNemaUpitnikException
(C++ jezik), koji je izveden iz klase std::exception.

- Ispitati da li se u stringovima s2 i s3 javlja string “C/C++”,
Ukoliko je odgovor “ne” onda ispitati da li u se u originalnom stringu str1 javlja string “C/C++”.

- U stringu s3 zameniti svako pojavljivanje slova “a” brojem “2”.
Algoritam treba da proverava i mala i velika slova.
*/

#include <iostream>
#include <string>
#include <exception>

// Izuzetak koji se baca kada string nema upitnik
class StringNemaUpitnikException : public std::exception
{
public:
    const char *what() const noexcept override
    {
        return "String ne sadrzi upitnik!";
    }
};

int main()
{
    std::string str1, s2, s3;

    // Učitavanje stringa sa tastature
    std::cout << "Unesite string: ";
    std::getline(std::cin, str1);

    // Provera da li string sadrži upitnik
    size_t found = str1.find("?");
    if (found == std::string::npos)
    {
        throw StringNemaUpitnikException();
    }

    // Kreiranje stringova s2 i s3
    s2 = str1.substr(0, found);
    s3 = str1.substr(found + 1);

    // Ispitivanje da li se string "C/C++" javlja u s2 ili s3
    if (s2.find("C/C++") == std::string::npos && s3.find("C/C++") == std::string::npos)
    {
        if (str1.find("C/C++") != std::string::npos)
        {
            std::cout << "Originalni string str1 sadrzi 'C/C++'." << std::endl;
        }
        else
        {
            std::cout << "'C/C++' se ne pojavljuje ni u s2, ni u s3, ni u str1." << std::endl;
        }
    }

    // Zamena svih pojavljivanja slova 'a' ili 'A' sa brojem '2' u stringu s3
    for (size_t i = 0; i < s3.size(); ++i)
    {
        if (s3[i] == 'a' || s3[i] == 'A')
        {
            s3[i] = '2';
        }
    }

    std::cout << "String s2: " << s2 << std::endl;
    std::cout << "String s3: " << s3 << std::endl;

    return 0;
}
