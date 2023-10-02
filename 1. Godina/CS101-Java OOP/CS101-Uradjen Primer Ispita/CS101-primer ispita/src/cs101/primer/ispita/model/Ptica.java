/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101.primer.ispita.model;

import cs101.primer.ispita.model.enums.TipPtice;
import exceptions.NevalidanPodatakException;

/**
 *
 * @author profesor
 */
public class Ptica extends Zivotinja implements Comparable<Ptica>{
    private TipPtice tipPtice;
    private double trajanjeLeta; 

    public Ptica(TipPtice tipPtice, double trajanjeLeta, String latinskiNaziv, int starost) throws NevalidanPodatakException {
        super(latinskiNaziv, starost);
        this.tipPtice = tipPtice;
        this.trajanjeLeta = trajanjeLeta;
    }

    public TipPtice getTipPtice() {
        return tipPtice;
    }

    public void setTipPtice(TipPtice tipPtice) {
        this.tipPtice = tipPtice;
    }

    public double getTrajanjeLeta() {
        return trajanjeLeta;
    }

    public void setTrajanjeLeta(double trajanjeLeta) {
        this.trajanjeLeta = trajanjeLeta;
    }

    @Override
    public String toString() {
        return "Ptica{" + "tipPtice=" + tipPtice + ", trajanjeLeta=" + trajanjeLeta + '}';
    }

    @Override
    public int compareTo(Ptica ptica) {
        // this       ptica 
        if(this.trajanjeLeta == ptica.trajanjeLeta){
            return 0;
        }else if(this.trajanjeLeta > ptica.trajanjeLeta){
            return 1;
        }
        
        return -1;
        
       // return Double.compare(this.trajanjeLeta, ptica.trajanjeLeta);
    }


    
    
}
