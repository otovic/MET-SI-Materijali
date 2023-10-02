/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101.primer.ispita.model;

import exceptions.NevalidanPodatakException;

/**
 *
 * @author profesor
 */
public abstract class Zivotinja {

    private String latinskiNaziv;
    private int starost;

    public Zivotinja() {
    }

    public Zivotinja(String latinskiNaziv, int starost) throws NevalidanPodatakException {
        this.latinskiNaziv = latinskiNaziv;
        setStarost(starost);
    }

    public String getLatinskiNaziv() {
        return latinskiNaziv;
    }

    public void setLatinskiNaziv(String latinskiNaziv) {
        this.latinskiNaziv = latinskiNaziv;
    }

    public int getStarost() {
        return starost;
    }

    public void setStarost(int starost) throws NevalidanPodatakException {
        if (starost > 0) {
            this.starost = starost;
        } else {
            throw new NevalidanPodatakException("Negativan broj!");
        }

    }

    @Override
    public String toString() {
        return "Zivotnja{" + "latinskiNaziv=" + latinskiNaziv + ", starost=" + starost + '}';
    }

}
