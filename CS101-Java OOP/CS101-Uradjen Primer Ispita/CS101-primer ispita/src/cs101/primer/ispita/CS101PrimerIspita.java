/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101.primer.ispita;

import cs101.primer.ispita.model.Gmizavac;
import cs101.primer.ispita.model.Ptica;
import cs101.primer.ispita.model.Vlasnik;
import cs101.primer.ispita.model.Zivotinja;
import cs101.primer.ispita.model.ZooVrt;
import cs101.primer.ispita.model.enums.Pol;
import cs101.primer.ispita.model.enums.TipPtice;
import exceptions.NevalidanPodatakException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author profesor
 */
public class CS101PrimerIspita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Ptica ptica1 = new Ptica(TipPtice.pevacica, 2, "adf", 2);
            Ptica ptica2 = new Ptica(TipPtice.trkacica, 3, "adf", 3);
            Gmizavac g1 = new Gmizavac(false, 60, "a", 2);
            Gmizavac g2 = new Gmizavac(false, 50, "b", 2);
            Gmizavac g3 = new Gmizavac(false, 100, "c", 2);
            Gmizavac g4 = new Gmizavac(false, 200, "d", 2);

            List<Zivotinja> listaZivotinja = new ArrayList<>();
            listaZivotinja.add(ptica1);
            listaZivotinja.add(ptica2);
            listaZivotinja.add(g1);
            listaZivotinja.add(g2);
            listaZivotinja.add(g3);
            listaZivotinja.add(g4);

            ZooVrt zoo = new ZooVrt("Jagodina", "", "Jagodina",
                    new Vlasnik("1234567891234", "Marko", "Markovic", Pol.MUSKI, 50));

            zoo.setZivotinje(listaZivotinja);

            System.out.println(zoo.pticePevacice());
            System.out.println(zoo.prosecnaTemperatura());

        } catch (NevalidanPodatakException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
