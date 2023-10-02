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
public class Gmizavac extends Zivotinja implements Comparable<Gmizavac> {

    private boolean otrovan;
    private double temperatura;

    public Gmizavac(boolean otrovan, double temperatura, String latinskiNaziv, int starost) throws NevalidanPodatakException {
        super(latinskiNaziv, starost);
        this.otrovan = otrovan;
        this.temperatura = temperatura;
    }

    public boolean isOtrovan() {
        return otrovan;
    }

    public void setOtrovan(boolean otrovan) {
        this.otrovan = otrovan;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "Gmizavac{" + "otrovan=" + otrovan + ", temperatura=" + temperatura + '}';
    }

    @Override
    public int compareTo(Gmizavac g) {
        if (this.otrovan && !g.otrovan) {
            return 1;
        } else if ((this.otrovan == g.otrovan)) {
            if (this.temperatura == g.temperatura) {
                return 0;
            } else if (this.temperatura > g.temperatura) {
                return 1;
            }
        }
        
        return -1;
    }

}
