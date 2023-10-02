/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101.primer.ispita;

import cs101.primer.ispita.model.Gmizavac;
import cs101.primer.ispita.model.Ptica;
import cs101.primer.ispita.model.Sisari;
import cs101.primer.ispita.model.Zivotinja;
import cs101.primer.ispita.model.ZooVrt;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author profesor
 */
public class FileUtil {

    public static void upisUFajl(ZooVrt zoo) {
        try {
            PrintWriter writer = new PrintWriter("zoo_vrt.txt");

            writer.print(zoo.getNaziv() + " - "
                    + zoo.getAdresa() + " - "
                    + zoo.getGrad() + " - "
                    + zoo.getVlasnik().getIme() + " "
                    + zoo.getVlasnik().getPrezime());
            writer.println();

            for (Zivotinja zivotinja : zoo.getZivotinje()) {
                writer.print(zivotinja.getLatinskiNaziv() + " - "
                        + zivotinja.getStarost());
                writer.println();
                if (zivotinja instanceof Ptica) {
                    writer.print(((Ptica) zivotinja).getTipPtice()
                            + " " + ((Ptica) zivotinja).getTrajanjeLeta());
                } else if (zivotinja instanceof Gmizavac) {
                    writer.print(((Gmizavac) zivotinja).isOtrovan()
                            + " "
                            + ((Gmizavac) zivotinja).getTemperatura());
                } else if (zivotinja instanceof Sisari) {
                    writer.print(((Sisari) zivotinja).getIshrana() + " "
                            + ((Sisari) zivotinja).isPitom());
                }
                writer.println();

            }

            writer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
