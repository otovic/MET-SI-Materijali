package fajlovi.zadatak8;

public class Student {

    private String indeks;
    private String ime;
    private String prezime;
    private int prosek;

    public Student() {

    }

    public Student(String indeks, String ime, String prezime, int prosek) {
        this.indeks = indeks;
        this.ime = ime;
        this.prezime = prezime;
        this.prosek = prosek;
    }

    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getProsek() {
        return prosek;
    }

    public void setProsek(int prosek) {
        this.prosek = prosek;
    }

    @Override
    public String toString() {
        return "Student{" + "indeks=" + indeks + ", ime=" + ime + ", prezime=" + prezime + ", prosek=" + prosek + '}';
    }

}
