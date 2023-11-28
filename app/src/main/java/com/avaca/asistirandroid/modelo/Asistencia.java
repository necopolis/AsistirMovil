package com.avaca.asistirandroid.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Asistencia implements Serializable {
    public int Id ;
    public boolean Inasistencia ;
    public boolean Justificada ;
    public String Descripcion ;
    public String Imagen ;
    public int AlumnoCursoId ;
    public AlumnoCurso AlumnoCurso = new AlumnoCurso() ;

    public Asistencia(int id, boolean Inasistencia, boolean justificada, String descripcion, String imagen, int alumnoCursoId, AlumnoCurso alumnoCurso) {
        this.Id = id;
        this.Inasistencia = Inasistencia;
        this.Justificada = justificada;
        this.Descripcion = descripcion;
        this.Imagen = imagen;
        this.AlumnoCursoId = alumnoCursoId;
        this.AlumnoCurso = alumnoCurso;
    }

    public Asistencia() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public boolean isInasistencia() {
        return Inasistencia;
    }

    public void setAsitencia(boolean inasistencia) {
        Inasistencia = inasistencia;
    }

    public boolean isJustificada() {
        return Justificada;
    }

    public void setJustificada(boolean justificada) {
        Justificada = justificada;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public int getAlumnoCursoId() {
        return AlumnoCursoId;
    }

    public void setAlumnoCursoId(int alumnoCursoId) {
        AlumnoCursoId = alumnoCursoId;
    }

    public com.avaca.asistirandroid.modelo.AlumnoCurso getAlumnoCurso() {
        return AlumnoCurso;
    }

    public void setAlumnoCurso(AlumnoCurso alumnoCurso) {
        AlumnoCurso = alumnoCurso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
