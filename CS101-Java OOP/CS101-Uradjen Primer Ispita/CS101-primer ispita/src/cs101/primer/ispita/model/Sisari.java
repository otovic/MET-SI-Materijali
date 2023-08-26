/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101.primer.ispita.model;

import cs101.primer.ispita.model.enums.TipIshrane;
import exceptions.NevalidanPodatakException;

/**
 *
 * @author profesor
 */
public class Sisari extends Zivotinja{
    //ishrana:enum, daLiJePitom:boolean
    private TipIshrane ishrana;
    private boolean pitom;

    public Sisari(TipIshrane ishrana, boolean pitom, String latinskiNaziv, int starost) throws NevalidanPodatakException {
        super(latinskiNaziv, starost);
        this.ishrana = ishrana;
        this.pitom = pitom;
    }

    public TipIshrane getIshrana() {
        return ishrana;
    }

    public void setIshrana(TipIshrane ishrana) {
        this.ishrana = ishrana;
    }

    public boolean isPitom() {
        return pitom;
    }

    public void setPitom(boolean pitom) {
        this.pitom = pitom;
    }

    @Override
    public String toString() {
        return "Sisari{" + "ishrana=" + ishrana + ", pitom=" + pitom + '}';
    }
    
    
}
