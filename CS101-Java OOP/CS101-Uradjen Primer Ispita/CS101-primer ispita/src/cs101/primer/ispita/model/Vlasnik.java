/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101.primer.ispita.model;

import cs101.primer.ispita.model.enums.Pol;
import exceptions.NevalidanPodatakException;

/**
 *
 * @author profesor
 */
public class Vlasnik {
    private String jmbg;
    private String ime;
    private String prezime;
    private Pol pol;
    private int godine;

    public Vlasnik() {
    }

    public Vlasnik(String jmbg, String ime, String prezime, Pol pol, int godine) throws NevalidanPodatakException {
        setJmbg(jmbg);
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        setGodine(godine);
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) throws NevalidanPodatakException {
        if(jmbg.length() == 13 ){
            this.jmbg = jmbg;
        }else{
            throw new NevalidanPodatakException(
                    "JMBG mora da ima 13 cifara!");
        }
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

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) throws NevalidanPodatakException {
        if(godine>=18){
             this.godine = godine;
        }else{
            throw  new 
        NevalidanPodatakException("Godine > 18!");
        }
    }

    @Override
    public String toString() {
        return "Vlasnik{" + "jmbg=" + jmbg + ", ime=" + ime + ", prezime=" + prezime + ", pol=" + pol + ", godine=" + godine + '}';
    }
    
    
}
