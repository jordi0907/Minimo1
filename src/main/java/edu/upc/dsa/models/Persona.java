package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.LinkedList;

public class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String valoracion; // A,B,C,D de menos avanzado A a mas avanzado D
    private LinkedList<Muestras> listaMuestra;

    public Persona() {
        this.id = RandomUtils.getId();
    }

    public Persona(String nombre, String apellido, String fechaNacimiento, String valoracion) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.valoracion = valoracion;
        /*this.listaMuestra = null;*/
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public LinkedList<Muestras> getListaMuestra() {
        return listaMuestra;
    }

    public void setListaMuestra(LinkedList<Muestras> listaMuestra) {
        this.listaMuestra = listaMuestra;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", valoracion='" + valoracion + '\'' +
                ", listaMuestra=" + listaMuestra +
                '}';
    }
}
