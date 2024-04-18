#ifndef RODITELJ_H
#define RODITELJ_H

#include <string>

using namespace std;

class Roditelj {
private:
    string imeRoditelja;
    string* deca;
    int brojDece;

public:
    Roditelj();
    Roditelj(const string& imeRoditelja, int brojDece);
    Roditelj(const Roditelj& other);

    ~Roditelj();

    void setImeRoditelja(const string& imeRoditelja);
    void setBrojDece(int brojDece);
    void setImeDeteta(int index, const string& imeDeteta);

    string getImeRoditelja() const;
    int getBrojDece() const;
    string getImeDeteta(int index) const;
};

#endif