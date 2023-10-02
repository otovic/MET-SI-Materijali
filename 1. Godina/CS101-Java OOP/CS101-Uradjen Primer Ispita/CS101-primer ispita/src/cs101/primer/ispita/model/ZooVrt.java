/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101.primer.ispita.model;

import cs101.primer.ispita.model.enums.TipPtice;
import exceptions.NevalidanPodatakException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author profesor
 */
public class ZooVrt {
//    ZooVrt(naziv, adresa, grad, vlasnik:Vlasnik
//, lista zivotinja) 

    private String naziv;
    private String adresa;
    private String grad;
    private Vlasnik vlasnik;
    private List<Zivotinja> zivotinje = new ArrayList<>();

    public ZooVrt() {
    }

    public ZooVrt(String naziv, String adresa, String grad, Vlasnik vlasnik) throws NevalidanPodatakException {
        setNaziv(naziv);
        this.adresa = adresa;
        this.grad = grad;
        this.vlasnik = vlasnik;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) throws NevalidanPodatakException {
        if (naziv.length() >= 5
                && Character.isUpperCase(naziv.charAt(0))
                && Character.isLowerCase(naziv.charAt(1))) {
            this.naziv = naziv;
        } else {
            throw new NevalidanPodatakException("Ime nije validno!");
        }
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public Vlasnik getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(Vlasnik vlasnik) {
        this.vlasnik = vlasnik;
    }

    public List<Zivotinja> getZivotinje() {
        return zivotinje;
    }

    public void setZivotinje(List<Zivotinja> zivotinje) {
        this.zivotinje = zivotinje;
    }

    @Override
    public String toString() {
        return "ZooVrt{" + "naziv=" + naziv + ", adresa=" + adresa + ", grad=" + grad + ", vlasnik=" + vlasnik + ", zivotinje=" + zivotinje + '}';
    }

    public List<Ptica> pticePevacice() {
        List<Ptica> pticePevacice = new ArrayList<>();
        for (Zivotinja zivotinja : zivotinje) {
            if (zivotinja instanceof Ptica) {
                Ptica ptica = (Ptica) zivotinja;
                if (ptica.getTipPtice() == TipPtice.pevacica) {
                    pticePevacice.add(ptica);
                }
            }
        }

        Collections.sort(pticePevacice, Comparator.reverseOrder());
        return pticePevacice;
    }

    public double prosecnaTemperatura() {
        double sumaTemp = 0;
        int count = 0;
        for (Zivotinja zivotinja : zivotinje) {
            if (zivotinja instanceof Gmizavac) {
                Gmizavac g = (Gmizavac) zivotinja;
                if (g.isOtrovan()) {
                    sumaTemp += g.getTemperatura();
                    count++;
                }
            }
        }

        if(count == 0) {
            return 0;
        }
        
        return sumaTemp / count;
    }

}
