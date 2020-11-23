package edu.upc.dsa;

import edu.upc.dsa.models.Muestras;
import edu.upc.dsa.models.Persona;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Covid19ManagerImpTest {

    Covid19Manager manager;
    Persona p1;
    Persona p2;
    Muestras m;



    @Before
    public void setUp() throws Exception {
        this.manager = Covid19ManagerImp.getInstance();
        p1 = new Persona ("Jordi","rodriguez", "2020-01-01", "A");
        m = new Muestras("11","2020-05-10", "labA", "A", "comentario");        Persona p = this.manager.addPersona(p1);

    }

    @After
    public void tearDown(){
        this.manager.clearAll();
    }

    @Test
    public void testAddPersona() throws Exception {
        p2 = new Persona ("Miguel","rodriguez", "2020-01-01", "A");
        this.manager.addPersona(p2);
        Assert.assertEquals(2, this.manager.sizePersona());
    }

    @Test
    public void testextraerMuestra() throws Exception {
        m = new Muestras("11","2020-05-10", "labA", "A", "comentario");

        this.manager.extraerMuestra(m, "11", "labA");
        this.manager.procesarMuestra("labA");
        Assert.assertEquals(0, this.manager.sizeCola("labA"));

    }

}
