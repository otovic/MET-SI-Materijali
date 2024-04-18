#ifndef STUDENT_H
#define STUDENT_H

#include <string>

using namespace std;

class Student {
private:
    string ime;
    string prezime;
    float prosek;

public:
    Student();
    Student(const string& ime, const string& prezime, float prosek);
    Student(const Student& other);

    ~Student();

    void setIme(const string& ime);
    void setPrezime(const string& prezime);
    void setProsek(float prosek);

    string getIme() const;
    string getPrezime() const;
    float getProsek() const;
};

#endif