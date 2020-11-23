package edu.upc.dsa;

import edu.upc.dsa.models.Muestras;
import edu.upc.dsa.models.Persona;

import java.util.List;

public interface Covid19Manager {

    public Persona addPersona(Persona p);
    public Muestras extraerMuestra(Muestras m,String idPersona, String idlab);
    public Muestras procesarMuestra(String idLab);
    public List<Muestras> listarMuestras(String idPersona);
    public int sizePersona();
    public int sizeCola(String idLab);
    public void clearAll();

}
