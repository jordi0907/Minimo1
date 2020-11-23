package edu.upc.dsa;

import edu.upc.dsa.models.Laboratorios;
import edu.upc.dsa.models.Muestras;
import edu.upc.dsa.models.Persona;
import org.apache.log4j.Logger;

import java.util.*;

public class Covid19ManagerImp implements  Covid19Manager{

    private static Covid19Manager instance;
    protected List<Muestras> muestrasList;
    protected List<Laboratorios> laboratoriosList;
    protected HashMap<String, Persona> personasContendor;
    protected Queue<Muestras> colaLabA;
    protected Queue<Muestras> colaLabB;
    protected Queue<Muestras> colaLabC;

    final static Logger logger = Logger.getLogger(Covid19ManagerImp.class);
    Laboratorios labA;
    Laboratorios labB;
    Laboratorios labC;


    private Covid19ManagerImp() {
        this.muestrasList = new LinkedList<>();
        this.laboratoriosList = new ArrayList<>();
        this.personasContendor = new HashMap<String, Persona>();
        labA = new Laboratorios("labA","labA");
        labB = new Laboratorios("labB", "labB");
        labC = new Laboratorios("labC","labC");
        logger.info("añadido laboratorio labA " + labA);
        logger.info("añadido laboratorio labB " + labB);
        logger.info("añadido laboratorio labC " + labC);

        this.laboratoriosList.add(labA);
        this.laboratoriosList.add(labB);
        this.laboratoriosList.add(labC);

        this.colaLabA = new LinkedList<>();
        this.colaLabB = new LinkedList<>();
        this.colaLabC = new LinkedList<>();

    }


    public static Covid19Manager getInstance() {
        if (instance==null) instance = new Covid19ManagerImp();
        return instance;
    }



    @Override
    public Persona addPersona(Persona p) {
        this.personasContendor.put(p.getId(),p);
        logger.info("persona añadida" +p);
        return p;


    }

    @Override
    public Muestras extraerMuestra(Muestras m,String idPersona, String idLab) {

       /* Persona p = new Persona();
        personasContendor(idPersona)*/

        logger.info("la muestra es  " + m);
        switch (idLab){
            case "labA" :
                this.colaLabA.add(m);
                logger.info("añadido la muestra al labA " + m);
                break;
            case "labB" :
                this.colaLabB.add(m);
                logger.info("añadido la muestra al labB " + m);
                break;
            case "labC" :
                this.colaLabC.add(m);
                logger.info("añadido la muestra al labC " + m);
                break;
            default:
                logger.error("error al introducir la muestra " +m );
        }

        return m;
    }

    @Override
    public Muestras procesarMuestra(String idLab) {
        Muestras m = null;
        Persona p;

        switch (idLab){
            case "labA" :
                m = this.colaLabA.poll();
                logger.info("se ha quitado muestra del labA " + m);
                this.personasContendor.get(m.getIdPersonaExtraida()).getListaMuestra().add(m);
                logger.info("Muestra añadida " + m + "a la persona " +this.personasContendor.get(m.getIdPersonaExtraida()));
                break;
            case "labB" :
                m = this.colaLabB.poll();
                logger.info("se ha quitado muestra del labB " + m);
                this.personasContendor.get(m.getIdPersonaExtraida()).getListaMuestra().add(m);
                logger.info("Muestra añadida " + m + "a la persona " +this.personasContendor.get(m.getIdPersonaExtraida()));
                break;
            case "labC" :
                m = this.colaLabB.poll();
                logger.info("se ha quitado muestra del labC" + m);
                this.personasContendor.get(m.getIdPersonaExtraida()).getListaMuestra().add(m);
                logger.info("Muestra añadida " + m + "a la persona " +this.personasContendor.get(m.getIdPersonaExtraida()));
                break;
            default:
                logger.error("error al quitar la muestra");
        }

        return m;
    }

    @Override
    public List<Muestras> listarMuestras(String idPersona) {
        this.personasContendor.get(idPersona).getListaMuestra();
        return  this.personasContendor.get(idPersona).getListaMuestra();

    }

    @Override
    public int sizePersona() {
        return this.personasContendor.size();
    }

    @Override
    public int sizeCola(String idLab) {
        return this.colaLabA.size();
    }

    @Override
    public void clearAll() {
        this.personasContendor.clear();
        this.colaLabA.clear();

    }
}
