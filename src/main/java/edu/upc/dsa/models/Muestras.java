package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Muestras {

    private String id;
    private String idClinico;
    private String idPersonaExtraida;
    private String fechaExtraccion;
    private String idLab;
    private String estado;
    private String comentario;

    public Muestras() {
        this.id = RandomUtils.getId();
        this.idClinico = RandomUtils.getId();

    }

    public Muestras(String idPersonaExtraida, String fechaExtraccion, String idLab, String estado, String comentario) {
        this();
        this.idClinico = idClinico;
        this.idPersonaExtraida = idPersonaExtraida;
        this.fechaExtraccion = fechaExtraccion;
        this.idLab = idLab;
        this.estado = estado;
        this.comentario = comentario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdClinico() {
        return idClinico;
    }

    public void setIdClinico(String idClinico) {
        this.idClinico = idClinico;
    }

    public String getIdPersonaExtraida() {
        return idPersonaExtraida;
    }

    public void setIdPersonaExtraida(String idPersonaExtraida) {
        this.idPersonaExtraida = idPersonaExtraida;
    }

    public String getFechaExtraccion() {
        return fechaExtraccion;
    }

    public void setFechaExtraccion(String fechaExtraccion) {
        this.fechaExtraccion = fechaExtraccion;
    }

    public String getIdLab() {
        return idLab;
    }

    public void setIdLab(String idLab) {
        this.idLab = idLab;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Muestras{" +
                "id='" + id + '\'' +
                ", idClinico='" + idClinico + '\'' +
                ", idPersonaExtraida='" + idPersonaExtraida + '\'' +
                ", fechaExtraccion='" + fechaExtraccion + '\'' +
                ", idLab='" + idLab + '\'' +
                ", estado='" + estado + '\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
