package com.avaca.asistirandroid.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Asistencia implements Serializable {
    public int Id ;
    public boolean Asitencia ;
    public boolean Justificada ;
    public String Descripcion ;
    public String Imagen ;
    public int AlumnoCursoId ;
    public AlumnoCurso AlumnoCurso ;

    public Asistencia(int id, boolean asitencia, boolean justificada, String descripcion, String imagen, int alumnoCursoId, com.avaca.asistirandroid.modelo.AlumnoCurso alumnoCurso) {
        Id = id;
        Asitencia = asitencia;
        Justificada = justificada;
        Descripcion = descripcion;
        Imagen = imagen;
        AlumnoCursoId = alumnoCursoId;
        AlumnoCurso = alumnoCurso;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public boolean isAsitencia() {
        return Asitencia;
    }

    public void setAsitencia(boolean asitencia) {
        Asitencia = asitencia;
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

    public void setAlumnoCurso(com.avaca.asistirandroid.modelo.AlumnoCurso alumnoCurso) {
        AlumnoCurso = alumnoCurso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
