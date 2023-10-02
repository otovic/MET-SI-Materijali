/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author profesor
 */
public class ZooVrtTest {

    public ZooVrtTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1() throws NevalidanPodatakException {
        Ptica ptica1 = new Ptica(TipPtice.trkacica, 2, "adf", 2);
        Ptica ptica2 = new Ptica(TipPtice.trkacica, 3, "adf", 3);
        Gmizavac g1 = new Gmizavac(true, 60, "a", 2);
        Gmizavac g2 = new Gmizavac(false, 50, "b", 2);
        Gmizavac g3 = new Gmizavac(true, 100, "c", 2);
        Gmizavac g4 = new Gmizavac(true, 200, "d", 2);
        
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
        
        double expectedResult = 120.0;
        
        double actualResult = zoo.prosecnaTemperatura();
        
        assertEquals(expectedResult, actualResult, 0.000000000001);
        
    }
    
    @Test
    public void test2() throws NevalidanPodatakException {
        Ptica ptica1 = new Ptica(TipPtice.trkacica, 2, "adf", 2);
        Ptica ptica2 = new Ptica(TipPtice.trkacica, 3, "adf", 3);
//        Gmizavac g1 = new Gmizavac(true, 60, "a", 2);
//        Gmizavac g2 = new Gmizavac(false, 50, "b", 2);
//        Gmizavac g3 = new Gmizavac(true, 100, "c", 2);
//        Gmizavac g4 = new Gmizavac(true, 200, "d", 2);
        
        List<Zivotinja> listaZivotinja = new ArrayList<>();
        listaZivotinja.add(ptica1);
        listaZivotinja.add(ptica2);
//        listaZivotinja.add(g1);
//        listaZivotinja.add(g2);
//        listaZivotinja.add(g3);
//        listaZivotinja.add(g4);
        
        ZooVrt zoo = new ZooVrt("Jagodina", "", "Jagodina",
                new Vlasnik("1234567891234", "Marko", "Markovic", Pol.MUSKI, 50));
        
        zoo.setZivotinje(listaZivotinja);
        
        double expectedResult = 0.0;
        
        double actualResult = zoo.prosecnaTemperatura();
        
        assertEquals(expectedResult, actualResult, 0.000000000001);
        
    }
    
        @Test
    public void test3() throws NevalidanPodatakException {
        Ptica ptica1 = new Ptica(TipPtice.trkacica, 2, "adf", 2);
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
        
        double expectedResult = 0.0;
        
        double actualResult = zoo.prosecnaTemperatura();
        
        assertEquals(expectedResult, actualResult, 0.000000000001);
        
    }
}
