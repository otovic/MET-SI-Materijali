package binarno_stablo.zadatak2;

class Cvor {
    int vrednost;
    Cvor levo;
    Cvor desno;

    // Konstruktor
    Cvor(int vrednost) {
        this.vrednost = vrednost;
        this.levo = null;
        this.desno = null;
    }
}
